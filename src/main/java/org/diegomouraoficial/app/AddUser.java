package org.diegomouraoficial.app;

import org.diegomouraoficial.dao.UserDao;
import org.diegomouraoficial.model.Users;
import java.util.Scanner;
public class AddUser {
    public static void main(String[] args) {

        Users user = new Users();
        Scanner sc = new Scanner(System.in);
        System.out.print(" Digite o username para inserir no Banco de Dados: ");
        user.setUsername(sc.nextLine());
        System.out.print(" Digite o email do username para inserir no Banco de Dados: ");
        user.setEmail(sc.nextLine());

        new UserDao().addUser(user);
    }
}