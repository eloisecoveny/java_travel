import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlane {

    public Plane plane1;
    public Plane plane2;

    @Before
    public void setup(){
        plane1 = new Plane(PlaneType.AIRBUS_A220);
        plane2 = new Plane(PlaneType.ATR_42);
    }

    @Test
    public void planeHasType(){
        assertEquals(PlaneType.AIRBUS_A220, plane1.getType());
    }

    @Test
    public void planeHasCapacity(){
        assertEquals(130, plane1.getCapacity());
    }

    @Test
    public void planeHasWeight(){
        assertEquals(7800, plane1.getWeight());
    }
}
