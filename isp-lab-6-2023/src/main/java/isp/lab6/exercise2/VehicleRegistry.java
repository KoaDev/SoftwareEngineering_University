package isp.lab6.exercise2;

import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {
    private final Map<String, Vehicle> vehicles;

    public VehicleRegistry() {
        this.vehicles = new HashMap<>();
    }

    public boolean addVehicle(Vehicle vehicle) {
        return vehicles.putIfAbsent(vehicle.getVin(), vehicle) == null;
    }

    public boolean removeVehicle(String vin) {
        return vehicles.remove(vin) != null;
    }

    public boolean containsVehicle(String vin) {
        return vehicles.containsKey(vin);
    }

    public void displayVehicles() {
        for (Vehicle vehicle : vehicles.values()) {
            System.out.println(vehicle);
        }
    }
}
