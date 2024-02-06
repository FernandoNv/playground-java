package exercicios.github.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UsernameNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the username");
        String username = scanner.nextLine().trim();
        String url = "https://api.github.com/users/"+username;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 404){
                throw new UsernameNotFoundException("Could not find username...");
            }

            String json = response.body();
            System.out.println(json);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error getting information for this username " + username);
        }

    }
}
