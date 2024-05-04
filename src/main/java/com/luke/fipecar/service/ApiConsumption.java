package com.luke.fipecar.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsumption {

    private final URI ENDPOINT = URI.create("https://parallelum.com.br/fipe/api/v1/carros/marcas");

    public String getData() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(ENDPOINT)
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
