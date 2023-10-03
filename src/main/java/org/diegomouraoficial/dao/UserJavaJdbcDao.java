package org.diegomouraoficial.dao;

import conexaojdbc.SingleConnection;
import org.diegomouraoficial.model.UserJavaJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserJavaJdbcDao {

    private final Connection connection;

    public UserJavaJdbcDao(Connection connection) {
        this.connection = connection;
    }

    public void salvar(UserJavaJdbc userJavaJdbc) {

        try {
            String sql = "insert into userjavajdbc (id, nome, email) values (?, ?, ?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setLong(1, userJavaJdbc.getId());
            insert.setString(2, userJavaJdbc.getNome());
            insert.setString(3, userJavaJdbc.getEmail());
            insert.execute();
            connection.commit(); // Salva no banco de dados
        } catch (Exception e) {
            logger.log(Level.WARNING,"Erro ao tentar Inserir no banco de dados", e);
        }
    }

    private static final Logger logger = Logger.getLogger(UserJavaJdbcDao.class.getName());

}
