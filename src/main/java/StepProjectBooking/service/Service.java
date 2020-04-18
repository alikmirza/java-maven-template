package StepProjectBooking.service;

import StepProjectBooking.classes.Book;
import StepProjectBooking.classes.Flight;
import StepProjectBooking.classes.FlightFinder;
import StepProjectBooking.classes.Passenger;
import StepProjectBooking.dao.DAO;
import StepProjectBooking.dao.DaoBookFile;
import StepProjectBooking.dao.DaoFlightFile;
import StepProjectBooking.dao.DaoPassengerFile;
import StepProjectBooking.exception.CustomException;

import java.util.*;
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

    public Collection<String> getAllMyFlights(String name, String surname){
        return daoBookFile.getMyFlights(name,surname).stream().
                map(Book::getFlightId).
                map(id->getById(id).get()).
                collect(Collectors.toList());
    }

    public Collection<String> rejectMyBooking(int id){
        changeTheNumberOfFreeSeats(daoBookFile.getByID(id).get().getFlightId(),1);
        return daoBookFile.rejectById(id).stream().map(Book::represent).collect(Collectors.toList());
    }


    public Collection<String> getinfo(FlightFinder flightFinder) {
        return daoFlightFile.getAllByInfo(flightFinder).stream()
                .map(Flight::represent)
                .collect(Collectors.toList());
    }
    public int exitFrom(int command){
        return daoFlightFile.exit(command);
    }

    public int lastBookId() {
        int count = daoBookFile.getAll().size();
        if (count == 0) return count;
        return daoBookFile.getAll().stream().skip(count-1).findFirst().get().getId();
    }
    public int lastFlightsId() {
        return daoFlightFile.getAll().size() == 0 ? 1 : daoFlightFile.getAll().size();
    }
    public void writeBook(Collection<Book> books) {
        daoBookFile.createAll(books);
    }

    public String book(Collection<String> flights, FlightFinder flightFinder) {
        System.out.println("1) If you want to book ticket\n" +
                "* Please, enter the serial number of the flight: \n" +
                "2) If you do not want to book ticket\n" +
                "* Please, enter 0 to go the main menu\n");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num == 0) return "The main menu";
        String flightForBook = flights.stream()
                .filter(s -> s.split(":")[0].equalsIgnoreCase(String.valueOf(num)))
                .findFirst()
                .orElseThrow(() -> new CustomException("The serial number is invalid"));
        Integer flightId = Integer.valueOf(flightForBook.split(":")[0]);
        System.out.println(flightForBook);
        int countForBook = flightFinder.getPassengersCount();
        int lastIndex = lastBookId();
        Collection<Book> bookCollection = new ArrayList<>();
        while (countForBook-->0){
            System.out.println("Please enter your name:" );
            String name = in.next();
            System.out.println("Please, enter your surname: ");
            String surname = in.next();
            Book book = new Book(++lastIndex,flightId,
                    new Passenger(name,surname));
            bookCollection.add(book);
        }
        writeBook(bookCollection);
        changeTheNumberOfFreeSeats(flightId,-bookCollection.size());
        return bookCollection.toString();
    }

    public void changeTheNumberOfFreeSeats(int flightId,int count) {
        daoFlightFile.changeTheNumberOfFreeSeats(flightId,count);
    }

    public void writeFlights(Collection<Flight> flights) {
        daoFlightFile.createAll(flights);
    }

}