package com.metehan.restdetails.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class HandlingClient {
    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restdetails-1.0-SNAPSHOT/rest")
                .path("handling");

        //----------------------------------------------------------------------------------------
        long num = -1;
        Response exception = target
                .path("exception")
                .path(Long.toString(num))
                .request("application/json; charset=UTF-8")
                .get();

        if (exception.getStatusInfo() == Response.Status.UNAUTHORIZED) {
            String result = exception.readEntity(String.class);
            System.out.println("Unauthorised: " + result);
        } else if (exception.getStatusInfo() == Response.Status.NOT_FOUND) {
            String message = exception.getStatusInfo().getReasonPhrase();
            System.out.println("Not Found:\n" + message);

        } else {
            String result = exception.readEntity(String.class);
            System.out.println("Ok: " + result);

        }

    }
}
