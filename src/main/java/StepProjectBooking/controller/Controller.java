package StepProjectBooking.controller;

import StepProjectBooking.classes.Book;
import StepProjectBooking.classes.Flight;
import StepProjectBooking.classes.FlightFinder;
import StepProjectBooking.classes.Passenger;
import StepProjectBooking.service.Service;
import StepProjectBooking.exception.CustomException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Controller {

    private Service service=new Service();

    public String getAllFlights() {
        Collection<String> allFlights = service.getAllFlights();
        return allFlights.toString();
    }

    public String getById(int id) {
        return service.getById(id).orElseThrow(()-> new CustomException("Flight with this id does not exists"));
    }

    public String getByNameAndSurname(String name, String surname){
        Collection<String> myFlights = service.getAllMyFlights(name,surname);
        return myFlights.toString();
    }

    public String rejectMyBook(int id){
        Collection<String> myBookings = service.rejectMyBooking(id);
        return myBookings.toString();
    }

    public int exitFrom(int command){
        return service.exitFrom(command);
    }

    public Collection<String> info(FlightFinder flightFinder) {
        Collection<String> allFlights = service.getinfo(flightFinder);
        return allFlights;
    }

    public String bookById(int id){
        return service.getById(id).orElseThrow(()->new CustomException("Flight with this id does not exists"));
    }

    public int lastBookId() {
        return service.lastBookId();
    }
    public int lastFlightsId(){
        return service.lastFlightsId();
    }

    public void writeBook(Collection<Book> books) {
        service.writeBook(books);
    }

    public void searchAndBook(FlightFinder flightFinder){
        Collection<String> flights = info(flightFinder);
        System.out.println(flights.toString());
        book(flights,flightFinder);
    }
    public String book(Collection<String> flights, FlightFinder flightFinder) {
       return service.book(flights,flightFinder);
    }

    public void writeFlights(Collection<Flight> flights) {
        service.writeFlights(flights);
    }


}
