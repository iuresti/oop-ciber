package ns.apprentice.oop.ciber.model;

import java.util.List;

public class Computer {

    private String id;
    private String place;
    private String operativeSystem;
    private int ramGb;
    private int hddGb;
    private boolean occupied;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getOperativeSystem() {
        return operativeSystem;
    }

    public void setOperativeSystem(String operativeSystem) {
        this.operativeSystem = operativeSystem;
    }

    public int getRamGb() {
        return ramGb;
    }

    public void setRamGb(int ramGb) {
        this.ramGb = ramGb;
    }

    public int getHddGb() {
        return hddGb;
    }

    public void setHddGb(int hddGb) {
        this.hddGb = hddGb;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id='" + id + '\'' +
                ", place='" + place + '\'' +
                ", operativeSystem='" + operativeSystem + '\'' +
                ", ramGb=" + ramGb +
                ", hddGb=" + hddGb +
                ", occupied=" + occupied +
                '}';
    }

    public void createReportOfComputers(List<Computer> computerList) {
        computerList.forEach(System.out::println);
    }
}
