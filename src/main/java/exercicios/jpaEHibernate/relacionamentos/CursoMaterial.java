package exercicios.jpaEHibernate.relacionamentos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class CursoMaterial {
    @Id
    private Long id;

    private String url;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    private Curso curso;

}
