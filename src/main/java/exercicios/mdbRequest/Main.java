package exercicios.mdbRequest;

import exercicios.mdbRequest.exceptions.ValidateYearException;
import exercicios.mdbRequest.models.VisualContent;
import exercicios.mdbRequest.services.FileService;
import exercicios.mdbRequest.services.GsonService;
import exercicios.mdbRequest.services.OMDBService;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//belib50516@namewok.com
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String title = "";
        Scanner scanner = new Scanner(System.in);
        List<VisualContent> visualContents = new ArrayList<>();
        OMDBService omdbService = new OMDBService();
        GsonService gsonService = new GsonService();
        FileService fileService = new FileService(gsonService);
        String filepath = "movies.json";

        while (!title.equalsIgnoreCase("exit")){
            System.out.print("Write the movie/tv-series name: ");
            try {
                title = scanner.nextLine();
                title = title.trim().replaceAll(" ", "+");

                if(title.equalsIgnoreCase("exit")){
                    break;
                }

                HttpResponse<String> response = omdbService.getVisualContentResponse(title);
                String json = response.body();
                VisualContent visualContent = gsonService.toVisualContent(json);

                visualContents.add(visualContent);
                System.out.println("Visual Content added...");
            } catch (NumberFormatException exception) {
                System.out.println("Error formatting the data to int");
                System.out.println(exception.getMessage());
            } catch (IllegalArgumentException exception) {
                System.out.println("Error creating uri");
                System.out.println(exception.getMessage());
            } catch (ValidateYearException exception) {
                System.out.println(exception.getMessage());
            }finally {
                System.out.println("Process ending...");
            }
        }

        System.out.println(visualContents);
        fileService.writeData(visualContents, filepath);
    }

}
