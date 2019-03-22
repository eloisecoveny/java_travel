import java.util.ArrayList;

public class Flight {

    private String flightNo;
    private Plane plane;
    private AirportCode departingFrom;
    private AirportCode destination;
    private String departureTime;
    private ArrayList<Passenger> passengers;

    public Flight(String flightNo, Plane plane, AirportCode departingFrom, AirportCode destination, String departureTime){
        this.flightNo = flightNo;
        this.plane = plane;
        this.departingFrom = departingFrom;
        this.destination = destination;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<Passenger>();
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

    public String getDepartureTime(){
        return this.departureTime;
    }

    public int countPassengers(){
        return this.passengers.size();
    }

    public void setPlane(Plane plane){
        this.plane = plane;
    }

    public void setDepartureTime(String newTime){
        this.departureTime = newTime;
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
    }
}
