import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection criaConexao() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                        "loja_virtual?useTimezone=true&serverTimezone=UTC",
                "root", "corujeira123456");
    }
}
