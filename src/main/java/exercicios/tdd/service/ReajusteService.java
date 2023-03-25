package exercicios.tdd.service;

import exercicios.tdd.modelo.Desempenho;
import exercicios.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal reajuste = desempenho.percentualReajuste();
        funcionario.reajustarSalario(reajuste);
    }

}