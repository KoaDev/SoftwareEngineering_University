package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise2.FishFeeder;

import java.util.ArrayList;
import java.util.List;

public class AquariumController {
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private float lightsOnTime;
    private float lightsOffTime;
    private boolean lightsOn;
    private FishFeeder fishFeeder;

    public AquariumController(String manufacturer, String model, float currentTime, float feedingTime, float lightsOnTime, float lightsOffTime, FishFeeder fishFeeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.lightsOnTime = lightsOnTime;
        this.lightsOffTime = lightsOffTime;
        this.lightsOn = false;
        this.fishFeeder = fishFeeder;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (currentTime == feedingTime) {
            fishFeeder.feed();
        }
        if (currentTime >= lightsOnTime && currentTime < lightsOffTime) {
            lightsOn = true;
            System.out.println("Lights turned on.");
        } else {
            lightsOn = false;
            System.out.println("Lights turned off.");
        }
    }

    @Override
    public String toString() {
        return "AquariumController [manufacturer=" + manufacturer + ", model=" + model + ", currentTime=" + currentTime + ", lightsOn=" + lightsOn + "]";
    }

    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        AquariumController aquariumController = new AquariumController("AquaCorp", "AquaMaster 3000", 12.0f, 14.5f, 6.0f, 14.0f, fishFeeder);

        System.out.println(aquariumController);
        System.out.println(fishFeeder);

        aquariumController.setCurrentTime(6.0f);
        System.out.println(aquariumController);

        aquariumController.setCurrentTime(14.5f);
        System.out.println(aquariumController);
        System.out.println(fishFeeder);

        aquariumController.setCurrentTime(20.0f);
        System.out.println(aquariumController);
    }
}
