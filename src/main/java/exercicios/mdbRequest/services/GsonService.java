package exercicios.mdbRequest.services;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exercicios.mdbRequest.models.VisualContent;
import exercicios.mdbRequest.models.VisualContentOMDB;

public class GsonService {
    private final Gson gson;
    public GsonService(){
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public VisualContent toVisualContent(String json){
        VisualContentOMDB visualContentOMDB = gson.fromJson(json, VisualContentOMDB.class);
        return new VisualContent(visualContentOMDB);
    }

    public String toJson(Object object){
        return  gson.toJson(object);
    }
}
