package aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeederController fishFeeder = new FishFeederController("Acme Corp.", "FeederMax 3000");
        fishFeeder.fillUp();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        fishFeeder.feed();
        System.out.println(fishFeeder.toString());
    }

}
