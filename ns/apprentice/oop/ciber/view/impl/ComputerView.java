package ns.apprentice.oop.ciber.view.impl;

import java.util.Collection;
import java.util.Scanner;

import ns.apprentice.oop.App;
import ns.apprentice.oop.ciber.model.Computer;
import ns.apprentice.oop.ciber.service.ComputerService;
import ns.apprentice.oop.ciber.view.CiberUI;

public class ComputerView implements CiberUI {

    private ComputerService computerService;

    public ComputerView() {
        this.computerService = (ComputerService) App.getBean(App.BEAN_COMPUTER_SERVICE);
    }

    @Override
    public CiberUI execute() {

        System.out.println("CIBER - v1.0");
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
                printComputers();
                break;
            case 2:
                return (CiberUI) App.getBean(App.BEAN_MAIN_VIEW);
        }

        return (CiberUI) App.getBean(App.BEAN_COMPUTER_VIEW);
    }

    private void printComputers() {

        Collection<Computer> computers = computerService.getAll();

        for (Computer computer : computers) {
            System.out.println(computer);
        }

        System.out.println();
        System.out.println();

    }
}
