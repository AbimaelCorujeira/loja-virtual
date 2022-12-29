import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                        "loja_virtual?useTimezone=true&serverTimezone=UTC",
                "root", "corujeira123456");
        System.out.println("Fechando conexão com o banco de dados");
        System.out.println("teste");
        connection.close();

    }
}