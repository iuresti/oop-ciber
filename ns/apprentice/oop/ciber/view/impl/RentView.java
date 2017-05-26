package ns.apprentice.oop.ciber.view.impl;

import java.util.Collection;
import java.util.Scanner;

import ns.apprentice.oop.App;
import ns.apprentice.oop.ciber.model.RentItem;
import ns.apprentice.oop.ciber.service.RentService;
import ns.apprentice.oop.ciber.view.CiberUI;

public class RentView implements CiberUI {

    private RentService rentService;

    public RentView() {
        this.rentService = (RentService) App.getBean(App.BEAN_RENT_SERVICE);
    }

    @Override
    public CiberUI execute() {

        System.out.println("Free computers");
        System.out.println();
        System.out.println();
        System.out.println("1. List rents");
        System.out.println("2. Back to main menu");

        Scanner scanner = new Scanner(System.in);

        int selectedOption = scanner.nextInt();

        return getNextView(selectedOption);
    }

    private CiberUI getNextView(int selectedOption) {
        switch (selectedOption) {
            case 1:
                printRents();
                break;
            case 2:
                return (CiberUI) App.getBean(App.BEAN_MAIN_VIEW);
        }

        return (CiberUI) App.getBean(App.BEAN_COMPUTER_VIEW);
    }

    private void printRents() {

        Collection<RentItem> rents = rentService.getAll();

        for (RentItem rentItem : rents) {
            System.out.println(rentItem);
        }

        System.out.println();
        System.out.println();

    }
}
