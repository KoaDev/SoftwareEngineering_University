package aut.isp.lab4.exercise2;

import junit.framework.TestCase;
import org.junit.Test;

public class FishFeederControllerTest extends TestCase {
    @Test
    public void testFishFeederFillUp() {
        FishFeederController fishFeeder = new FishFeederController("Acme Corp.", "FeederMax 3000");
        fishFeeder.fillUp();
        assertEquals(14, fishFeeder.meals);
    }

    @Test
    public void testFishFeederFeed() {
        FishFeederController fishFeeder = new FishFeederController("Acme Corp.", "FeederMax 3000");
        fishFeeder.fillUp();
        fishFeeder.feed();
        assertEquals(13, fishFeeder.meals);
    }
}