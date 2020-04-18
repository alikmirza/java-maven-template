package StepProjectBooking;

import StepProjectBooking.classes.FlightFinder;
import StepProjectBooking.controller.Controller;
import StepProjectBooking.exception.CustomException;
import StepProjectBooking.utils.CustomUtils;
import java.util.Scanner;

class Console {

    private void myPrint(String message){ System.out.print(message); }

    void run(){

        myPrint("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n" +
                "* Please, select one of the following commands by number  * \n" +
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n" +
                "*  [1] Display all flights                                *\n" +
                "*  [2] Display info about flight                          *\n" +
                "*  [3] Search and book flight                             *\n" +
                "*  [4] Cancel booking                                     *\n" +
                "*  [5] My flights                                         *\n" +
                "*  [6] Exit                                               *\n" +
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" +
                "\n--->\n");

        Scanner in=new Scanner(System.in);
        int number=in.nextInt();
        Controller controller=new Controller();
        switch (number){
            case 1:
                System.out.println(controller.getAllFlights());
                break;
            case 2:
                System.out.println("Input id of the flight: ");
                int id=in.nextInt();
                try {
                    System.out.println(controller.getById(id));
                } catch (CustomException ex){
                    System.err.println(ex.getMessage());
                }
                break;
            case 3:
                FlightFinder flightFinder = CustomUtils.enterInfo();
                controller.searchAndBook(flightFinder);
                break;
            case 4:
                int bookingId;
                System.out.println("Please, enter id of Booking: ");
                bookingId=in.nextInt();
                try {
                    System.out.println(controller.rejectMyBook(bookingId));
                }catch (CustomException ex){
                    System.err.println(ex.getMessage());
                }
                break;
            case 5:
                String name;
                String surname;
                System.out.println("Enter name");
                name=in.next();
                System.out.println("Enter surname");
                surname=in.next();
                System.out.println(controller.getByNameAndSurname(name,surname));
                break;
            case 6:
                System.exit(controller.exitFrom(number));
                break;

        }



    }
}
