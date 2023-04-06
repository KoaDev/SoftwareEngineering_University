package isp.lab4.exercise2;

import isp.lab4.exercise2.Chargeable;

public class Exercise2 {

    public static void main(String[] args) {
        // Create a laptop, a smartphone and a smartwatch
        Laptop laptop = new Laptop();
        SmartPhone smartPhone = new SmartPhone();
        SmartWatch smartWatch = new SmartWatch();

        // Charge the laptop for 30 minutes
        laptop.charge(30);

        // Charge the smartphone for 60 minutes
        smartPhone.charge(60);

        // Charge the smartwatch for 120 minutes
        smartWatch.charge(120);

        // Print the battery level of the laptop
        System.out.println("Laptop battery level: " + laptop.getBatteryLevel() + "%");

        // Print the battery level of the smartphone
        System.out.println("Smartphone battery level: " + smartPhone.getBatteryLevel() + "%");

        // Print the battery level of the smartwatch
        System.out.println("Smartwatch battery level: " + smartWatch.getBatteryLevel() + "%");
    }
}

// Define the Laptop class
class Laptop implements Chargeable {
    private int batteryLevel;

    public Laptop() {
        batteryLevel = 0;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void charge(int durationInMinutes) {
        int chargingRate = 5; // Laptop charging rate in percentage per minute
        int maxBatteryLevel = 100;

        // Calculate the amount of charge to add based on the duration of charging
        int chargeToAdd = chargingRate * durationInMinutes;

        // Add the charge, but don't exceed the maximum battery level
        batteryLevel = Math.min(batteryLevel + chargeToAdd, maxBatteryLevel);
    }
}

// Define the SmartPhone class
class SmartPhone implements Chargeable {
    private int batteryLevel;

    public SmartPhone() {
        batteryLevel = 0;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void charge(int durationInMinutes) {
        int chargingRate = 10; // Smartphone charging rate in percentage per minute
        int maxBatteryLevel = 100;

        // Calculate the amount of charge to add based on the duration of charging
        int chargeToAdd = chargingRate * durationInMinutes;

        // Add the charge, but don't exceed the maximum battery level
        batteryLevel = Math.min(batteryLevel + chargeToAdd, maxBatteryLevel);
    }
}

// Define the SmartWatch class
class SmartWatch implements Chargeable {
    private int batteryLevel;

    public SmartWatch() {
        batteryLevel = 0;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void charge(int durationInMinutes) {
        int chargingRate = 2; // Smartwatch charging rate in percentage per minute
        int maxBatteryLevel = 100;

        // Calculate the amount of charge to add based on the duration of charging
        int chargeToAdd = chargingRate * durationInMinutes;

        // Add the charge, but don't exceed the maximum battery level
        batteryLevel = Math.min(batteryLevel + chargeToAdd, maxBatteryLevel);
    }
}
