import java.util.ArrayList;

public class Passenger {

    private String name;
    private int bags;
    private Flight flight;
    private int seat;

    public Passenger(String name, int bags){
        this.name = name;
        this.bags = bags;
        this.flight = flight;
        this.seat = seat;
    }

    public String getName(){
        return this.name;
    }

    public int getBags(){
        return this.bags;
    }

    public int getLuggageWeight(){
        return this.bags * 30;
    }

    public void assignFlight(Flight flight){
        this.flight = flight;
    }

    public Flight getFlight(){
        return this.flight;
    }

    public void assignSeat(int seat){
        this.seat = seat;
    }

    public int getSeat(){
        return this.seat;
    }
}
