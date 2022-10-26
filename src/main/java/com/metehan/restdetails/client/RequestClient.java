package com.metehan.restdetails.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

public class RequestClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restdetails-1.0-SNAPSHOT/rest")
                .path("uri");



        String header = target
                .path("header")
                .request("application/json; charset=UTF-8")
                .header("input", 1234)
                .get(String.class);

        System.out.println("header: " + header);

        String cookie = target
                .path("cookie")
                .request("application/json; charset=UTF-8")
                .cookie("input", Long.toString(1234))
                .get(String.class);

        System.out.println("cookie: " + cookie);

    }
}
