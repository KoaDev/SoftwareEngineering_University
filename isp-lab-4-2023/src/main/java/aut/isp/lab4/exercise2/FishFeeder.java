package aut.isp.lab4.exercise2;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = 14;
    }

    public void feed() {
        if (meals > 0) {
            meals--;
            System.out.println("Feeding the fish. Meals remaining: " + meals);
        } else {
            System.out.println("No meals left. Please fill up the fish feeder.");
        }
    }

    public void fillUp() {
        meals = 14;
        System.out.println("Fish feeder filled up. Meals available: " + meals);
    }

    @Override
    public String toString() {
        return "FishFeeder [manufacturer=" + manufacturer + ", model=" + model + ", meals=" + meals + "]";
    }

    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        System.out.println(fishFeeder);
        fishFeeder.feed();
        System.out.println(fishFeeder);
        fishFeeder.fillUp();
        System.out.println(fishFeeder);
    }
}
