package aut.isp.lab4.exercise1;

public class Aquarium {
    private String manufacturer;
    private String model;
    private float currentTime;

    public Aquarium(String manufacturer, String model, float currentTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "AquariumController [manufacturer=" + manufacturer + ", model=" + model + ", currentTime=" + currentTime + "]";
    }

    public static void main(String[] args) {
        Aquarium aquariumController = new Aquarium("AquaCorp", "AquaMaster 3000", 12.0f);
        System.out.println(aquariumController);
        aquariumController.setCurrentTime(15.0f);
        System.out.println(aquariumController);
    }
}
