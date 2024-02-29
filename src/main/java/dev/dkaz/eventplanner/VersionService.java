package dev.dkaz.eventplanner;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VersionService {
    private final HttpClient httpClient;
    private final URI versionUrl;

    public VersionService(HttpClient httpClient, URI versionUrl) {
        this.httpClient = httpClient;
        this.versionUrl = versionUrl;
    }

    public String getVersion() throws Exception {
        HttpRequest request = HttpRequest.newBuilder(versionUrl).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new Exception("HTTP status code = " + response.statusCode());
        }
        return response.body();
    }
}
