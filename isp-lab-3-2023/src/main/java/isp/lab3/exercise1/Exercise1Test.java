package isp.lab3.exercise1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Exercise1Test {

    @Test
    public void testGrow() {
        Exercise1 tree = new Exercise1();
        tree.grow(5);
        assertEquals("Height of tree is 20 meters.", tree.toString());
    }

    @Test
    public void testToString() {
        Exercise1 tree = new Exercise1();
        assertEquals("Height of tree is 15 meters.", tree.toString());
    }

    @Test
    public void testDefaultConstructor() {
        Exercise1 tree = new Exercise1();
        assertEquals("Height of tree is 15 meters.", tree.toString());
    }
}