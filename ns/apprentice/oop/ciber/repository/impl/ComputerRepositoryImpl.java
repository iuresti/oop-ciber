package ns.apprentice.oop.ciber.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import ns.apprentice.oop.ciber.model.Computer;
import ns.apprentice.oop.ciber.repository.ComputerRepository;

public class ComputerRepositoryImpl implements ComputerRepository {

    private HashMap<String, Computer> computers;

    public ComputerRepositoryImpl() {
        computers = new HashMap<>();
        Computer computer;

        computer = new Computer();
        computer.setId(UUID.randomUUID().toString());
        computer.setHddGb(500);
        computer.setOperativeSystem("Windows");
        computer.setRamGb(16);
        computer.setPlace("1");

        computers.put(computer.getId(), computer);

        computer = new Computer();
        computer.setId(UUID.randomUUID().toString());
        computer.setHddGb(250);
        computer.setOperativeSystem("Windows");
        computer.setRamGb(16);
        computer.setPlace("2");

        computers.put(computer.getId(), computer);

        computer = new Computer();
        computer.setId(UUID.randomUUID().toString());
        computer.setHddGb(250);
        computer.setOperativeSystem("Linux");
        computer.setRamGb(16);
        computer.setPlace("3");

        computers.put(computer.getId(), computer);
    }

    @Override
    public void save(Computer computer) {

        if (computer.getId() == null) {
            computer.setId(UUID.randomUUID().toString());
        }

        computers.put(computer.getId(), computer);
    }

    @Override
    public void delete(Computer computer) {
        computers.remove(computer.getId());
    }

    @Override
    public Collection<Computer> getAll() {
        return computers.values();
    }
}
