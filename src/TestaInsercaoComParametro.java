import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {

        String nome = "Mouse";
        String descricao = "Mouse sem fio";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.criaConexao();

        PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao)"
                + "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, nome);
        stm.setString(2, descricao);
        stm.execute();

        ResultSet resultSet = stm.getGeneratedKeys();
        while(resultSet.next()) {
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
    }
}
