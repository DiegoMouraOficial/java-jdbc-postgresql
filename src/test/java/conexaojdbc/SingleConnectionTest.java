package conexaojdbc;

import org.diegomouraoficial.dao.UserDao;
import org.diegomouraoficial.model.User;
import org.diegomouraoficial.util.ConnectionUtil;
import org.junit.Test;

import java.sql.Connection;

public class SingleConnectionTest {
    @Test
    public void initBanco() {

        Connection connection = ConnectionUtil.getConnection();

        UserDao userDao = new UserDao(connection);
        User user = new User();

        user.setId(4);
        user.setName("Mãe");
        user.setEmail("mae@teste.com.br");

        userDao.addUser(user);
    }
}
