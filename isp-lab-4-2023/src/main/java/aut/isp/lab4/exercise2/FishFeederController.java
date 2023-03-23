package aut.isp.lab4.exercise2;

public class FishFeederController {
    private String manufacturer;
    private String model;
    int meals;

    public FishFeederController(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = 0;
    }

    public void feed() {
        if (meals > 0) {
            meals--;
            System.out.println("Feeding the fish. Remaining meals: " + meals);
        } else {
            System.out.println("No meals left.");
        }
    }

    public void fillUp() {
        meals = 14;
        System.out.println("Fish feeder refilled. Total meals: " + meals);
    }

    public String toString() {
        return "FishFeeder manufactured by " + manufacturer +
                ", model " + model +
                ", total meals: " + meals;
    }
}