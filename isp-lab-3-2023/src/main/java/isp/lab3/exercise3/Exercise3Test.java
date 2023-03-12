package isp.lab3.exercise3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise3Test {
    @Test
    public void testGettersAndSetters() {
        Exercise3 v1 = new Exercise3("Dacia", "Logan", 150, 'B');
        assertEquals("Dacia", v1.getModel());
        assertEquals("Logan", v1.getType());
        assertEquals(150, v1.getSpeed());
        assertEquals('B', v1.getFuelType());

        v1.setSpeed(170);
        assertEquals(170, v1.getSpeed());
    }

    @Test
    public void testEquals() {
        Exercise3 v1 = new Exercise3("Dacia", "Logan", 150, 'B');
        Exercise3 v2 = new Exercise3("Toyota", "Corolla", 180, 'D');
        Exercise3 v3 = new Exercise3("Dacia", "Logan", 150, 'B');

        assertNotEquals(v1, v2);
        assertEquals(v1, v3);
    }

    @Test
    public void testToString() {
        Exercise3 v1 = new Exercise3("Dacia", "Logan", 150, 'B');
        assertEquals("Dacia (Logan) speed 150 fuel type B", v1.toString());

        Exercise3 v2 = new Exercise3("Toyota", "Corolla", 180, 'D');
        assertEquals("Toyota (Corolla) speed 180 fuel type D", v2.toString());
    }
}
