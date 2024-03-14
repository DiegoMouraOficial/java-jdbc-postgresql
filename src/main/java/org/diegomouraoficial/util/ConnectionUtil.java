package org.diegomouraoficial.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtil {
    private static final Logger logger = Logger.getLogger(ConnectionUtil.class.getName());
    private static final String URL = "jdbc:postgresql://localhost:5433/jdbc";
    private static final String USER = "postgres";
    private static final String PASSWORD = "102030";

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, "Erro ao conectar ao banco de dados", e);
        }
        return connection;
    }
}
