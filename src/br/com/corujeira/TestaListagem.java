package br.com.corujeira;

import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.criaConexao();

        PreparedStatement statement = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
        statement.execute();

        ResultSet resultado = statement.getResultSet();

        while(resultado.next()) {
            Integer id = resultado.getInt("ID");
            System.out.println(id);
            String nome = resultado.getString("NOME");
            System.out.println(nome);
            String descricao = resultado.getString("DESCRICAO");
            System.out.println(descricao);
        }

        System.out.println("Fechando conexão com o banco de dados");
        connection.close();
    }
}
