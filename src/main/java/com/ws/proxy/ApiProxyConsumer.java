package com.ws.proxy;

import com.ws.model.dto.RootDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


//@RegisterRestClient(configKey = "app-proxy")
@RegisterRestClient(baseUri = "http://www.geognos.com/api/en/countries/")
public interface ApiProxyConsumer {

    @GET
    @Path("info/PE.json")
    RootDto getCountryPE();

    @GET
    @Path("info/EC.json")
    RootDto getCountryEC();

}
