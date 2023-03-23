package exercicios.javaio;

import java.io.IOException;
import java.io.PrintWriter;

public class TesteEscritaPrintWriter {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter("src/main/java/exercicios/javaio/text6.txt");

        pw.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        pw.print("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

        pw.close();
    }
}
