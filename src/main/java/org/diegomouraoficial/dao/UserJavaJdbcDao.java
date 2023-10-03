package org.diegomouraoficial.dao;

import conexaojdbc.SingleConnection;

import java.sql.Connection;

public class UserJavaJdbcDao {

    public UserJavaJdbcDao() {
        Connection connection = SingleConnection.getConnection();
    }

}
