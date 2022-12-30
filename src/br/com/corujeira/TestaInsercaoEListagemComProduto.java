package br.com.corujeira;

import br.com.corujeira.dao.ProdutoDAO;
import br.com.corujeira.model.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemComProduto {
    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Nvidia RTX 4080", "Placa de vídeo para rodar tudo em 4K");

        try(Connection connection = new ConnectionFactory().criaConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
            List<Produto> listaDeProduto = produtoDAO.listar();
            listaDeProduto.stream().forEach(System.out::println);
        }
    }
}
