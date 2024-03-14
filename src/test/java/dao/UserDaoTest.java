package dao;

import org.diegomouraoficial.dao.UserDao;
import org.diegomouraoficial.model.Users;
import org.diegomouraoficial.util.ConnectionUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
//    private static UserDao userDao;
//    private static Connection connection;
//
//    @BeforeAll
//    public static void setUp() throws SQLException {
//        // Configurar a conexão com o banco de dados
//        connection = ConnectionUtil.getConnection();
//        userDao = new UserDao(connection);
//
//        // Criar uma tabela temporária para os testes
//        userDao.createTemporaryTable();
//    }
//
//    @AfterAll
//    public static void tearDown() throws SQLException {
//        // Deletar a tabela temporária após os testes
//        userDao.dropTemporaryTable();
//
//        // Fechar a conexão
//        if (connection != null) {
//            connection.close();
//        }
//    }
//
//    @Test
//    public void addUser() throws SQLException {
//        // Adicionar um usuário
//        Users user = new Users("Alice", "alice@example.com");
//        userDao.addUser(user);
//
//        // Verificar se o usuário foi adicionado corretamente
//        Users retrievedUser = userDao.getUserById(user.getId());
//        assertNotNull(retrievedUser);
//        assertEquals(user.getUsername(), retrievedUser.getUsername());
//        assertEquals(user.getEmail(), retrievedUser.getEmail());
//    }
//
//    @Test
//    public void getUserById() throws SQLException {
//        // Adicionar um usuário
//        Users user = new Users("Bob", "bob@example.com");
//        userDao.addUser(user);
//
//        // Buscar o usuário pelo ID
//        Users retrievedUser = userDao.getUserById(user.getId());
//
//        // Verificar se o usuário foi encontrado corretamente
//        assertNotNull(retrievedUser);
//        assertEquals(user.getUsername(), retrievedUser.getUsername());
//        assertEquals(user.getEmail(), retrievedUser.getEmail());
//    }
//
//    @Test
//    public void updateUser() throws SQLException {
//        // Adicionar um usuário
//        Users user = new Users("Charlie", "charlie@example.com");
//        userDao.addUser(user);
//
//        // Atualizar o nome do usuário
//        user.setUsername("Charlie Updated");
//        userDao.updateUser(user);
//
//        // Buscar o usuário pelo ID e verificar se o nome foi atualizado
//        Users updatedUser = userDao.getUserById(user.getId());
//        assertEquals("Charlie Updated", updatedUser.getUsername());
//    }
//
//    @Test
//    public void deleteUser() throws SQLException {
//        // Adicionar um usuário
//        Users user = new Users("David", "david@example.com");
//        userDao.addUser(user);
//
//        // Deletar o usuário
//        userDao.deleteUser(user.getId());
//
//        // Tentar buscar o usuário pelo ID para verificar se foi removido
//        Users deletedUser = userDao.getUserById(user.getId());
//        assertNull(deletedUser);
//    }
}
