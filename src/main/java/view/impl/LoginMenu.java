package view.impl;

import model.User;
import service.UserService;
import service.UserServiceImpl;
import view.Menu;

import java.util.Scanner;

public class LoginMenu implements Menu {

    private final UserService userService = new UserServiceImpl();
    private String[] items = {"1.Login", "2.User registration", "3.Administrator registration", "0. Exit"};
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        showItems(items);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginSubMenu();
                    break;
                case 2:
                    registerUser();
                    break;
                case 3:
                    registerAdmin();
                    break;
                case 0:
                    exit();
                    break;
            }
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    private void loginSubMenu() {
        System.out.println("Input login:");
        scanner.nextLine();
        String login = scanner.nextLine();

        System.out.println("Input password:");
        String password = scanner.nextLine();

        if (userService.login(login, password)) {
            System.out.println("Successfully authorization");
            new ProductMenu().show();
        } else {
            System.out.println("Wrong username/password");
            show();
        }
    }

    private void registerUser() {

        System.out.println("Input login:");
        scanner.nextLine();
        String login = scanner.nextLine();

        System.out.println("Input password:");
        String password = scanner.nextLine();

        User user = new User(login, password, User.UserRole.USER);
        userService.register(user);
        show();
    }

    private void registerAdmin() {

        System.out.println("Input login:");
        scanner.nextLine();
        String login = scanner.nextLine();

        System.out.println("Input password:");
        String password = scanner.nextLine();

        User user = new User(login, password, User.UserRole.ADMIN);
        userService.register(user);
        show();

    }
}