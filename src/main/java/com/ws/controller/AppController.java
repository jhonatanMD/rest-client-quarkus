package com.ws.controller;

import com.ws.model.Customer;
import com.ws.model.Person;
import com.ws.model.ResultConstraint;
import com.ws.model.dto.CustomerResponse;
import com.ws.proxy.ApiLocalProxyConsumer;
import com.ws.proxy.ApiProxyConsumer;
import org.apache.http.HttpStatus;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

@Path("/v1")
public class AppController {


    @Inject
    @RestClient
    private ApiProxyConsumer apiProxyConsumer;


    @Inject
    @RestClient
    private ApiLocalProxyConsumer apiLocalProxyConsumer;


    @Inject
    private Validator validator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPE() {
        return Response.ok(apiProxyConsumer.getCountryPE()).build();
    }

    @GET
    @Path("/ec")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEC() {
        return Response.ok(apiProxyConsumer.getCountryEC()).build();
    }


    @GET
    @Path("/persons")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersons() {
        return Response.ok(apiLocalProxyConsumer.getPersons()).build();
    }

    @POST
    @Path("/persons")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePerson( Person person) {


        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        if(violations.isEmpty())
            return Response.ok(apiLocalProxyConsumer.savePerson(person)).build();


        violations.stream().forEach(e -> {
            System.out.println(e.getMessage());
        });

        return Response.status(HttpStatus.SC_BAD_REQUEST).entity(new ResultConstraint(violations)).build();
    }


    @GET
    @Path("/customer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") String id) throws URISyntaxException {

        ApiLocalProxyConsumer apiLocalProxy = RestClientBuilder.newBuilder()
                .baseUri(new URI("http://localhost:8081/"))
                .build(ApiLocalProxyConsumer.class);

        CustomerResponse customerResponse = apiLocalProxy.getCustomer(id);

        //return Response.ok(apiLocalProxyConsumer.getCustomerByHeader(id)).build();
        return Response.ok(customerResponse).build();
    }
}