package exercicios.jpaEHibernate.relacionamentos;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String endereco;
    private String numero;
    private String cidade;
}
