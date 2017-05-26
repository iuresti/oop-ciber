package ns.apprentice.oop.ciber.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ns.apprentice.oop.ciber.model.Computer;
import ns.apprentice.oop.ciber.model.RentItem;
import ns.apprentice.oop.ciber.repository.RentItemRepository;

public class RentItemRepositoryImpl implements RentItemRepository {

    HashMap<String, RentItem> rentItems;

    public RentItemRepositoryImpl() {
        rentItems = new HashMap<>();
    }

    @Override
    public void save(RentItem rentItem) {

        if (rentItem.getId() == null) {
            rentItem.setId(UUID.randomUUID().toString());
        }

        rentItems.put(rentItem.getId(), rentItem);
    }

    @Override
    public Collection<RentItem> getAll() {
        return rentItems.values();
    }

    @Override
    public RentItem findOccupiedComputer(Computer computer) {


        for (Map.Entry<String, RentItem> itemEntry : rentItems.entrySet()) {
            RentItem rentItem = itemEntry.getValue();

            if (rentItem.getComputer().getId().equals(computer.getId()) &&
                    rentItem.getReleaseTime() == null) {
                return rentItem;
            }
        }

        return null;
    }
}
