package exercicios.solid.rh.service.reajuste;
import exercicios.solid.rh.model.Funcionario;
import java.math.BigDecimal;

public interface ValidacaoReajuste {
    void validar(Funcionario funcionario, BigDecimal aumento);
}
