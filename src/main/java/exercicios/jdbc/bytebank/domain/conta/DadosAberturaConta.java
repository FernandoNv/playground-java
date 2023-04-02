package exercicios.jdbc.bytebank.domain.conta;
import exercicios.jdbc.bytebank.domain.cliente.DadosCadastroCliente;
public record DadosAberturaConta(Integer numero, DadosCadastroCliente dadosCliente) {
}