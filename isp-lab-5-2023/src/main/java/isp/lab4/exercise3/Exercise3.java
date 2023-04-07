package isp.lab4.exercise3;

import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {
        List<Sensor> sensors = new ArrayList<>();

        // Create some temperature sensors
        TemperatureSensor tempSensor1 = new TemperatureSensor("Living Room", "Thermostat", 70.0);
        TemperatureSensor tempSensor2 = new TemperatureSensor("Kitchen", "Stove", 450.0);
        sensors.add(tempSensor1);
        sensors.add(tempSensor2);

        // Create some pressure sensors
        PressureSensor pressureSensor1 = new PressureSensor("Garage", "Tire Pressure Gauge", 32.0);
        PressureSensor pressureSensor2 = new PressureSensor("Bathroom", "Shower Head", 40.0);
        sensors.add(pressureSensor1);
        sensors.add(pressureSensor2);

        // Create a monitoring service and add the sensors to it
        MonitoringService monitoringService = new MonitoringService(sensors);

        // Print the average temperature of temperature sensors
        double avgTemp = monitoringService.getAverageTemperatureSensors();
        System.out.println("Average temperature of temperature sensors: " + avgTemp);

        // Print the average value of all sensors
        double avgValue = monitoringService.getAverageAllSensors();
        System.out.println("Average value of all sensors: " + avgValue);
    }

}

abstract class Sensor {
    private String installLocation;
    private String name;
    private List<Sensor> sensors = new ArrayList<>();

    public Sensor(String installLocation, String name) {
        this.installLocation = installLocation;
        this.name = name;
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    public abstract double getValue();
}

class TemperatureSensor extends Sensor {
    private final double temperature;

    public TemperatureSensor(String installLocation, String name, double temperature) {
        super(installLocation, name);
        this.temperature = temperature;
    }

    @Override
    public double getValue() {
        return temperature;
    }
}

class PressureSensor extends Sensor {
    private final double pressure;

    public PressureSensor(String installLocation, String name, double pressure) {
        super(installLocation, name);
        this.pressure = pressure;
    }

    @Override
    public double getValue() {
        return pressure;
    }
}

class MonitoringService {
    private final List<Sensor> sensors;

    public MonitoringService(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public double getAverageTemperatureSensors() {
        double totalTemperature = 0;
        int count = 0;

        for (Sensor sensor : sensors) {
            if (sensor instanceof TemperatureSensor) {
                totalTemperature += sensor.getValue();
                count++;
            }
        }

        return totalTemperature / count;
    }

    public double getAverageAllSensors() {
        double totalValue = 0;
        int count = 0;

        for (Sensor sensor : sensors) {
            totalValue += sensor.getValue();
            count++;
        }

        return totalValue / count;
    }
}

