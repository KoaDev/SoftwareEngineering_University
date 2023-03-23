package aut.isp.lab4.exercise3;

public class FishFeederController {
    private FishFeeder fishFeeder;

    public FishFeederController(FishFeeder fishFeeder) {
        this.fishFeeder = fishFeeder;
    }

    public void feed() {
        if (fishFeeder.getMeals() > 0) {
            fishFeeder.feed();
            System.out.println("Feeding fish...");
        } else {
            System.out.println("No more meals left in the fish feeder!");
        }
    }

    public void fillUp() {
        fishFeeder.fillUp();
        System.out.println("Fish feeder refilled!");
    }

    @Override
    public String toString() {
        return "FishFeederController{" +
                "fishFeeder=" + fishFeeder +
                '}';
    }
}
