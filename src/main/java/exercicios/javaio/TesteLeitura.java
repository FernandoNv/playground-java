package exercicios.javaio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteLeitura{
    public static void main(String[] args) throws IOException {

//        FileInputStream fileInputStream = new FileInputStream("src/main/java/exercicios/javaio/text.txt");
//        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        InputStream fileInputStream = new FileInputStream("src/main/java/exercicios/javaio/text.txt");
        Reader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String linha = bufferedReader.readLine();

        while(linha != null){
            System.out.println(linha);
            linha = bufferedReader.readLine();
        }

        bufferedReader.close();
    }
}
