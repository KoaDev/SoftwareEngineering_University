package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise1.Aquarium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AquariumTest {
    @Test
    public void testSetCurrentTime() {
        Aquarium aquariumController = new Aquarium("AquaCorp", "AquaMaster 3000", 12.0f);
        aquariumController.setCurrentTime(15.0f);
        String expected = "AquariumController [manufacturer=AquaCorp, model=AquaMaster 3000, currentTime=15.0]";
        assertEquals(expected, aquariumController.toString());
    }
}
