package com.metehan.restdetails.service;

import jakarta.servlet.ServletConfig;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

@Path("context")
public class ContextResource {

    @Context
    private UriInfo uriInfo;

    @Context
    private ServletConfig servletConfig;


    @GET
    @Path("uri")
    @Produces("application/json")
    public String getUri() {

        String path = uriInfo.getPath();
        String baseUri = uriInfo.getBaseUri().toString();
        String absolutePath = uriInfo.getAbsolutePath().toString();


        return "path= " + path + "\n"+
                "baseUri= " + baseUri + "\n" +
                "absolutePath= " + absolutePath  ;
    }

    @GET
    @Path("config")
    @Produces("application/json")
    public String getConfig() {

        String input = servletConfig.getServletContext().getInitParameter("myinput");

        return "config=" + input;
    }

}
