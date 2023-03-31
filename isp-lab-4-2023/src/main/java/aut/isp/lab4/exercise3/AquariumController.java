package aut.isp.lab4.exercise3;

import aut.isp.lab4.exercise2.FishFeeder;

public class AquariumController {
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private FishFeeder fishFeeder;

    public AquariumController(String manufacturer, String model, float currentTime, float feedingTime, FishFeeder fishFeeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.fishFeeder = fishFeeder;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (currentTime == feedingTime) {
            fishFeeder.feed();
        }
    }

    @Override
    public String toString() {
        return "AquariumController [manufacturer=" + manufacturer + ", model=" + model + ", currentTime=" + currentTime + "]";
    }

    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        AquariumController aquariumController = new AquariumController("AquaCorp", "AquaMaster 3000", 12.0f, 14.5f, fishFeeder);

        System.out.println(aquariumController);
        System.out.println(fishFeeder);

        aquariumController.setCurrentTime(14.5f);
        System.out.println(aquariumController);
        System.out.println(fishFeeder);
    }
}
