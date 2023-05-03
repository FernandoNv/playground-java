package exercicios.jpaEHibernate.relacionamentos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Professor {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String sobrenome;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<Curso> cursos;

}
