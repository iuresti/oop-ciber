package ns.apprentice.oop.ciber.service.impl;

import java.util.Collection;

import ns.apprentice.oop.App;
import ns.apprentice.oop.ciber.model.Computer;
import ns.apprentice.oop.ciber.repository.ComputerRepository;
import ns.apprentice.oop.ciber.service.ComputerService;

public class ComputerServiceImpl implements ComputerService {

    private ComputerRepository computerRepository;

    public ComputerServiceImpl() {
        this.computerRepository = (ComputerRepository) App.getBean(App.BEAN_COMPUTER_REPOSITORY);
    }

    @Override
    public void save(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public void delete(Computer computer) {
        computerRepository.delete(computer);
    }

    @Override
    public Collection<Computer> getAll() {
        return computerRepository.getAll();
    }
}
