package ns.apprentice.oop.ciber.repository;

import java.util.Collection;

import ns.apprentice.oop.ciber.model.Computer;
import ns.apprentice.oop.ciber.model.RentItem;

public interface RentItemRepository {

    void save(RentItem rentItem);

    Collection<RentItem> getAll();

    RentItem findOccupiedComputer(Computer computer);
}
