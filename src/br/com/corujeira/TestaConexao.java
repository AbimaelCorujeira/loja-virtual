package br.com.corujeira;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.criaConexao();

        System.out.println("Fechando conexão com o banco de dados");

        connection.close();

    }
}