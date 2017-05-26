package ns.apprentice.oop.ciber.repository;

import java.util.Collection;

import ns.apprentice.oop.ciber.model.Computer;

public interface ComputerRepository {

    void save(Computer computer);

    void delete(Computer computer);

    Collection<Computer> getAll();

    Computer findById(String computerId);
}
