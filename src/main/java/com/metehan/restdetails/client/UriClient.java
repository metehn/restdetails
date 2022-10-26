package com.metehan.restdetails.client;



import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

import java.io.StringReader;

public class UriClient {


    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restdetails-1.0-SNAPSHOT/rest")
                .path("uri");



       String plain = target
               .path("path")
               .path("123")
                .request("application/json; charset=UTF-8")
                .get(String.class);

        System.out.println(plain);

        String def = target
                .path("default")
                .request("application/json; charset=UTF-8")
                .get(String.class);

        System.out.println(def);

        String query = target
                .path("query")
                .queryParam("input", 513L)
                .request("application/json; charset=UTF-8")
                .get(String.class);

        System.out.println(query);

        String matrix = target
                .path("matrix")
                .matrixParam("input", 713L)
                .request("application/json; charset=UTF-8")
                .get(String.class);

        System.out.println(matrix);

    }
}
