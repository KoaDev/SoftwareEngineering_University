package aut.isp.lab4.exercise2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FishFeederTest {
    @Test
    public void testFeed() {
        FishFeeder fishFeeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        fishFeeder.feed();
        String expected = "FishFeeder [manufacturer=FishCorp, model=FishFeeder 1000, meals=13]";
        assertEquals(expected, fishFeeder.toString());
    }

    @Test
    public void testFillUp() {
        FishFeeder fishFeeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        fishFeeder.feed();
        fishFeeder.fillUp();
        String expected = "FishFeeder [manufacturer=FishCorp, model=FishFeeder 1000, meals=14]";
        assertEquals(expected, fishFeeder.toString());
    }
}
