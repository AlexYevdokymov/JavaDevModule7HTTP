package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static String catUrl = "https://http.cat/";
    static String getStatusImage(int code) throws IOException, InterruptedException, PageNotFoundException {
        String url = catUrl + code;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 404) throw new PageNotFoundException();
        else return url;
    }
}
