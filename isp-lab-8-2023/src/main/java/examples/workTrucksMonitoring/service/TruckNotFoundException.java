package examples.workTrucksMonitoring.service;

public class TruckNotFoundException extends Exception {
    public TruckNotFoundException(String s) {
        super(s);
    }
}
