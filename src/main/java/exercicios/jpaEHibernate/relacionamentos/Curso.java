package exercicios.jpaEHibernate.relacionamentos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Curso {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    private Professor professor;

    @OneToOne(mappedBy = "cursos")
    private CursoMaterial material;

    @ManyToMany
    @JoinTable(
            name = "alunos_cursos",
            joinColumns = @JoinColumn(name = "id_curso", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    )
    private List<Aluno> alunos = new ArrayList<>();

}
