package org.diegomouraoficial.app;

import org.diegomouraoficial.dao.UserDao;
import org.diegomouraoficial.model.Users;

import java.util.List;

public class GetAllUsers {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        // Obtendo todos os usuários
        List<Users> usersList = userDao.getAllUsers();

        //Verificando sehá usuários
        if (!usersList.isEmpty()) {
            System.out.println("Lista de todos os usuários no Banco de Dados");
            for (Users users : usersList) {
                System.out.println("ID: " + users.getId() +
                        " | username: " + users.getUsername() +
                        " | email: " + users.getEmail());
            }
        } else {
            System.out.println("Nenhum usuário encontrado na base do banco de dados.");
        }
    }
}

