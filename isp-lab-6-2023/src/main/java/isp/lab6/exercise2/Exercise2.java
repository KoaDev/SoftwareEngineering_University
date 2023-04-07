package isp.lab6.exercise2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        VehicleRegistry registry = new VehicleRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nUnique Vehicle Registry System");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Check Vehicle");
            System.out.println("4. Display Vehicles");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter VIN: ");
                    String vin = scanner.next();
                    System.out.print("Enter License Plate: ");
                    String licensePlate = scanner.next();
                    System.out.print("Enter Make: ");
                    String make = scanner.next();
                    System.out.print("Enter Model: ");
                    String model = scanner.next();
                    System.out.print("Enter Year: ");
                    int year = scanner.nextInt();

                    Vehicle vehicle = new Vehicle(vin, licensePlate, make, model, year);
                    if (registry.addVehicle(vehicle)) {
                        System.out.println("Vehicle added successfully.");
                    } else {
                        System.out.println("Vehicle with the same VIN already exists.");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter VIN to remove: ");
                    String vin = scanner.next();
                    if (registry.removeVehicle(vin)) {
                        System.out.println("Vehicle removed successfully.");
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter VIN to check: ");
                    String vin = scanner.next();
                    if (registry.containsVehicle(vin)) {
                        System.out.println("Vehicle found in the registry.");
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Vehicle List:");
                    registry.displayVehicles();
                    break;
                }
                case 5: {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                    break;
                }
            }
        }
    }
}
