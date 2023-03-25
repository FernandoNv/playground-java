package exercicios.collections.gerenciadorDeCursos;

import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {
    public static void main(String[] args) {

        Collection<Integer> numeros = new HashSet<>();
//        Collection<Integer> numeros = new ArrayList<>();

        long inicio = System.currentTimeMillis();

//        for (int i = 1; i <= 50000; i++) {
        for (int i = 1; i <= 100000; i++) {
            numeros.add(i);
        }

        for (Integer numero : numeros) {
            numeros.contains(numero);
        }

        long fim = System.currentTimeMillis();

        double tempoDeExecucao = (double)(fim - inicio)/1000;

        System.out.println("Tempo gasto: " + tempoDeExecucao);

    }
}
