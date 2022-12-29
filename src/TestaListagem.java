import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                        "loja_virtual?useTimezone=true&serverTimezone=UTC",
                "root", "corujeira123456");

        Statement statement = connection.createStatement();
        statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

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
