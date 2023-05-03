package exercicios.jpaEHibernate.relacionamentos;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Aluno {
    @Id
    @GeneratedValue
    private Long id;

    private String sobrenome;

    @Column(name = "nome")
    private String nome;

//    @Column(name = "data_nascimento")
//    @Temporal(TemporalType.DATE)
//    private Date dataDeNascimento;

    @Column(name = "data_nascimento", insertable = false, updatable = false)
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "endereco", column = @Column(name = "endereco")),
            @AttributeOverride(name = "numero", column = @Column(name = "numero")),
            @AttributeOverride(name = "cidade", column = @Column(name = "cidade"))
    })
    private Endereco endereco;

    @ManyToMany(mappedBy = "alunos")
    private List<Curso> cursos = new ArrayList<>();

    public enum Genero {
        MASCULINO,
        FEMININO,
        OUTRO
    }

}
