import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class Flight {

    private String flightNo;
    private Plane plane;
    private AirportCode departingFrom;
    private AirportCode destination;
    private Date departureTime;
    private SimpleDateFormat format;
    private ArrayList<Passenger> passengers;
    private ArrayList<Integer> seats;

    public Flight(String flightNo, Plane plane, AirportCode departingFrom, AirportCode destination, String departure){
        this.flightNo = flightNo;
        this.plane = plane;
        this.departingFrom = departingFrom;
        this.destination = destination;
        this.format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.UK);
        this.departureTime = new Date();
        this.parseDate(departure);
        this.passengers = new ArrayList<Passenger>();
        this.seats = new ArrayList<Integer>();
        this.generateSeats();
    }

    public String getFlightNo(){
        return this.flightNo;
    }

    public Plane getPlane(){
        return this.plane;
    }

    public AirportCode getDepartingFrom(){
        return this.departingFrom;
    }

    public AirportCode getDestination(){
        return this.destination;
    }

    public Date getDepartureTime(){
        return this.departureTime;
    }

    public int countPassengers(){
        return this.passengers.size();
    }

    public ArrayList<Passenger> getPassengers(){
        return this.passengers;
    }

    public void setPlane(Plane plane){
        this.plane = plane;
    }

    public SimpleDateFormat getFormat(){
        return this.format;
    }

    public void setDepartureTime(String newTime){
        this.parseDate(newTime);
    }

    public int availableSeats(){
        return this.plane.getCapacity() - this.passengers.size();
    }

    public int availableWeight(){
        int totalWeight = 0;
        for(int i = 0; i < passengers.size(); i++){
            totalWeight += (passengers.get(i).getBags() * 30);
        }
        return (this.plane.getWeight() / 2) - totalWeight;
    }

    public void book(Passenger passenger){
        if(this.availableSeats() > 0 && this.availableWeight() >= passenger.getLuggageWeight()){
            this.passengers.add(passenger);
        }
        passenger.assignFlight(this);
        passenger.assignSeat(this.assignSeat());
    }

    private void generateSeats(){
        for(int i = 1; i <= this.plane.getCapacity(); i++){
            this.seats.add(i);
        }
        Collections.shuffle(this.seats);
    }

    public int countRemainingSeats(){
        return this.seats.size();
    }

    public int assignSeat(){
        return this.seats.remove(0);
    }

    public void parseDate(String newTime){
        try {
            this.departureTime = format.parse(newTime);
//            System.out.println(departureTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void sortPassengers(){
        // Bubble sort method
        int n = this.passengers.size();
        Passenger temp;
        for(int i = 0; i < (n-1); i++){
            for(int j = 1; j < n; j++){
                if(passengers.get(j-1).getSeat() > passengers.get(j).getSeat()){
                    temp = passengers.get(j-1);
                    passengers.set(j-1, passengers.get(j));
                    passengers.set(j, temp);
                }
            }
        }
    }
}
