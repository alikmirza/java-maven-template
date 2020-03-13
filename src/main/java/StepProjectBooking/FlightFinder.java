package StepProjectBooking;

import java.time.LocalDate;

public class FlightFinder {
    private String destination;
    private LocalDate time;
    private int passengersCount;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlightFinder{");
        sb.append("destination='").append(destination).append('\'');
        sb.append(", time=").append(time);
        sb.append(", passengersCount=").append(passengersCount);
        sb.append('}');
        return sb.toString();
    }
}
