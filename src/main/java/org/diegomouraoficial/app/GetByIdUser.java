package org.diegomouraoficial.app;

import org.diegomouraoficial.dao.UserDao;
import org.diegomouraoficial.model.Users;
import java.util.Scanner;

public class GetByIdUser {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print(" Digite o ID do username: ");
        int userId = sc.nextInt();

        UserDao userDao = new UserDao();
        Users users = userDao.getUserById(userId);

        if (users != null) {
            System.out.println("ID: " + users.getId());
            System.out.println("Username: " + users.getUsername());
            System.out.println("Email: " + users.getEmail());
        }
    }
}