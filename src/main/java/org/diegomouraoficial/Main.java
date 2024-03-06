package org.diegomouraoficial;

import org.diegomouraoficial.dao.UserDao;
import org.diegomouraoficial.model.User;
import org.diegomouraoficial.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        try (Connection connection = ConnectionUtil.getConnection()) {
            // Criando uma instância do UserDao passando a conexão
            UserDao userDao = new UserDao(connection);

            Scanner scanner = new Scanner(System.in);
            int choice = 0;

            while (choice != 5) {
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Adicionar usuário");
                System.out.println("2 - Buscar usuário por ID");
                System.out.println("3 - Atualizar usuário");
                System.out.println("4 - Deletar usuário");
                System.out.println("5 - Listar todos os usuários");
                System.out.println("6 - Sair");
                System.out.print("Opção: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (choice) {
                    case 1:
                        // Adicionar usuário
                        System.out.print("Digite o nome do usuário: ");
                        String name = scanner.nextLine();
                        System.out.print("Digite o email do usuário: ");
                        String email = scanner.nextLine();

                        User newUser = new User(name, email);
                        userDao.addUser(newUser);
                        System.out.println("Usuário adicionado: " + newUser);
                        break;
                    case 2:
                        // Buscar usuário por ID
                        System.out.print("Digite o ID do usuário: ");
                        int userId = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha

                        User userFromDB = userDao.getUserById(userId);

                        if (userFromDB != null) {
                            System.out.println("Usuário encontrado: " + userFromDB);
                        } else {
                            System.out.println("Usuário não encontrado.");
                        }
                        break;
                    case 3:
                        // Atualizar usuário
                        System.out.print("Digite o ID do usuário que deseja atualizar: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha

                        User userToUpdate = userDao.getUserById(updateId);

                        if (userToUpdate != null) {
                            System.out.print("Digite o novo nome do usuário: ");
                            String newName = scanner.nextLine();
                            System.out.print("Digite o novo email do usuário: ");
                            String newEmail = scanner.nextLine();

                            userToUpdate.setName(newName);
                            userToUpdate.setEmail(newEmail);

                            userDao.updateUser(userToUpdate);
                            System.out.println("Usuário atualizado: " + userToUpdate);
                        } else {
                            System.out.println("Usuário não encontrado.");
                        }
                        break;
                    case 4:
                        // Deletar usuário
                        System.out.print("Digite o ID do usuário que deseja deletar: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha

                        userDao.deleteUser(deleteId);
                        System.out.println("Usuário deletado com sucesso.");
                        break;
                    case 5:
                        // Listar todos os usuários
                        List<User> userList = userDao.getAllUsers();
                        System.out.println("Lista de usuários:");
                        for (User user : userList) {
                            System.out.println(user);
                        }
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao tentar se conectar com o banco de dados", e);
        }

    }
}

