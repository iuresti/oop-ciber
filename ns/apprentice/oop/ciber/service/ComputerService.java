package ns.apprentice.oop.ciber.service;

import java.util.Collection;
import java.util.List;

import ns.apprentice.oop.ciber.model.Computer;

public interface ComputerService {

    void save(Computer user);

    void delete(Computer user);

    Collection<Computer> getAll();

    Computer findById(String selectedOption);

    void createReportOfComputers(List<Computer> computerList);
}
