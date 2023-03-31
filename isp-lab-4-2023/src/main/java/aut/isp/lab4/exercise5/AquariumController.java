package aut.isp.lab4.exercise5;


import aut.isp.lab4.exercise2.FishFeeder;

public class AquariumController {
    private FishFeeder feeder;
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private int temperature;
    private LevelSensor levelSensor;
    private TemperatureSensor temperatureSensor;
    private Alarm alarm;
    private Heater heater;

    public AquariumController(FishFeeder feeder, String manufacturer, String model, float currentTime, float feedingTime, int temperature, LevelSensor levelSensor, TemperatureSensor temperatureSensor, Alarm alarm, Heater heater) {
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.temperature = temperature;
        this.levelSensor = levelSensor;
        this.temperatureSensor = temperatureSensor;
        this.alarm = alarm;
        this.heater = heater;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (currentTime == feedingTime) {
            feeder.feed();
        }
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    public void checkTemperature() {
        int currentTemperature = temperatureSensor.getValue();
        if (currentTemperature < temperature) {
            heater.turnOn();
        } else {
            heater.turnOff();
        }
    }

    public void checkWaterLevel() {
        float currentValue = levelSensor.getValue();
        if (currentValue < 0.5f) {
            alarm.turnOn();
        } else {
            alarm.turnOff();
        }
    }

    @Override
    public String toString() {
        return "AquariumController [manufacturer=" + manufacturer + ", model=" + model + ", currentTime=" + currentTime + "]";
    }

    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        LevelSensor levelSensor = new LevelSensor("LevelCorp", "LevelMaster 2000", 0.6f);
        TemperatureSensor temperatureSensor = new TemperatureSensor("TempCorp", "TempMaster 2000", 25);
        Alarm alarm = new Alarm("AlarmCorp", "AlarmMaster 2000");
        Heater heater = new Heater("HeatCorp", "HeatMaster 2000");
        AquariumController controller = new AquariumController(feeder, "AquaCorp", "AquaMaster 3000", 12.0f, 14.5f, 24, levelSensor, temperatureSensor, alarm, heater);

        controller.setCurrentTime(14.5f);
        controller.checkTemperature();
        controller.checkWaterLevel();

        levelSensor.setValue(0.4f);
        controller.checkWaterLevel();
    }
}



abstract class Sensor {
    protected String manufacturer;
    protected String model;

    public Sensor(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Sensor [manufacturer=" + manufacturer + ", model=" + model + "]";
    }
}

abstract class Actuator {
    protected String manufacturer;
    protected String model;

    public Actuator(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public abstract void turnOn();

    public abstract void turnOff();

    @Override
    public String toString() {
        return "Actuator [manufacturer=" + manufacturer + ", model=" + model + "]";
    }
}

class LevelSensor extends Sensor {
    private float value;

    public LevelSensor(String manufacturer, String model, float value) {
        super(manufacturer, model);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}

class TemperatureSensor extends Sensor {
    private int value;

    public TemperatureSensor(String manufacturer, String model, int value) {
        super(manufacturer, model);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Alarm extends Actuator {
    public Alarm(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public void turnOn() {
        System.out.println("Alarm turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Alarm turned off.");
    }
}

class Heater extends Actuator {
    public Heater(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public void turnOn() {
        System.out.println("Heater turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Heater turned off.");
    }
}