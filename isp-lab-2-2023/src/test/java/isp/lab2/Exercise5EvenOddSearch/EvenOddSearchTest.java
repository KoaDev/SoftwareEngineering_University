package isp.lab2.Exercise5EvenOddSearch;

import static org.junit.Assert.*;
import org.junit.Test;

public class EvenOddSearchTest {

    @Test
    public void testEvenOddSearch() {
        String input = "5,2,4,7,3,8,1,6";
        //largest even, index, smallest odd, index
        int[] expected = {8, 5, 1, 6};
        int[] actual = Exercise5EvenOddSearch.findEvenOdd(input);
        assertArrayEquals(expected, actual);
    }

}
