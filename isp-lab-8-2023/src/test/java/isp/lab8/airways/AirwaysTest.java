package isp.lab8.airways;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirwaysTest {
    private Route route;

    @Before
    public void setUp() {
        route = new Route("TestRoute");
    }

    @Test
    public void testAddWaypoint() {
        Waypoint waypoint = new Waypoint("WP1", 12.34, 56.78, 90);
        route.addWaypoint(waypoint);
        assertEquals(1, route.getWaypoints().size());
        assertEquals(waypoint, route.getWaypoints().get(0));
    }

    @Test
    public void testHaversineUtil() {
        double distance = HaversineUtil.calculateDistance(40.7128, -74.0060, 34.0522, -118.2437);
        double expected = 3935.29; // Distance between New York and Los Angeles in km
        assertEquals(expected, distance, 0.5);
    }

    @Test
    public void testGetTotalDistance() {
        Waypoint wp1 = new Waypoint("WP1", 40.7128, -74.0060, 0); // New York
        Waypoint wp2 = new Waypoint("WP2", 34.0522, -118.2437, 0); // Los Angeles
        route.addWaypoint(wp1);
        route.addWaypoint(wp2);
        double expected = 3935.29; // Distance between New York and Los Angeles in km
        assertEquals(expected, route.getTotalDistance(), 0.5);
    }
}
