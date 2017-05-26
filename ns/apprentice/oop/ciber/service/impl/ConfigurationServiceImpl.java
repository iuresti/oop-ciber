package ns.apprentice.oop.ciber.service.impl;

import ns.apprentice.oop.ciber.service.ConfigurationService;

public class ConfigurationServiceImpl implements ConfigurationService {


    private double costPerHour = 8.0;

    @Override
    public double getCostPerHour() {
        return costPerHour;
    }
}
