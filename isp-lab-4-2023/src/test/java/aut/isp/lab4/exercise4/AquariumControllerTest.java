package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise2.FishFeeder;
import junit.framework.TestCase;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AquariumControllerTest {
    @Test
    public void testSetCurrentTime() {
        FishFeeder fishFeeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        AquariumController aquariumController = new AquariumController("AquaCorp", "AquaMaster 3000", 12.0f, 14.5f, 6.0f, 14.0f, fishFeeder);
        aquariumController.setCurrentTime(15.0f);
        String expected = "AquariumController [manufacturer=AquaCorp, model=AquaMaster 3000, currentTime=15.0, lightsOn=false]";
        assertEquals(expected, aquariumController.toString());
    }

    @Test
    public void testLightsOn() {
        FishFeeder fishFeeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        AquariumController aquariumController = new AquariumController("AquaCorp", "AquaMaster 3000", 12.0f, 14.5f, 6.0f, 14.0f, fishFeeder);
        aquariumController.setCurrentTime(8.0f);
        String expected = "AquariumController [manufacturer=AquaCorp, model=AquaMaster 3000, currentTime=8.0, lightsOn=true]";
        assertEquals(expected, aquariumController.toString());
    }

    @Test
    public void testLightsOff() {
        FishFeeder fishFeeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        AquariumController aquariumController = new AquariumController("AquaCorp", "AquaMaster 3000", 12.0f, 14.5f, 6.0f, 14.0f, fishFeeder);
        aquariumController.setCurrentTime(20.0f);
        String expected = "AquariumController [manufacturer=AquaCorp, model=AquaMaster 3000, currentTime=20.0, lightsOn=false]";
        assertEquals(expected, aquariumController.toString());
    }
}
