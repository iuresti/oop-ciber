package ns.apprentice.oop.ciber.service;

import java.util.Collection;

import ns.apprentice.oop.ciber.model.Computer;
import ns.apprentice.oop.ciber.model.RentItem;
import ns.apprentice.oop.ciber.model.User;

public interface RentService {

    void assignComputer(Computer computer);

    void assignComputer(Computer computer, User user);

    double releaseComputer(Computer computer);

    Collection<RentItem> getAll();
}
