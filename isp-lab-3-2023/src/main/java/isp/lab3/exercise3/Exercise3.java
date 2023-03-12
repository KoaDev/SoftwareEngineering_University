package isp.lab3.exercise3;

import java.util.Objects;

public class Exercise3 {
    private String model;
    private String type;
    private int speed;
    private char fuelType;
    private static int count = 0;

    public Exercise3(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        count++;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getFuelType() {
        return fuelType;
    }

    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }

    public static int getCount() {
        return count;
    }

    public static void displayCount() {
        System.out.println("Number of vehicles created: " + count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercise3)) return false;
        Exercise3 vehicle = (Exercise3) o;
        return speed == vehicle.speed &&
                fuelType == vehicle.fuelType &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(type, vehicle.type);
    }

    @Override
    public String toString() {
        return model + " (" + type + ") speed " + speed + " fuel type " + fuelType;
    }
}
