package aut.isp.lab4.exercise5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Exercise5Test {

    @Test
    public void testControlStepFireAlarmNotStarted() {
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
        assertFalse(fireAlarmSensor.isFireAlarm());
    }

    @Test
    public void testControlStepFireAlarmStarted() {
        TemperatureSensor temperatureSensor1 = new TemperatureSensor(1);
        temperatureSensor1.setTemperature(30);
        TemperatureSensor temperatureSensor2 = new TemperatureSensor(2);
        temperatureSensor2.setTemperature(60);
        FireAlarmSensor fireAlarmSensor = new FireAlarmSensor(3);
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(temperatureSensor1);
        sensors.add(temperatureSensor2);
        sensors.add(fireAlarmSensor);
        ControlUnit controlUnit = new ControlUnit(sensors);
        House house = new House(controlUnit);
        house.controlStep();
        assertTrue(fireAlarmSensor.isFireAlarm());
    }

    @Test(expected = IllegalStateException.class)
    public void testControlStepNoFireAlarmSensor() {
        TemperatureSensor temperatureSensor1 = new TemperatureSensor(1);
        temperatureSensor1.setTemperature(30);
        TemperatureSensor temperatureSensor2 = new TemperatureSensor(2);
        temperatureSensor2.setTemperature(60);
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(temperatureSensor1);
        sensors.add(temperatureSensor2);
        ControlUnit controlUnit = new ControlUnit(sensors);
        House house = new House(controlUnit);
        house.controlStep();
    }
}