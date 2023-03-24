package aut.isp.lab4.exercise4;

import java.util.ArrayList;
import java.util.List;

public class Exercise4 {
    public static void main(String[] args) {
        TemperatureSensor temperatureSensor1 = new TemperatureSensor(1);
        temperatureSensor1.setTemperature(30);
        TemperatureSensor temperatureSensor2 = new TemperatureSensor(2);
        temperatureSensor2.setTemperature(40);
        FireAlarmSensor fireAlarmSensor = new FireAlarmSensor(3);
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(temperatureSensor1);
        sensors.add(temperatureSensor2);
        sensors.add(fireAlarmSensor);
        ControlUnit controlUnit = new ControlUnit(sensors);
        controlUnit.controlStep();
        temperatureSensor2.setTemperature(60);
        controlUnit.controlStep();
    }
}

// Sensor class
abstract class Sensor {
    private final int id;
    private double temperature;

    public Sensor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public abstract boolean isFireAlarm();
}

// TemperatureSensor class
class TemperatureSensor extends Sensor {
    public TemperatureSensor(int id) {
        super(id);
    }

    @Override
    public boolean isFireAlarm() {
        return getTemperature() > 50;
    }
}

// FireAlarmSensor class
class FireAlarmSensor extends Sensor {
    private boolean isFireAlarm;

    public FireAlarmSensor(int id) {
        super(id);
    }

    @Override
    public boolean isFireAlarm() {
        return isFireAlarm;
    }

    public void setFireAlarm(boolean isFireAlarm) {
        this.isFireAlarm = isFireAlarm;
    }
}

// ControlUnit class
class ControlUnit {
    private final List<Sensor> sensors;

    public ControlUnit(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void controlStep() {
        boolean isFireAlarm = true;

        for (Sensor sensor : sensors) {
            if (!(sensor instanceof FireAlarmSensor) && !sensor.isFireAlarm()) {
                isFireAlarm = false;
                break;
            }
        }

        FireAlarmSensor fireAlarmSensor = (FireAlarmSensor) sensors.get(sensors.size() - 1);
        fireAlarmSensor.setFireAlarm(isFireAlarm);

        if (isFireAlarm) {
            System.out.println("Fire alarm started");
        } else {
            System.out.println("Fire alarm not started");
        }
    }
}
