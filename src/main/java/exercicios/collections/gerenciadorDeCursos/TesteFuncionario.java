package exercicios.collections.gerenciadorDeCursos;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class OrdenaPorIdade implements Comparator<Funcionario> {
    @Override
    public int compare(Funcionario funcionario1, Funcionario funcionario2) {
        return Integer.compare(funcionario1.getIdade(), funcionario2.getIdade());
    }
}

public class TesteFuncionario {
    public static void main(String args[]) {

        Funcionario f1 = new Funcionario("Barney", 12);
        Funcionario f2 = new Funcionario("Jonatan", 9);
        Funcionario f3 = new Funcionario("Guaraciara", 13);

        Set<Funcionario> funcionarios = new TreeSet<>(new OrdenaPorIdade());
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);

        Iterator<Funcionario> iterador = funcionarios.iterator();

        while (iterador.hasNext()) {
            System.out.println(iterador.next().getNome());
        }
    }
}
