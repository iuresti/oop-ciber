package ns.apprentice.oop.ciber.view.impl;

import java.util.Collection;
import java.util.Scanner;

import ns.apprentice.oop.App;
import ns.apprentice.oop.ciber.model.Computer;
import ns.apprentice.oop.ciber.service.ComputerService;
import ns.apprentice.oop.ciber.service.RentService;
import ns.apprentice.oop.ciber.view.CiberUI;

public class RentView implements CiberUI {

    private RentService rentService;

    private ComputerService computerService;

    public RentView() {
        this.rentService = (RentService) App.getBean(App.BEAN_RENT_SERVICE);
        this.computerService = (ComputerService) App.getBean(App.BEAN_COMPUTER_SERVICE);
    }

    @Override
    public CiberUI execute() {

        System.out.println("Free computers");
        System.out.println();

        Collection<Computer> computers = computerService.getAll();

        for (Computer computer : computers) {
            if (!computer.isOccupied()) {
                System.out.println(computer.getId() + " - " + computer.getOperativeSystem());
            }
        }

        System.out.println();

        System.out.println("Enter id of computer to assign:");

        Scanner scanner = new Scanner(System.in);

        String selectedOption = scanner.nextLine();

        Computer computer = computerService.findById(selectedOption);

        rentService.assignComputer(computer);

        return (CiberUI) App.getBean(App.BEAN_MAIN_VIEW);
    }

}
