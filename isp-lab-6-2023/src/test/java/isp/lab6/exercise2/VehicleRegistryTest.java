package isp.lab6.exercise2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehicleRegistryTest {
    private VehicleRegistry registry;
    private Vehicle vehicle1;
    private Vehicle vehicle2;

    @BeforeEach
    public void setUp() {
        registry = new VehicleRegistry();
        vehicle1 = new Vehicle("1ABC123");
        vehicle2 = new Vehicle("1ABC123");
    }

    @Test
    public void testAddVehicle() {
        assertTrue(registry.addVehicle(vehicle1), "Vehicle 1 should be added.");
        assertFalse(registry.addVehicle(vehicle2), "Vehicle 2 should not be added since it has the same VIN.");
    }

    @Test
    public void testRemoveVehicle() {
        registry.addVehicle(vehicle1);
        assertTrue(registry.removeVehicle("1ABC123"), "Vehicle 1 should be removed.");
        assertFalse(registry.containsVehicle("1ABC123"), "Vehicle 1 should not be in the registry after removal.");
    }

    @Test
    public void testContainsVehicle() {
        registry.addVehicle(vehicle1);
        assertTrue(registry.containsVehicle("1ABC123"), "Vehicle 1 should be in the registry.");
        assertFalse(registry.containsVehicle("2DEF456"), "Vehicle with VIN '2DEF456' should not be in the registry.");
    }
}
