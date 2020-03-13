package StepProjectBooking.dao;

import StepProjectBooking.Flight;
import StepProjectBooking.FlightFinder;
import StepProjectBooking.utils.CustomUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class DaoFlightFile implements DAO<Flight> {
    private File file;

    public DaoFlightFile(String filename){
        this.file=new File(filename);
    }

    @Override
    public Optional<Flight> getByID(int id) {
        return getAll().stream().filter(s -> s.id == id).findFirst();
    }

    @Override
    public Collection<Flight> getAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().map(Flight::parse).collect(Collectors.toList());
        } catch (IOException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Collection<Flight> getAllByİnfo(FlightFinder flightFinder) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().
                    map(Flight::parse)
                    .filter(flight -> flight.getDestination().equalsIgnoreCase(flightFinder.getDestination()))
                    .filter(flight -> flight.getFreeSeats()>=flightFinder.getPassengersCount())
                    .filter(flight -> CustomUtils.parseStringToLocalDateTime(flight.getTime()).toLocalDate().equals(flightFinder.getTime()))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public void infoOrBook(Flight data) {

    }

    @Override
    public void rejectById(int id) {

    }

    @Override
    public void createAll(Collection<Flight> data) {
        write(data);
    }


    private void write(Collection<Flight> flights) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(flights);
        } catch (IOException ex) {
            throw new RuntimeException("DAO:write:IOException", ex);
        }
    }

}
