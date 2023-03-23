package aut.isp.lab4.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        AquariumController aquariumController = new AquariumController("Acme Corp.", "AquaMaster 2000");
        aquariumController.setCurrentTime(10.5f);
        System.out.println(aquariumController.toString());
    }

}
