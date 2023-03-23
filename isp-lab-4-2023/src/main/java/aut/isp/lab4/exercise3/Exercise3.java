package aut.isp.lab4.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("Feeder Manufacturer", "Feeder Model", 10);
        FishFeederController fishFeederController = new FishFeederController(fishFeeder);
        AquariumController aquariumController = new AquariumController(fishFeederController, "Aquarium Manufacturer", "Aquarium Model", 10);

        System.out.println(aquariumController);
        aquariumController.setCurrentTime(5);
        aquariumController.setCurrentTime(10);
        aquariumController.setCurrentTime(15);
    }
}
