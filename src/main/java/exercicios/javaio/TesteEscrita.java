package exercicios.javaio;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscrita {

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("src/main/java/exercicios/javaio/text2.txt");
        Writer writer = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write("Teste de escrita em java");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.write("Teste de escrita em java2");
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
