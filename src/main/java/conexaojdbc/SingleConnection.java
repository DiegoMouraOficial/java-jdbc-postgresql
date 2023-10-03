package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que fornece uma conexão única com o banco de dados.
 */
public class SingleConnection {
    private static final String url = "jdbc:postgresql://localhost:5433/javajdbc";
    private static final String password = "102030";
    private static final String user = "postgres";
    private static Connection connection = null;


    static {
        conectar();
    }

    public SingleConnection() {
        conectar();
    }

    /**
     * Conecta ao banco de dados.
     */
    private static void conectar(){
        try{
            if(connection == null) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
                System.out.println("Banco conectou com sucesso");
            }
        } catch (Exception e) {
            logger.log(Level.WARNING,"Erro ao conectar ao banco de dados", e);
        }

    }

    public static Connection getConnection() {
        return connection;
    }

    private static final Logger logger = Logger.getLogger(SingleConnection.class.getName());

}
