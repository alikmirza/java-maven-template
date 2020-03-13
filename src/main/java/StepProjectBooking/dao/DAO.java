package StepProjectBooking.dao;

import StepProjectBooking.FlightFinder;

import java.util.Collection;
import java.util.Optional;

public interface DAO<A> {
    Optional<A> getByID(int id);
    Collection<A> getAll();
    Collection<A> getAllByİnfo(FlightFinder flightFinder);
    void infoOrBook(A data);
    void rejectById(int id);

    void createAll(Collection<A> data);
}
