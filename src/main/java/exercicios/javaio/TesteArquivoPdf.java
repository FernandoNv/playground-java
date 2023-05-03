package exercicios.javaio;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class TesteArquivoPdf {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/exercicios/javaio/teste-pdf.pdf");
        PDDocument document = PDDocument.load(file);
        PDFTextStripper stripper = new PDFTextStripper();

        String text = stripper.getText(document);
        System.out.println(text);
        document.close();
    }
}
