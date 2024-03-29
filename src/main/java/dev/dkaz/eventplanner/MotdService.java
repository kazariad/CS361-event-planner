package dev.dkaz.eventplanner;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MotdService {
    private final HttpClient httpClient;
    private final URI motdUri;

    public MotdService(HttpClient httpClient, URI motdUri) {
        this.httpClient = httpClient;
        this.motdUri = motdUri;
    }

    public String getMotd() throws Exception {
        HttpRequest request = HttpRequest.newBuilder(motdUri).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new Exception("HTTP status code = " + response.statusCode());
        }
        return response.body();
    }
}
