package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise2.FishFeeder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AquariumControllerTest {
    @Test
    public void testCheckTemperature() {
        FishFeeder feeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        LevelSensor levelSensor = new LevelSensor("LevelCorp", "LevelMaster 2000", 0.6f);
        TemperatureSensor temperatureSensor = new TemperatureSensor("TempCorp", "TempMaster 2000", 25);
        Alarm alarm = new Alarm("AlarmCorp", "AlarmMaster 2000");
        Heater heater = new Heater("HeatCorp", "HeatMaster 2000");
        AquariumController controller = new AquariumController(feeder, "AquaCorp", "AquaMaster 3000", 12.0f, 14.5f, 24, levelSensor, temperatureSensor, alarm, heater);

        controller.checkTemperature();
        temperatureSensor.setValue(23);
        controller.checkTemperature();
        temperatureSensor.setValue(24);
        controller.checkTemperature();
    }

    @Test
    public void testCheckWaterLevel() {
        FishFeeder feeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        LevelSensor levelSensor = new LevelSensor("LevelCorp", "LevelSensor 2000", 0.6f);
        TemperatureSensor temperatureSensor = new TemperatureSensor("TempCorp", "TempMaster 2000", 25);
        Alarm alarm = new Alarm("AlarmCorp", "AlarmMaster 2000");
        Heater heater = new Heater("HeatCorp", "HeatMaster 2000");
        AquariumController controller = new AquariumController(feeder, "AquaCorp", "AquaMaster 3000", 12.0f, 14.5f, 24, levelSensor, temperatureSensor, alarm, heater);

        controller.checkWaterLevel();
        levelSensor.setValue(0.4f);
        controller.checkWaterLevel();
        levelSensor.setValue(0.6f);
        controller.checkWaterLevel();
    }
}
