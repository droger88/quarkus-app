package org.dcy;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.dcy.domain.*;

import org.dcy.service.MyService;

@Path("/hello")
public class MyApi {

    private MyService service;

    MyApi(MyService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/resource/{name}")
    public Map<String,Object> doSomething(@PathParam String name) {
        String value = service.doSomething(name);
        Map<String, Object> result = new HashMap<>();
        result.put("result", value);
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/resource/name")
    public Name getName(){
        Name name = new Name("firstName","lastName");
        return name;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/resource")
    public Map<String,Object> process(){
        service.execute();
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("result", "ok");
        return result;
    }
}