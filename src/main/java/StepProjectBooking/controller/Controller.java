package StepProjectBooking.controller;

import StepProjectBooking.Book;
import StepProjectBooking.FlightFinder;
import StepProjectBooking.service.Service;
import StepProjectBooking.exception.CustomException;

import java.util.Collection;

public class Controller {

    private Service service=new Service();


    public String getAllFlights() {
        Collection<String> allFlights = service.getAllFlights();
        return allFlights.toString();
    }

    public String getById(int id) {
        return service.getById(id).orElseThrow(()-> new CustomException("Flight with this id does not exists"));
    }

    public Collection<String> getAllFlightsByFlightFinder(FlightFinder flightFinder) {
        Collection<String> allFlights = service.getAllFlightsByFlightFinder(flightFinder);
        return allFlights;
    }

    public String bookById(int id){
        return service.getById(id).orElseThrow(()->new CustomException("Flight with this id does not exists"));
    }

    public int lastBookId() {
        return service.lastBookId();
    }
    public void writeBook(Collection<Book> books) {
        service.writeBook(books);
    }





}
