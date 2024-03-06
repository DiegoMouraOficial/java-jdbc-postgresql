package org.diegomouraoficial.dao;

import org.diegomouraoficial.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {
    private final Connection connection;
    public UserDao(Connection connection) {
        this.connection = connection;
    }

    private static final Logger logger = Logger.getLogger(UserDao.class.getName());

    // Método para adicionar um novo usuário ao banco de dados
    public void addUser(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, new String[] {"id"})) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao tentar adicionar usuário no banco de dados", e);
        }
    }

    // Método para buscar um usuário pelo ID
    public User getUserById(int id) {
        User user = null;
        String sql = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(resultSet.getString("nome"), resultSet.getString("email"));
                user.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE,"Erro ao buscar usuário por id", e);
        }

        return user;
    }

    // Método para atualizar um usuário existente no banco de dados
    public void updateUser(User user) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuário atualizado com sucesso.");
            } else {
                System.out.println("Falha ao atualizar o usuário.");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao tentar atualizar usuário no banco de dados", e);
        }
    }

    // Método para deletar um usuário pelo ID
    public void deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Usuário deletado com sucesso.");
            } else {
                System.out.println("Usuário não encontrado para deletar.");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao tentar deletar usuário no banco de dados", e);
        }
    }

    // Método para listar todos os usuários no banco de dados
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                User user = new User(resultSet.getString("nome"), resultSet.getString("email"));
                user.setId(resultSet.getInt("id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao tentar listar todos os usuários", e);
        }

        return userList;
    }

    // Método para criar uma tabela temporária
    public void createTemporaryTable() {
        String createTableSQL = "CREATE TEMPORARY TABLE temp_users (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "email VARCHAR(255) NOT NULL" +
                ")";

        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
            System.out.println("Tabela temporária criada com sucesso.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao criar tabela temporária", e);
        }
    }

    // Método para deletar a tabela temporária
    public void dropTemporaryTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS temp_users";

        try (PreparedStatement statement = connection.prepareStatement(dropTableSQL)) {
            statement.execute();
            System.out.println("Tabela temporária deletada com sucesso.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao deletar tabela temporária", e);
        }
    }
}
