package StepProjectBooking;

public class Flight {
    public final int id;
    final String time;
    final String destination;
    final int freeSeats;

    public Flight(int id, String time, String destination, int freeSeats) {
        this.id = id;
        this.time = time;
        this.destination = destination;
        this.freeSeats=freeSeats;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getDestination() {
        return destination;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public static Flight parse(String line) {
        String[] chunks = line.split(":");
        return new Flight(
                Integer.parseInt(chunks[0]),
               chunks[1]+ ":" + chunks[2],
                chunks[3],
                Integer.parseInt(chunks[4])
        );
    }

    public String represent() {
        return String.format("%d:%s:%s:%d", id, time, destination, freeSeats);
    }


    @Override
    public String toString() {
        return String.format("Flight[number=%d, time='%s', destination=%s, number of free seats=%d]", id, time, destination, freeSeats);
    }

}
