package isp.lab2.Exercise2PrimeProduct;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeProductTest {

    @Test
    public void testPrimeProduct() {
        int n = 10;
        int m = 20;
        long expected = 46189L;
        long actual = Exercise2PrimeProduct.getPrimeProduct(n, m);
        assertEquals(expected, actual);
    }
}
