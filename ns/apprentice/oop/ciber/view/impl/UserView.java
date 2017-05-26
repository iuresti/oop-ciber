package ns.apprentice.oop.ciber.view.impl;

import java.util.Collection;
import java.util.Scanner;

import ns.apprentice.oop.App;
import ns.apprentice.oop.ciber.model.User;
import ns.apprentice.oop.ciber.service.UserService;
import ns.apprentice.oop.ciber.view.CiberUI;

public class UserView implements CiberUI {

    private UserService userService;

    public UserView() {
        this.userService = (UserService) App.getBean(App.BEAN_USER_SERVICE);
    }


    @Override
    public CiberUI execute() {

        System.out.println("Users");
        System.out.println();
        System.out.println();
        System.out.println("1. List");
        System.out.println("2. Back to main menu");

        Scanner scanner = new Scanner(System.in);

        int selectedOption = scanner.nextInt();

        return getNextView(selectedOption);
    }

    private CiberUI getNextView(int selectedOption) {
        switch (selectedOption) {
            case 1:
                printUsers();
                break;
            case 2:
                return (CiberUI) App.getBean(App.BEAN_MAIN_VIEW);
        }

        return (CiberUI) App.getBean(App.BEAN_USER_VIEW);
    }

    private void printUsers() {

        Collection<User> users = userService.getAll();

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println();
        System.out.println();

    }
}
