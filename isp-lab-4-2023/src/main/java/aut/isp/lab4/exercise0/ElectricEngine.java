package aut.isp.lab4.exercise0;

public class ElectricEngine extends Engine {
    private int batteryCapacity;

    public ElectricEngine(int power, int batteryCapacity) {
        super(power);
        this.batteryCapacity = batteryCapacity;
    }

    public void startEngine() {
        if(batteryCapacity>10) {
            super.startEngine();
            batteryCapacity--;
            System.out.println("Electric engine is started.");
        }else{
            System.out.println("Engine cannot be started. Battery to low (<=10).");
        }

    }

}
