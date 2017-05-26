package ns.apprentice.oop.ciber.view.impl;

import java.util.Scanner;

import ns.apprentice.oop.App;
import ns.apprentice.oop.ciber.view.CiberUI;

public class CiberUIMainMenu implements CiberUI {

    @Override
    public CiberUI execute() {

        System.out.println("CIBER - v1.0");
        System.out.println();
        System.out.println();
        System.out.println("1. Computer");
        System.out.println("2. User");
        System.out.println("3. Rent");
        System.out.println("4. Quit");

        Scanner scanner = new Scanner(System.in);

        int selectedOption = scanner.nextInt();

        return getNextView(selectedOption);
    }

    private CiberUI getNextView(int selectedOption) {
        switch (selectedOption) {
            case 1:
                return (CiberUI) App.getBean(App.BEAN_COMPUTER_VIEW);
            case 2:
                return (CiberUI) App.getBean(App.BEAN_USER_VIEW);
            case 3:
                return (CiberUI) App.getBean(App.BEAN_RENT_VIEW);
            case 4:
                return null;
        }
        return (CiberUI) App.getBean(App.BEAN_MAIN_VIEW);
    }

}
