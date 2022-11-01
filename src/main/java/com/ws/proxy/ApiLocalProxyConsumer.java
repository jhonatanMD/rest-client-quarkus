package com.ws.proxy;

import com.ws.model.Customer;
import com.ws.model.Person;
import com.ws.model.dto.CustomerResponse;
import com.ws.model.dto.RootDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import java.util.List;



@Path("/v1")
@RegisterRestClient(configKey = "app-local")
public interface ApiLocalProxyConsumer {

    @GET
    List<Person> getPersons();

    @POST
    Person savePerson(Person person);


    @GET
    @Path("/customer/id/{id}")
    CustomerResponse getCustomer(@PathParam("id") String id);


    @GET
    @Path("/customer/header")
    CustomerResponse getCustomerByHeader(@HeaderParam("id") String id);



}
