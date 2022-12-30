package br.com.corujeira.dao;

import br.com.corujeira.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException {

        String sql = "INSERT INTO PRODUTO(NOME, DESCRICAO) VALUES (?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());

            statement.execute();

            try(ResultSet resultSet = statement.getGeneratedKeys()) {
                while(resultSet.next()) {
                    produto.setId(resultSet.getInt(1));
                }
            }
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<Produto>();

        String sql = "SELECT * FROM PRODUTO";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();

            try(ResultSet rst = statement.getResultSet()) {
                while(rst.next()) {
                    Produto produto = new Produto
                            (rst.getInt(1), rst.getString(2), rst.getString(3));

                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }
}
