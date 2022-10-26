package com.metehan.restdetails.client;

import com.metehan.restdetails.entity.Product;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class ResponseClient {

    public static void main(String[] args) {


        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/restdetails-1.0-SNAPSHOT/rest")
                .path("response");

        //----------------------------------------------------------------------------------------
        String success = target
                .path("ok")
                .request("application/json; charset=UTF-8")
                .get(String.class);
        System.out.println("Ok: " + success);

        //----------------------------------------------------------------------------------------
        Response response = target
                .path("ok")
                .request("application/json; charset=UTF-8")
                .get();
        if (response.getStatusInfo() == Response.Status.OK) {
            String result = response.readEntity(String.class);
            System.out.println("Ok: " + result);
        } else {
            String message = response.getStatusInfo().getReasonPhrase();
            System.out.println("Denied: " + message);
        }

        //----------------------------------------------------------------------------------------
        Response failure = target
                .path("notfound")
                .request("application/json; charset=UTF-8")
                .get();
        if (failure.getStatusInfo() == Response.Status.OK) {
            String result = failure.readEntity(String.class);
            System.out.println("Ok: " + result);
        } else if (failure.getStatusInfo() == Response.Status.NOT_FOUND) {
            String message = failure.getStatusInfo().getReasonPhrase();
            System.out.println("Bulunmadı: " + message);

        } else {
            String message = failure.getStatusInfo().getReasonPhrase();
            System.out.println("Hata: " + message);
        }

        //----------------------------------------------------------------------------------------
        Response type = target
                .path("type")
                .request("application/json; charset=UTF-8")
                .get();
        String result2 = type.readEntity(String.class);
        System.out.println("Ok: " + result2);

        //----------------------------------------------------------------------------------------
        Response bean = target
                .path("bean")
                .request("application/json; charset=UTF-8")
                .get();
        Product product = bean.readEntity(Product.class);
        if (bean.getStatusInfo() == Response.Status.OK) {
            System.out.println("OK: " + product.getProductId() + " "
                    + product.getProductName() + " "
                    + product.getSalesPrice() );
        }


    }
}
