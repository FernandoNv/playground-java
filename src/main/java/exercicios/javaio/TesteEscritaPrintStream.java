package exercicios.javaio;

import java.io.IOException;
import java.io.PrintStream;

public class TesteEscritaPrintStream {

    public static void main(String[] args) throws IOException {

        PrintStream ps = new PrintStream("src/main/java/exercicios/javaio/text5.txt");

        ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        ps.print("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

        ps.close();
    }
}