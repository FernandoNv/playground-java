package exercicios.jdbc.bytebank.domain.conta;

import java.math.BigDecimal;
import java.util.Set;

public interface ContaRepository {
    void salvar(Conta conta);
    void deletar(Integer numero);
    Set<Conta> listar();
    Conta buscarPorNumero(int numero);
    void alterar(Integer numero, BigDecimal valor);

}
