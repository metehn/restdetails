package com.metehan.restdetails.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

public class ContextClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restdetails-1.0-SNAPSHOT/rest")
                .path("context");



        String context = target
                .path("uri")
                .request("application/json; charset=UTF-8")
                .get(String.class);

        System.out.println("context: " + context);


        String config = target
                .path("config")
                .request("application/json; charset=UTF-8")
                .get(String.class);

        System.out.println(config);

    }
}
