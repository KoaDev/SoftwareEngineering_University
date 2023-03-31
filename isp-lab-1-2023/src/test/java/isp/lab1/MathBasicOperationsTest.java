package isp.lab1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathBasicOperationsTest {

    @Test
    public void testAdd(){
        assertEquals("Should add 2 numbers", 30, MathBasicOperations.add(10,20));
    }

    @Test
    public void testSubstract(){
        assertEquals("Should substract 2 numbers", 5, MathBasicOperations.substract(15,10));
    }

    @Test
    public void testMultiply(){
        assertEquals("Should multiply 2 numbers", 100, MathBasicOperations.multiply(10,10));
    }
}
