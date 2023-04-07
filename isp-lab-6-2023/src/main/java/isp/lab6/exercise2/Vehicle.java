package isp.lab6.exercise2;

public class Vehicle {
    private String vin;
    private String licensePlate;
    private String make;
    private String model;
    private int year;

    public Vehicle(String vin, String licensePlate, String make, String model, int year) {
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Vehicle other = (Vehicle) obj;
        return vin.equals(other.vin);
    }

    @Override
    public int hashCode() {
        return vin.hashCode();
    }

    @Override
    public String toString() {
        return "VIN: " + vin + ", License Plate: " + licensePlate + ", Make: " + make + ", Model: " + model + ", Year: " + year;
    }
}

