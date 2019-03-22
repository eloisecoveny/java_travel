import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPassenger {

    public Passenger passenger1;
    public Passenger passenger2;

    @Before
    public void setup(){
        passenger1 = new Passenger("Eloise", 1);
        passenger2 = new Passenger("Alice", 2);
    }

    @Test
    public void shouldHaveName(){
        assertEquals("Eloise", passenger1.getName());
    }

    @Test
    public void shouldHaveBags(){
        assertEquals(1, passenger1.getBags());
    }

    @Test
    public void canCalculateLuggageWeight(){
        assertEquals(30, passenger1.getLuggageWeight());
    }
}
