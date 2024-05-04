package com.luke.fipecar.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsumption {

//    private String address;
    private final URI BASE_ENDPOINT = URI.create("https://parallelum.com.br/fipe/api/v1/");

    public String extractData(String address) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_ENDPOINT + address))
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Location has not found!");
        }
    }

}
