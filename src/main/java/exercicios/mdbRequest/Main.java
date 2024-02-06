package exercicios.mdbRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


//belib50516@namewok.com
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o nome do filme/serie: ");
        String title = scanner.nextLine();
        title = title.trim().replaceAll(" ", "+");
        String url = String.format("http://www.omdbapi.com/?t=%s&apikey=7735df76", title);
//        System.out.println(url);

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = googleBookRequest();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        request = mdbRequest(url);
        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static HttpRequest googleBookRequest(){
        return HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=harry+potter"))
                .build();
    }

    public static HttpRequest mdbRequest(String url){
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }
}
