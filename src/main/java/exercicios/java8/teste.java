package exercicios.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class teste {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparingInt(Curso::getAlunos));
        cursos.forEach(c -> System.out.println(c.getNome()));

        System.out.println("-----------------------------------");

        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .map(Curso::getNome)
                .forEach(System.out::println);

        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .findFirst();

        cursos.stream()
                .mapToInt(c -> c.getAlunos())
                .average();

        List<Curso> stream = cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .collect(Collectors.toList());
    }
}
