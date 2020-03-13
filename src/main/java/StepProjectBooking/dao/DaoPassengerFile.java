package StepProjectBooking.dao;

import StepProjectBooking.FlightFinder;
import StepProjectBooking.Passenger;

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
    public Collection<Passenger> getAllByİnfo(FlightFinder flightFinder) {
        return null;
    }

    @Override
    public void infoOrBook(Passenger data) {

    }


    @Override
    public void rejectById(int id) {

    }

    @Override
    public void createAll(Collection<Passenger> data) {
        write(data);
    }


    private void write(Collection<Passenger> passengers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(passengers);
        } catch (IOException ex) {
            throw new RuntimeException("DAO:write:IOException", ex);
        }
    }

}
