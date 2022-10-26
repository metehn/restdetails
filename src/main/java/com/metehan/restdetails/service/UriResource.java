package com.metehan.restdetails.service;

import jakarta.ws.rs.*;
import org.jboss.resteasy.annotations.Query;

@Path("/uri")
public class UriResource {

    @GET
    @Path("/path/{input}")
    @Produces("application/json")
    public String getPath( @PathParam("input") long input){

        return input+"";
    }

    @GET
    @Path("/default/{input}")
    @Produces("application/json")
    public String getDefault( @PathParam("input") @DefaultValue("9999") Long input){
    //Değer verilmediğinde varsayılan olarak bir değer girilsin diye @DefaultValue() tag'ini verdim.
        return input+"";
    }

    @GET
    @Path("/query")
    @Produces("application/json")
    public String getQuery(@QueryParam("input")long input){
        //   /default?input=123123
        return input+"";
    }

    @GET
    @Path("/matrix")
    @Produces("application/json")
    public String getMatrix(@MatrixParam("input") long input){
        //   /mathrix;input=123123
        return input+"";
    }

}
