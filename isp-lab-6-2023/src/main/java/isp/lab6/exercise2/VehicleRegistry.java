package isp.lab6.exercise2;

import java.util.HashSet;
import java.util.Set;

public class VehicleRegistry {
    private Set<Vehicle> vehicles;

    public VehicleRegistry() {
        this.vehicles = new HashSet<>();
    }

    public boolean addVehicle(Vehicle vehicle) {
        return vehicles.add(vehicle);
    }

    public boolean removeVehicle(String vin) {
        return vehicles.removeIf(vehicle -> vehicle.getVin().equals(vin));
    }

    public boolean containsVehicle(String vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin().equals(vin)) {
                return true;
            }
        }
        return false;
    }

    public void displayVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
