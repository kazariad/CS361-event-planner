package dev.dkaz.eventplanner;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MotdService {
    private final URI motdUri;
    private final HttpClient client;

    public MotdService(String motdUrl) {
        motdUri = URI.create(motdUrl);
        client = HttpClient.newHttpClient();
    }

    public String getMotd() throws Exception {
        HttpRequest request = HttpRequest.newBuilder(motdUri).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new Exception("HTTP status code = " + response.statusCode());
        }
        return response.body();
    }
}
