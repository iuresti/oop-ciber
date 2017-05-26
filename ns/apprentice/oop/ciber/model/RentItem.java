package ns.apprentice.oop.ciber.model;

import java.time.LocalDateTime;

public class RentItem {

    private String id;
    private LocalDateTime rentTime;
    private LocalDateTime releaseTime;
    private Computer computer;
    private User user;
    private double rentCost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getRentTime() {
        return rentTime;
    }

    public void setRentTime(LocalDateTime rentTime) {
        this.rentTime = rentTime;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double restCost) {
        this.rentCost = restCost;
    }

    @Override
    public String toString() {
        return "RentItem{" +
                "id='" + id + '\'' +
                ", rentTime=" + rentTime +
                ", releaseTime=" + releaseTime +
                ", computer=" + computer +
                ", user=" + user +
                ", rentCost=" + rentCost +
                '}';
    }
}
