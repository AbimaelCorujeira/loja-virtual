package br.com.corujeira;

import br.com.corujeira.dao.ProdutoDAO;
import br.com.corujeira.modelo.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemComProduto {
    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Cômoda", "Cômoda de quarto");

        try(Connection connection = new ConnectionFactory().criaConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
            List<Produto> listaDeProduto = produtoDAO.listar();
            listaDeProduto.stream().forEach(System.out::println);
        }
    }
}
