package exercicios.collections.gerenciadorDeCursos;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Curso {
    private String nome;
    private String instrutor;
    private List<Aula> aulas = new LinkedList<>();
    private Set<Aluno> alunos = new HashSet<>();
    private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();

    public Curso(String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }

    public void adiciona(Aula aula) {
        aulas.add(aula);
    }

    public int getTempoTotal(){
        return aulas.stream().mapToInt(Aula::getTempo).sum();
    }

    public void matricula(Aluno aluno){
        this.alunos.add(aluno);
        matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
    }

    public Aluno buscaMatriculado(int numero) {
        return this.matriculaParaAluno.get(numero);
    }

    public Set<Aluno> getAlunos() {
        return Collections.unmodifiableSet(alunos);
    }

    public boolean estaMatriculado(Aluno aluno){
        return alunos.contains(aluno);
    }

    @Override
    public String toString() {
        return "[Curso:"+ this.getNome()+",tempo total:"+ this.getTempoTotal()+ ", aulas: ["+ this.aulas+"] ]";
    }
}
