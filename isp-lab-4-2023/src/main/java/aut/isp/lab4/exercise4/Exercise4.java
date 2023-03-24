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
        House house = new House(controlUnit);
        house.controlStep();
    }
}

interface Sensor {
    int getId();
}

class TemperatureSensor implements Sensor {
    private final int id;
    private int temperature;

    public TemperatureSensor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}

class FireAlarmSensor implements Sensor {
    private final int id;
    private boolean fireAlarm;

    public FireAlarmSensor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isFireAlarm() {
        return fireAlarm;
    }

    public void setFireAlarm(boolean fireAlarm) {
        this.fireAlarm = fireAlarm;
    }
}

class ControlUnit {
    private final List<Sensor> sensors;

    public ControlUnit(List<Sensor> sensors) {
        this.sensors = sensors;
    }
    public void controlStep() {
        boolean fireAlarmStarted = false;
        for (Sensor sensor : sensors) {
            if (sensor instanceof TemperatureSensor) {
                TemperatureSensor temperatureSensor = (TemperatureSensor) sensor;
                if (temperatureSensor.getTemperature() > 50) {
                    fireAlarmStarted = true;
                    break;
                }
            }
        }
        FireAlarmSensor fireAlarmSensor = getFireAlarmSensor();
        fireAlarmSensor.setFireAlarm(fireAlarmStarted);
        if (fireAlarmStarted) {
            System.out.println("Fire alarm started");
        } else {
            System.out.println("Fire alarm not started");
        }
    }

    private FireAlarmSensor getFireAlarmSensor() {
        for (Sensor sensor : sensors) {
            if (sensor instanceof FireAlarmSensor) {
                return (FireAlarmSensor) sensor;
            }
        }
        throw new IllegalStateException("No fire alarm sensor found");
    }
}

class House {
    private final ControlUnit controlUnit;

    public House(ControlUnit controlUnit) {
        this.controlUnit = controlUnit;
    }

    public void controlStep() {
        controlUnit.controlStep();
    }
}
