import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPassenger {

    public Passenger passenger1;
    public Passenger passenger2;
    public Plane plane;
    public Flight flight1;
    public Flight flight2;

    @Before
    public void setup(){
        passenger1 = new Passenger("Eloise", 1);
        passenger2 = new Passenger("Alice", 2);

        plane = new Plane(PlaneType.AIRBUS_A220);

        flight1 = new Flight("ER184", plane, AirportCode.GLA, AirportCode.AKL, "08:00");
        flight2 = new Flight("AE230", plane, AirportCode.GLA, AirportCode.BER, "16:44");
    }

    @Test
    public void hasName(){
        assertEquals("Eloise", passenger1.getName());
    }

    @Test
    public void hasBags(){
        assertEquals(1, passenger1.getBags());
    }

    @Test
    public void canCalculateLuggageWeight(){
        assertEquals(30, passenger1.getLuggageWeight());
    }

    @Test
    public void canBeAssignedAFlight(){
        flight1.book(passenger1);
        assertEquals(flight1, passenger1.getFlight());
        assertEquals(1, flight1.countPassengers());
    }
}
