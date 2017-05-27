package ns.apprentice.oop.ciber.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;

import ns.apprentice.oop.App;
import ns.apprentice.oop.ciber.model.Computer;
import ns.apprentice.oop.ciber.model.RentItem;
import ns.apprentice.oop.ciber.model.User;
import ns.apprentice.oop.ciber.repository.ComputerRepository;
import ns.apprentice.oop.ciber.repository.RentItemRepository;
import ns.apprentice.oop.ciber.service.ConfigurationService;
import ns.apprentice.oop.ciber.service.RentService;

public class RentServiceImpl implements RentService {

    private RentItemRepository rentItemRepository;

    private ComputerRepository computerRepository;

    private ConfigurationService configurationService;

    public RentServiceImpl() {
        this.rentItemRepository = (RentItemRepository) App.getBean(App.BEAN_RENT_ITEM_REPOSITORY);
        this.configurationService = (ConfigurationService) App.getBean(App.BEAN_CONFIGURATION_SERVICE);
        this.computerRepository = (ComputerRepository) App.getBean(App.BEAN_COMPUTER_REPOSITORY);
    }

    @Override
    public void assignComputer(Computer computer) {

        if (computer == null) {
            throw new RuntimeException("Invalid computer");
        }

        RentItem rentItem = rentItemRepository.findOccupiedComputer(computer);

        if (rentItem != null) {
            throw new RuntimeException("Computer already occupied");
        }

        rentItem = new RentItem();

        rentItem.setComputer(computer);
        rentItem.setRentTime(LocalDateTime.now());
        computer.setOccupied(true);

        computerRepository.save(computer);

        rentItemRepository.save(rentItem);
    }

    @Override
    public void assignComputer(Computer computer, User user) {
        RentItem rentItem = rentItemRepository.findOccupiedComputer(computer);

        if (rentItem != null) {
            throw new RuntimeException("Computer already occupied");
        }

        rentItem = new RentItem();

        rentItem.setComputer(computer);
        rentItem.setRentTime(LocalDateTime.now());
        rentItem.setUser(user);

        computer.setOccupied(true);

        computerRepository.save(computer);

        rentItemRepository.save(rentItem);
    }

    @Override
    public double releaseComputer(Computer computer) {
        RentItem rentItem = rentItemRepository.findOccupiedComputer(computer);

        if (rentItem == null) {
            throw new RuntimeException("Computer not in use");
        }

        rentItem.setReleaseTime(LocalDateTime.now());

        Duration duration = Duration.between(rentItem.getRentTime(), rentItem.getReleaseTime());
        double cost = (duration.toHours() + 1) * configurationService.getCostPerHour();

        rentItem.setRentCost(cost);

        rentItemRepository.save(rentItem);

        computer.setOccupied(false);

        computerRepository.save(computer);

        return rentItem.getRentCost();
    }

    @Override
    public Collection<RentItem> getAll() {
        return rentItemRepository.getAll();
    }
}
