package org.diegomouraoficial.dao;

import org.diegomouraoficial.model.Users;
import org.diegomouraoficial.util.ConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.*;

public class UserDao {
    private final Logger logger = Logger.getLogger(UserDao.class.getName());

    // Método para adicionar um novo usuário ao banco de dados
    public void addUser(Users users) {
        // SQL para inserir um novo usuário apenas se não existir outro com o mesmo username ou email
        String sql = "INSERT INTO users (username, email) " +
                "SELECT ?, ? " +
                "WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = ? OR email = ? )";

        PreparedStatement preparedStatement = null;

        try {
            // Prepara o PreparedStatement com a query SQL
            preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);

            // Define os parâmetros da query
            preparedStatement.setString(1, users.getUsername());
            preparedStatement.setString(2, users.getEmail());
            preparedStatement.setString(3, users.getUsername()); // Parâmetro para a subconsulta
            preparedStatement.setString(4, users.getEmail()); // Parâmetro para a subconsulta

            // Executa a query e obtém o número de linhas afetadas
            int rowsInserted = preparedStatement.executeUpdate();

            // Se houver linhas inseridas (usuário único), obtém o ID gerado
            if (rowsInserted > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    users.setId(generatedKeys.getInt(1));
                }
                System.out.println("Usuário: " + users.getUsername() + " e email: " + users.getEmail() + " inseridos com sucesso!");
            } else {
                System.out.println("Usuário: " + users.getUsername() + " ou email: " + users.getEmail() + " já cadastrados no banco de dados!");
            }
            preparedStatement.close(); // Fecha o PreparedStatement

        } catch (SQLException e) {
            // Em caso de erro SQL, registra o erro no log
            logger.log(Level.SEVERE, "Erro ao tentar adicionar usuário no banco de dados", e);
        }
    }

    // Método para buscar um usuário pelo ID
    public Users getUserById(int id) {

        Users user = null;
        String sql = "SELECT id, username, email FROM users WHERE id = ? ";

        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
            } else {
                System.out.println("Nenhum usuário encontrado com o ID: " + id);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao buscar usuário por ID", e);
        }
        return user;
    }

    // Método para atualizar um usuário pelo ID
    public void updateUser(Users user) {
        String sql = "UPDATE users SET username = ?, email = ? WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3, user.getId());

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                String message = "User (ID: " + user.getId() + ") atualizado no banco de dados: ";
                if (Objects.equals(user.getUsername(), null)) {
                    if (Objects.equals(user.getEmail(), null)) {
                        System.out.println(message + "Nenhum dado foi alterado.");
                    } else {
                        message += "Email: " + user.getEmail();
                        System.out.println(message);
                    }
                } else {
                    message += "Username: " + user.getUsername();
                    if (Objects.equals(user.getEmail(), null)) {
                        System.out.println(message + "Nenhum dado foi alterado.");
                    } else {
                        message += " e Email para: " + user.getEmail();
                    }
                    System.out.println(message);
                }
            } else {
                logger.log(Level.SEVERE, "Falha ao atualizar o usuário (ID: " + user.getId() + ").");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao tentar atualizar usuário no banco de dados", e);
        }
    }

    // Método para deletar um usuário pelo ID
    public void deleteUser(int userId) {
        String selectSql = "SELECT id, username, email FROM users WHERE id = ?";
        String deleteSql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection()) {
            // Obtém os dados do usuário antes de excluí-lo
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);
            selectStatement.setInt(1, userId);
            ResultSet resultSet = selectStatement.executeQuery();

            Users deletedUser = null;
            if (resultSet.next()) {
                deletedUser = new Users();
                deletedUser.setId(resultSet.getInt("id"));
                deletedUser.setUsername(resultSet.getString("username"));
                deletedUser.setEmail(resultSet.getString("email"));
            }

            // Exclui o usuário
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.setInt(1, userId);
            int rowsDeleted = deleteStatement.executeUpdate();

            if (rowsDeleted > 0 && deletedUser != null) {
                System.out.println(("Usuário excluído com sucesso:"));
                System.out.println("ID: " + deletedUser.getId());
                System.out.println("Username: " + deletedUser.getUsername());
                System.out.println("Email: " + deletedUser.getEmail());
            } else {
                logger.warning("Nenhum usuário encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao tentar excluir usuário no banco de dados", e);
        }
    }

    public List<Users> getAllUsers() {
        List<Users> userList = new ArrayList<>();
        String sql = "SELECT id, username, email FROM users";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                userList.add(user);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao obter todos os usuários", e);
        }

        return userList;
    }
}



