import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.criaConexao();
        connection.setAutoCommit(false);

        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao)"
                    + "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            adicionarVariavel("SmartTV", "60 polegadas", stm);
            adicionarVariavel("Toca Discos", "acionado por correia", stm);
            connection.commit();
            stm.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ROLLBACK REALIZADO");
            connection.rollback();
        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);
        if(nome.equals("")) {
            throw new RuntimeException("Não foi possivel adicionar o produto");
        }
        stm.execute();
        ResultSet resultSet = stm.getGeneratedKeys();
        while(resultSet.next()) {
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
        resultSet.close();
    }
}
