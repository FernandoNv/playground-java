package exercicios.mdbRequest.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OMDBService {
    private final HttpClient httpClient;
    private final String BASE_URL = "https://www.omdbapi.com/?t=%s&apikey=7735df76";

    public OMDBService(){
        this.httpClient = HttpClient.newHttpClient();
    }

    public HttpResponse<String> getVisualContentResponse(String visualContentName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(BASE_URL, visualContentName)))
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
