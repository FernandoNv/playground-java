package exercicios.java8;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {

        LocalDate agora = LocalDate.now();
        System.out.println(agora);

        LocalDate data = LocalDate.of(2099, Month.JANUARY, 25);

        LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);
        Period periodo = Period.between(agora, dataFutura);

        System.out.println(periodo);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = formatter.format(agora);

    }
}
