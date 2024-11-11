package com.academia.pagamentos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MercadoPagoService {

    private static final String BASE_URL = "https://api.mercadopago.com";
    private static final String ACCESS_TOKEN = "YOUR_ACCESS_TOKEN";

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/v1/payments")) // Adjust the endpoint as needed
                    .header("Authorization", "Bearer " + ACCESS_TOKEN)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
