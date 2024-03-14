package org.diegomouraoficial.app;

import org.diegomouraoficial.dao.UserDao;
import org.diegomouraoficial.model.Users;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DeleteUser {

    public static void main(String[] args) {

        // Solicita que o usuário digite o ID do usuário a ser excluído
        Scanner scanner = new Scanner(System.in);

        UserDao userDao = new UserDao();
        List<Users> usersList = userDao.getAllUsers();

        // Verifica se a lista de usuários está vazia
        if (usersList.isEmpty()) {
            System.out.println("Não há usuários para excluir. Encerrando o programa.");
            return;
        }

        System.out.println("Lista de usuários disponíveis para exclusão:");

        // Exibe a lista de usuários com seus respectivos IDs
        for (Users users : usersList) {
            System.out.println("ID: " + users.getId() +
                    " | username: " + users.getUsername() +
                    " | email: " + users.getEmail());
        }

        // Loop para solicitar O ID do usuario ate que um ID válido seja fornecido
        int userId;
        Users users = null; // Inicializamos user como null

        do {
            System.out.print("Digite o ID do usuário que deseja excluir (ou digite -1 para sair): ");
            try {
                userId = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner

                // Sai do programa se o usuário digitar -1
                if (userId == -1) {
                    System.out.println("Operação cancelada pelo usuário.");
                    return;
                }
                users = userDao.getUserById(userId);

                // Se o usuário existir, exclua-o
                if(users != null) {
                    userDao.deleteUser(userId);
                    System.out.println("Usuário deletado com sucesso.");
                } else {
                    System.out.println("Tente novamente.");
                }
            } catch (InputMismatchException e) {
                // Se o usuário fornecer uma entrada que não é um número
                System.out.println("ID inválido. Por favor, insira um número inteiro.");
                scanner.nextLine(); // Limpa o buffer do scanner
                userId = -1; // Define userId como -1 para continuar o loop
            }
        } while (users == null);
    }
}
