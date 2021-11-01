package view.impl;

import service.UserService;
import service.UserServiceImpl;
import view.Menu;

import java.util.Scanner;

public class AdminMainMenu implements Menu {

    private final UserService userService = new UserServiceImpl();
    private final String[] items = {"1. Users menu", "2. Orders menu", "3. Products menu", "0. Exit"};

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        showItems(items);

        //noinspection InfiniteLoopStatement
        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> new UsersMenu().show();
                case 2 -> ordersMenu();
                case 3 -> new ProductMenu().show();
                case 0 -> exit();
            }

        }
    }

    private void ordersMenu() {
        System.out.println("Temporarily unavailable");
        show();
    }

    @Override
    public void exit() {
        new LoginMenu().show();
    }


}
