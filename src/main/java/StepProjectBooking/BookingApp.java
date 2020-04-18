package StepProjectBooking;

import StepProjectBooking.generator.FlightRandomGenerator;

public class BookingApp{

    public static void main(String[] args) {

        Console console=new Console();

        while (true){
            FlightRandomGenerator.generateRandomFlights();
            console.run();
        }
    }
}
