package isp.lab3.exercise4;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise4Test {
        @Test
        public void testDefaultConstructor() {
            Exercise4 point = new Exercise4();
            assertEquals("(0, 0, 0)", point.toString());
        }

        @Test
        public void testConstructorWithParameters() {
            Exercise4 point = new Exercise4(1, 2, 3);
            assertEquals("(1, 2, 3)", point.toString());
        }

        @Test
        public void testSetX() {
            Exercise4 point = new Exercise4();
            point.setX(1);
            assertEquals("(1, 0, 0)", point.toString());
        }

        @Test
        public void testSetY() {
            Exercise4 point = new Exercise4();
            point.setY(1);
            assertEquals("(0, 1, 0)", point.toString());
        }

        @Test
        public void testSetZ() {
            Exercise4 point = new Exercise4();
            point.setZ(1);
            assertEquals("(0, 0, 1)", point.toString());
        }

        @Test
        public void testSetXYZ() {
            Exercise4 point = new Exercise4();
            point.setXYZ(1, 2, 3);
            assertEquals("(1, 2, 3)", point.toString());
        }

        @Test
        public void testDistance() {
            Exercise4 p1 = new Exercise4(1, 2, 3);
            Exercise4 p2 = new Exercise4(4, 5, 6);
            assertEquals(5.196152422706632, p1.distance(p2), 0.0001);

            Exercise4 p3 = new Exercise4(0, 0, 0);
            Exercise4 p4 = new Exercise4(1, 1, 1);
            assertEquals(1.7320508075688772, p3.distance(p4), 0.0001);
        }

}