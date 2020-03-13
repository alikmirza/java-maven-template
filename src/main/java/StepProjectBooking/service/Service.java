package StepProjectBooking.service;

import StepProjectBooking.Book;
import StepProjectBooking.Flight;
import StepProjectBooking.FlightFinder;
import StepProjectBooking.Passenger;
import StepProjectBooking.dao.DAO;
import StepProjectBooking.dao.DaoBookFile;
import StepProjectBooking.dao.DaoFlightFile;
import StepProjectBooking.dao.DaoPassengerFile;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {

    private DAO<Passenger> daoPassengerFile=new DaoPassengerFile("C:\\Users\\mirza\\IdeaProjects\\java-maven-template\\src\\main\\java\\StepProjectBooking\\filesTxt\\Passengers.txt");
    private DAO<Flight> daoFlightFile=new DaoFlightFile("C:\\Users\\mirza\\IdeaProjects\\java-maven-template\\src\\main\\java\\StepProjectBooking\\filesTxt\\Flights.txt");
    private DAO<Book> daoBookFile=new DaoBookFile("C:\\Users\\mirza\\IdeaProjects\\java-maven-template\\src\\main\\java\\StepProjectBooking\\filesTxt\\Book.txt");


    public Collection<String> getAllFlights() {
        return daoFlightFile.getAll().stream().map(Flight::represent).collect(Collectors.toList());
    }

    public Optional<String> getById(int id){
        return daoFlightFile.getByID(id).map(Flight::represent);
    }
    public Collection<String> getAllFlightsByFlightFinder(FlightFinder flightFinder) {
        return daoFlightFile.getAllByİnfo(flightFinder).stream()
                .map(Flight::represent)
                .collect(Collectors.toList());
    }

    public Optional<String> bookById(int id){
        return daoBookFile.getByID(id).map(Book::represent);
    }

    public int lastBookId() {
        return daoBookFile.getAll().size() == 0 ? 1 : daoBookFile.getAll().size();
    }
    public void writeBook(Collection<Book> books) {
        daoBookFile.createAll(books);
    }




}