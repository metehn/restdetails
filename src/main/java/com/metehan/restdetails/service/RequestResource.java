package com.metehan.restdetails.service;

import jakarta.ws.rs.*;

@Path("uri")
public class RequestResource {

    @GET
    @Path("/header")
    @Produces("application/json")
    public String getHeader( @HeaderParam("input") long input){

        return input+"";
    }

    @GET
    @Path("/cookie")
    @Produces("application/json")
    public String getCookie( @CookieParam("input") long input){

        return input+"";
    }



}
