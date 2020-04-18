package StepProjectBooking.dao;

import StepProjectBooking.classes.FlightFinder;
import StepProjectBooking.classes.Passenger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class DaoPassengerFile implements DAO<Passenger> {

    private File file;

    public DaoPassengerFile(String filename){
    this.file=new File(filename);
}



    @Override
    public Optional<Passenger> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Passenger> getAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().map(Passenger::parse).collect(Collectors.toList());
        } catch (IOException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Collection<Passenger> getMyFlights(String name, String surname) {
        return getAll().stream().filter(passenger->passenger.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    @Override
    public Collection<Passenger> getAllByInfo(FlightFinder flightFinder) {
        return null;
    }


    @Override
    public Collection<Passenger> rejectById(int id) { return null; }

    @Override
    public int exit(int command) { return 0; }

    @Override
    public void createAll(Collection<Passenger> data) {
        write(data);
    }

    @Override
    public void changeTheNumberOfFreeSeats(int id, int count) {

    }


    private void write(Collection<Passenger> passengers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(passengers);
        } catch (IOException ex) {
            throw new RuntimeException("DAO:write:IOException", ex);
        }
    }

}
