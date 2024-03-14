package org.diegomouraoficial.app;

import org.diegomouraoficial.dao.UserDao;
import org.diegomouraoficial.model.Users;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

public class UpdateUser {
    private static final Logger logger = Logger.getLogger(UpdateUser.class.getName());

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int updateId = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Digite o ID do usuário que deseja atualizar: ");
                updateId = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                logger.warning( "Erro: ID do usuário deve ser um número inteiro.");
                // Limpa o buffer do Scanner
                sc.nextLine();
            }
        }

        UserDao userDao = new UserDao();
        Users users = userDao.getUserById(updateId);

        if (users != null) {
            System.out.println("Usuário encontrado:");
            System.out.println("ID: " + users.getId());
            System.out.println("Username: " + users.getUsername());
            System.out.println("Email: " + users.getEmail());
            System.out.println("------------------------------------ ");

            System.out.println("O que você deseja atualizar?");
            System.out.println("1 - Atualizar Username");
            System.out.println("2 - Atualizar Email");
            System.out.println("3 - Atualizar Ambos");
            System.out.println("4 - Sair");
            System.out.println("------------------------------------ ");

            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print(" Digite o novo username: ");
                    String newUsername = sc.next();
                    users.setUsername(newUsername);
                    break;
                case 2:
                    System.out.print(" Digite o novo email: ");
                    String newEmail = sc.next();
                    users.setEmail(newEmail);
                    break;
                case 3:
                    System.out.print(" Digite o novo username: ");
                    String newUserName2 = sc.next();
                    users.setUsername(newUserName2);

                    System.out.print(" Digite o novo email: ");
                    String newEmail2 = sc.next();
                    users.setEmail(newEmail2);
                    break;
                case 4:
                    System.out.println(" Saindo do programa... ");
                    return;
                default:
                    logger.log(Level.SEVERE, "Nenhum usuário encontrado com o ID: " + updateId);
                    return;
            }

            userDao.updateUser(users);

        } else {
            logger.log(Level.SEVERE, "Nenhum usuário encontrado com o ID: " + updateId);
        }

        sc.close();
    }
}
