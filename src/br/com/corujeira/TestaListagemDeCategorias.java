package br.com.corujeira;

import br.com.corujeira.dao.CategoriaDAO;
import br.com.corujeira.model.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestaListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

        try(Connection connection = new ConnectionFactory().criaConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaCategoria = categoriaDAO.listar();
            listaCategoria.forEach(ct -> System.out.println(ct.getNome()));
        }

    }
}
