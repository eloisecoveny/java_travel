import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class TestFlight {

    public Plane plane1;
    public Plane plane2;
    public Plane plane3;

    public Passenger passenger1;
    public Passenger passenger2;
    public Passenger passenger3;
    public Passenger passenger4;
    public Passenger passenger5;

    public Flight flight1;
    public Flight flight2;
    public Flight flight3;

    @Before
    public void setup(){
        plane1 = new Plane(PlaneType.AIRBUS_A220);
        plane2 = new Plane(PlaneType.BOEING_727);
        plane3 = new Plane(PlaneType.FRIGATE_ECOJET);

        passenger1 = new Passenger("Eloise", 1);
        passenger2 = new Passenger("Alice", 1);
        passenger3 = new Passenger("Elijah", 2);
        passenger4 = new Passenger("Pernille", 1);

        flight1 = new Flight("ER184", plane1, AirportCode.GLA, AirportCode.AKL, "2019-04-01 08:00");
        flight2 = new Flight("AE230", plane2, AirportCode.GLA, AirportCode.BER, "2019-04-01 16:44");
        flight3 = new Flight("SM330", plane3, AirportCode.GLA, AirportCode.ATH, "2019-04-01 18:30");
    }

    @Test
    public void hasFlightNo(){
        assertEquals("ER184", flight1.getFlightNo());
    }

    @Test
    public void hasPlane(){
        assertEquals(plane1, flight1.getPlane());
    }

    @Test
    public void hasDepartingFromAirportCode(){
        assertEquals(AirportCode.GLA, flight1.getDepartingFrom());
    }

    @Test
    public void hasDestinationAirportCode(){
        assertEquals(AirportCode.AKL, flight1.getDestination());
    }

    @Test
    public void hasDepartureTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.UK);
        Date departureTime = new Date();
        try {
            departureTime = format.parse("2019-04-01 08:00");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(departureTime, flight1.getDepartureTime());
    }

    @Test
    public void hasFlightCapacity(){
        assertEquals(130, flight1.getPlane().getCapacity());
    }

    @Test
    public void hasFlightWeight(){
        assertEquals(7800, flight1.getPlane().getWeight());
    }

    @Test
    public void flightStartsWithoutPassengers(){
        assertEquals(0, flight1.countPassengers());
    }

    @Test
    public void canChangeAircraft(){
        flight1.setPlane(plane2);
        assertEquals(plane2, flight1.getPlane());
    }

    @Test
    public void canChangeDepartureTime(){
        flight1.setDepartureTime("2019-04-01 08:30");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.UK);
        Date newDate = new Date();
        try {
            newDate = format.parse("2019-04-01 08:30");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(newDate, flight1.getDepartureTime());
    }

    @Test
    public void canCheckNumberOfAvailableSeats(){
        assertEquals(130, flight1.availableSeats());
    }

    @Test
    public void canCheckAvailableLuggageWeight(){
        assertEquals(3900, flight1.availableWeight());
    }

    @Test
    public void canBookPassengerOnFlight(){
        flight1.book(passenger1);
        assertEquals(1, flight1.countPassengers());
        assertEquals(129, flight1.availableSeats());
        assertEquals(3870, flight1.availableWeight());
    }

    @Test
    public void numberOfRemainingSeatsStartsAtFullCapacity(){
        assertEquals(130, flight1.countRemainingSeats());
    }

    @Test
    public void canAssignASeatToPassengerWhenBookedOnFlight(){
        flight1.book(passenger1);
        assertEquals(129, flight1.countRemainingSeats());
    }

    @Test
    public void canSortPassengersInOrderBySeatNumber(){
        flight3.book(passenger1);
        flight3.book(passenger2);
        flight3.book(passenger3);
        ArrayList<Passenger> sorted = flight3.getPassengers();
        assertEquals(3, flight3.countPassengers());
        assertEquals(1, sorted.get(0).getSeat());
    }

    @Test
    public void canFindPassengerBySeat(){
        flight3.book(passenger1);
        flight3.book(passenger2);
        flight3.book(passenger3);
        flight3.book(passenger4);
        Passenger passenger = flight3.findPassengerBySeat(2, flight3.getPassengers());
        assertEquals(2, passenger.getSeat());
    }
}
