package exercicios.mdbRequest.services;

import exercicios.mdbRequest.models.VisualContent;

import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    private GsonService gsonService;

    public FileService(GsonService gsonService){
        this.gsonService = gsonService;
    }

    public void writeData(Object object, String filepath) throws IOException {
        FileWriter fileWriter = new FileWriter(filepath);
        fileWriter.write(gsonService.toJson(object));
        fileWriter.close();
    }
}
