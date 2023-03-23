package aut.isp.lab4.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AquariumControllerTest {
    @Test
    public void testAquariumControllerToString() {
        AquariumController aquariumController = new AquariumController("Acme Corp.", "AquaMaster 2000");
        aquariumController.setCurrentTime(10.5f);
        String expected = "AquariumController manufactured by Acme Corp., model AquaMaster 2000, current time is 10.5";
        assertEquals(expected, aquariumController.toString());
    }
}
