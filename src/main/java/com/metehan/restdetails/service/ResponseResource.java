package com.metehan.restdetails.service;

import com.metehan.restdetails.entity.Product;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("response")
public class ResponseResource {

    @GET
    @Path("ok")
    @Produces("application/json")
    public Response getResponse() {
        double value = 11.12;
        return Response
                .ok()
                .entity(value)
                .build();
    }

    @GET
    @Path("status")
    @Produces("application/json")
    public Response getStatus() {
        double value = 11.12;
        return Response
                .status(Response.Status.OK)//200
                .entity(value)
                .build();
    }

    @GET
    @Path("notfound")
    @Produces("application/json")
    public Response getFound() {

        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

    //  @Produces("application/json") yazmadan da .type() ile dönülecek tipi belirtebiliriz
    @GET
    @Path("type")
    public Response getType() {
        double value = 11.12;
        return Response
                .status(Response.Status.OK)//200
                .entity(value)
                .type("application/json")
                .build();
    }

    @GET
    @Path("bean")
    public Response getBean() {
        Product product = new Product(111,"Deneme",223.123);
        return Response
                .status(Response.Status.OK)//200
                .entity(product)
                .type("application/json")
                .build();
    }

}
