package aut.isp.lab4.exercise3;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder(String manufacturer, String model, int meals) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = meals;
    }

    public void feed() {
        meals--;
    }

    public void fillUp() {
        meals = 14;
    }

    public int getMeals() {
        return meals;
    }

    @Override
    public String toString() {
        return "FishFeeder{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", meals=" + meals +
                '}';
    }
}
