package aut.isp.lab4.exercise4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class Exercise4Test {
    @Test
    public void testControlStep() {
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

        // Test that fire alarm is not started when no sensor has temperature > 50
        controlUnit.controlStep();
        assertFalse(fireAlarmSensor.isFireAlarm());

        // Test that fire alarm is started when all sensors have temperature > 50
        temperatureSensor1.setTemperature(60);
        temperatureSensor2.setTemperature(70);
        controlUnit.controlStep();
        Assert.assertTrue(fireAlarmSensor.isFireAlarm());

        // Test that fire alarm is not started when only some sensors have temperature > 50
        temperatureSensor1.setTemperature(60);
        temperatureSensor2.setTemperature(40);
        controlUnit.controlStep();
        assertFalse(fireAlarmSensor.isFireAlarm());
    }
}