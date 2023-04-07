package isp.lab4.exercise3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Exercise3Test {

    @Test
    public void testMonitoringService() {
        List<Sensor> sensors = new ArrayList<>();

        TemperatureSensor tempSensor1 = new TemperatureSensor("Living Room", "Thermostat", 70.0);
        TemperatureSensor tempSensor2 = new TemperatureSensor("Kitchen", "Stove", 450.0);
        sensors.add(tempSensor1);
        sensors.add(tempSensor2);

        PressureSensor pressureSensor1 = new PressureSensor("Garage", "Tire Pressure Gauge", 32.0);
        PressureSensor pressureSensor2 = new PressureSensor("Bathroom", "Shower Head", 40.0);
        sensors.add(pressureSensor1);
        sensors.add(pressureSensor2);

        MonitoringService monitoringService = new MonitoringService(sensors);

        double avgTemp = monitoringService.getAverageTemperatureSensors();
        double expectedAvgTemp = (tempSensor1.getValue() + tempSensor2.getValue()) / 2;
        assertEquals(expectedAvgTemp, avgTemp, 0.001);

        double avgValue = monitoringService.getAverageAllSensors();
        double expectedAvgValue = (tempSensor1.getValue() + tempSensor2.getValue() + pressureSensor1.getValue() + pressureSensor2.getValue()) / 4;
        assertEquals(expectedAvgValue, avgValue, 0.001);
    }
}