package StepProjectBooking;

import StepProjectBooking.controller.Controller;
import StepProjectBooking.exception.CustomException;
import StepProjectBooking.utils.CustomUtils;

import java.util.Collection;
import java.util.Scanner;

public class BookingApp{

    public static void main(String[] args) {
        Controller controller=new Controller();
        Scanner in=new Scanner(System.in);
        int number=in.nextInt();
        while (true){
            switch (number){
                case 1:
                    System.out.println(controller.getAllFlights());
                    break;
                case 2:
                    System.out.printf("Input id of flight");
                    int id=in.nextInt();
                    try {
                        System.out.println(controller.getById(id));
                    } catch (CustomException ex){
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 3:
                    FlightFinder flightFinder = CustomUtils.enterInfo();
                    Collection<String> flights = controller.getAllFlightsByFlightFinder(flightFinder);
                    System.out.println(flights.toString());
                    System.out.println(CustomUtils.bookOrExit(flights,flightFinder));

            }
            break;
        }
    }
}
