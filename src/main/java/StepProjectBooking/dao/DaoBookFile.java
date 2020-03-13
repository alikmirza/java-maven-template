package StepProjectBooking.dao;

import StepProjectBooking.Book;
import StepProjectBooking.Flight;
import StepProjectBooking.FlightFinder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class DaoBookFile implements DAO<Book> {

    private File file;

    public DaoBookFile(String filename) {
        this.file=new File(filename);
    }

    @Override
    public Optional<Book> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Book> getAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().map(Book::parse).collect(Collectors.toList());
        } catch (IOException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Collection<Book> getAllByİnfo(FlightFinder flightFinder) {
        return null;
    }

    @Override
    public void infoOrBook(Book data) {

    }


    @Override
    public void rejectById(int id) {

    }

    @Override
    public void createAll(Collection<Book> data) {
        write(data);
    }

    private void write(Collection<Book> books) {
        try (FileWriter oos = new FileWriter(file,true)) {
            oos.append(books.stream().map(Book::represent).collect(Collectors.joining("\n")));
            oos.append("\n");
        } catch (IOException ex) {
            throw new RuntimeException("DAO:write:IOException", ex);
        }
    }


}
