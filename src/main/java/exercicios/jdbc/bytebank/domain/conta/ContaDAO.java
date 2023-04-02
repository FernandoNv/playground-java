package exercicios.jdbc.bytebank.domain.conta;

import exercicios.jdbc.bytebank.domain.ConnectionFactory;
import exercicios.jdbc.bytebank.domain.cliente.Cliente;
import exercicios.jdbc.bytebank.domain.cliente.DadosCadastroCliente;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ContaDAO implements ContaRepository{
    private ConnectionFactory connectionFactory;

    public ContaDAO(){
        connectionFactory = new ConnectionFactory();
    }
    @Override
    public void salvar(Conta conta) {
        Connection connection = connectionFactory.recuperarConexao();
        var sql = """
            INSERT INTO conta(numero, saldo, cliente_nome, cliente_cpf, cliente_email, esta_ativa)
            VALUES (? ,? ,?, ?, ?, ?)
        """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, conta.getNumero());
            preparedStatement.setBigDecimal(2, conta.getSaldo());
            preparedStatement.setString(3, conta.getTitular().getNome());
            preparedStatement.setString(4, conta.getTitular().getCpf());
            preparedStatement.setString(5, conta.getTitular().getEmail());
            preparedStatement.setBoolean(6, conta.getEstaAtiva());

            preparedStatement.execute();
            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Integer numero) {
        Connection connection = connectionFactory.recuperarConexao();
        //var sql = "DELETE FROM conta WHERE numero = ?";
        var sql = "UPDATE conta set esta_ativa = false WHERE numero = ?"; //exclusão lógica
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, numero);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Conta> listar() {
        Set<Conta> contas = new HashSet<>();
        Connection connection = connectionFactory.recuperarConexao();
        String sql = """
            SELECT * FROM conta WHERE esta_ativa = true;        
        """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Integer numero = resultSet.getInt(1);
                BigDecimal saldo = resultSet.getBigDecimal(2);
                String nome = resultSet.getString(3);
                String cpf = resultSet.getString(4);
                String email = resultSet.getString(5);
                boolean estaAtiva = resultSet.getBoolean(6);

                Cliente cliente = new Cliente(new DadosCadastroCliente(nome, cpf, email));
                contas.add(new Conta(numero, saldo, cliente, estaAtiva));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contas;
    }

    @Override
    public Conta buscarPorNumero(int numero) {
        Connection connection = connectionFactory.recuperarConexao();
        String sql = "SELECT * FROM conta WHERE numero = ? AND esta_ativa = true";
        Conta conta = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, numero);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Integer numeroRecuperado = resultSet.getInt(1);
                BigDecimal saldo = resultSet.getBigDecimal(2);
                String nome = resultSet.getString(3);
                String cpf = resultSet.getString(4);
                String email = resultSet.getString(5);
                Boolean estaAtiva = resultSet.getBoolean(6);

                Cliente cliente = new Cliente(new DadosCadastroCliente(nome, cpf, email));
                conta = new Conta(numeroRecuperado, saldo, cliente, estaAtiva);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conta;
    }

    @Override
    public void alterar(Integer numero, BigDecimal valor) {
        PreparedStatement ps;
        String sql = "UPDATE conta SET saldo = ? WHERE numero = ? AND esta_ativa = true";
        Connection connection = connectionFactory.recuperarConexao();

        try {
            connection.setAutoCommit(false);

            ps = connection.prepareStatement(sql);

            ps.setBigDecimal(1, valor);
            ps.setInt(2, numero);

            ps.execute();
            connection.commit();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }

    }
}
