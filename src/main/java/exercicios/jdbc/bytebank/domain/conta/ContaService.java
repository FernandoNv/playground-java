package exercicios.jdbc.bytebank.domain.conta;

import exercicios.jdbc.bytebank.domain.RegraDeNegocioException;
import exercicios.jdbc.bytebank.domain.cliente.Cliente;

import java.math.BigDecimal;
import java.util.Set;

public class ContaService {
    private ContaRepository contaRepository = new ContaDAO();
    public Set<Conta> listarContasAbertas() {
        return contaRepository.listar();
    }

    public BigDecimal consultarSaldo(Integer numeroDaConta) {
        var conta = contaRepository.buscarPorNumero(numeroDaConta);
        return conta.getSaldo();
    }

    public void abrir(DadosAberturaConta dadosDaConta) {
        var cliente = new Cliente(dadosDaConta.dadosCliente());
        var conta = new Conta(dadosDaConta.numero(), BigDecimal.ZERO, cliente, true);
        if (contaRepository.buscarPorNumero(dadosDaConta.numero()) != null) {
            throw new RegraDeNegocioException("Já existe outra conta aberta com o mesmo número!");
        }
        contaRepository.salvar(conta);
    }

    public void realizarSaque(Integer numeroDaConta, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor do saque deve ser superior a zero!");
        }

        var conta = contaRepository.buscarPorNumero(numeroDaConta);

        if(conta == null){
            throw new RegraDeNegocioException("Não existe conta cadastrada com esse número");
        }

        if (!conta.getEstaAtiva()){
            throw new RegraDeNegocioException("Conta não está ativa");
        }

        if (valor.compareTo(conta.getSaldo()) > 0) {
            throw new RegraDeNegocioException("Saldo insuficiente!");
        }

        BigDecimal novoValor = conta.getSaldo().subtract(valor);
        contaRepository.alterar(conta.getNumero(), novoValor);
    }

    public void realizarDeposito(Integer numeroDaConta, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor do deposito deve ser superior a zero!");
        }

        var conta = contaRepository.buscarPorNumero(numeroDaConta);

        if(conta == null){
            throw new RegraDeNegocioException("Não existe conta cadastrada com esse número");
        }

        if (!conta.getEstaAtiva()){
            throw new RegraDeNegocioException("Conta não está ativa");
        }

        BigDecimal novoValor = conta.getSaldo().add(valor);
        contaRepository.alterar(conta.getNumero(), novoValor);
    }

    public void realizarTransferencia(Integer numeroDaContaOrigem, Integer numeroDaContaDestino, BigDecimal valor){
        this.realizarSaque(numeroDaContaOrigem, valor);
        this.realizarDeposito(numeroDaContaDestino, valor);
    }

    public void encerrar(Integer numeroDaConta) {
        var conta = contaRepository.buscarPorNumero(numeroDaConta);
        if (conta.possuiSaldo()) {
            throw new RegraDeNegocioException("Conta não pode ser encerrada pois ainda possui saldo!");
        }

        contaRepository.deletar(conta.getNumero());
    }
}
