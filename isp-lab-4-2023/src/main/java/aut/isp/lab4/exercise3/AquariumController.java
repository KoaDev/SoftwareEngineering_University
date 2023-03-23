package aut.isp.lab4.exercise3;

public class AquariumController {
    private final FishFeederController feeder;
    private final String manufacturer;
    private final String model;
    private int currentTime;
    private final int feedingTime;

    public AquariumController(FishFeederController feeder, String manufacturer, String model, int feedingTime) {
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = 0;
        this.feedingTime = feedingTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
        if (currentTime == feedingTime) {
            feeder.feed();
        }
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "feeder=" + feeder +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                '}';
    }
}
