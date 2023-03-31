package aut.isp.lab4.exercise3;

import aut.isp.lab4.exercise2.FishFeeder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AquariumControllerTest {
    @Test
    public void testSetCurrentTime() {
        FishFeeder fishFeeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        AquariumController aquariumController = new AquariumController("AquaCorp", "AquaMaster 3000", 12.0f, 14.5f, fishFeeder);
        aquariumController.setCurrentTime(15.0f);
        String expected = "AquariumController [manufacturer=AquaCorp, model=AquaMaster 3000, currentTime=15.0]";
        assertEquals(expected, aquariumController.toString());
    }

    @Test
    public void testFeedAtFeedingTime() {
        FishFeeder fishFeeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        AquariumController aquariumController = new AquariumController("AquaCorp", "AquaMaster 3000", 12.0f, 14.5f, fishFeeder);
        aquariumController.setCurrentTime(14.5f);
        String expected = "FishFeeder [manufacturer=FishCorp, model=FishFeeder 1000, meals=13]";
        assertEquals(expected, fishFeeder.toString());
    }
}
