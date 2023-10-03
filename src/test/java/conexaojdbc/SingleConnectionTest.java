package conexaojdbc;

import org.diegomouraoficial.dao.UserJavaJdbcDao;
import org.diegomouraoficial.model.UserJavaJdbc;
import org.junit.Test;

import java.sql.Connection;

public class SingleConnectionTest {
    @Test
    public void initBanco() {

        Connection connection = SingleConnection.getConnection();

        UserJavaJdbcDao userJavaJdbcDao = new UserJavaJdbcDao(connection);
        UserJavaJdbc userJavaJdbc = new UserJavaJdbc();

        userJavaJdbcDao.salvar(userJavaJdbc);
    }
}
