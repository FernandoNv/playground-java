package exercicios.solid.rh.model;
import java.math.BigDecimal;
import java.time.LocalDate;

// Liskov Substitution Principle — Preferir utilizar composições ao invés de herança.
// Evita que uma classe herde comportamento indesejado. Ex: fazer com que a classe Terceirizado herdasse de funcionario
// No nosso exemplo o terceirizado não pode receber reajuste, mas se fosse feita a hernça de funcionário iria ser possível no código
// Por isso foi feita a escolha pela composição dos dados pessoais
public class Funcionario {
    private DadosPessoais dadosPessoais;
    private LocalDate dataUltimoReajuste;

    public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
        this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
    }

    public void atualizarSalario(BigDecimal novoSalario) {
        this.dadosPessoais.setSalario(novoSalario);
        this.dataUltimoReajuste = LocalDate.now();
    }

    public String getNome() {
        return dadosPessoais.getNome();
    }

    public void setNome(String nome) {
        this.dadosPessoais.setNome(nome);
    }

    public String getCpf() {
        return dadosPessoais.getCpf();
    }

    public void setCpf(String cpf) {
        this.dadosPessoais.setCpf(cpf);
    }

    public Cargo getCargo() {
        return dadosPessoais.getCargo();
    }

    public void setCargo(Cargo cargo) {
        this.dadosPessoais.setCargo(cargo);
    }

    public BigDecimal getSalario() {
        return dadosPessoais.getSalario();
    }

    public void setSalario(BigDecimal salario) {
        this.dadosPessoais.setSalario(salario);
    }

    public LocalDate getDataUltimoReajuste() {
        return dataUltimoReajuste;
    }

    public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
        this.dataUltimoReajuste = dataUltimoReajuste;
    }
}
