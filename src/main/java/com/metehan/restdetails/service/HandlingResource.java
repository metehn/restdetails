package com.metehan.restdetails.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("handling")
public class HandlingResource {


    @GET
    @Path("exception/{input}")
    public Response getException(@PathParam("input") long num) {

        if (num < 0) {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .build();

        } else if (num == 0) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
        String result = Long.toString(num);
        return Response
                .ok()
                .entity(result)
                .build();

    }


}
