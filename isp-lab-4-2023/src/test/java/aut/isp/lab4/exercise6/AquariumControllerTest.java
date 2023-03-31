package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise2.FishFeeder;

import org.junit.Test;

public class AquariumControllerTest {
    @Test
    public void testCheckPH() {
        // Instantiate objects as in previous tests
        FishFeeder feeder = new FishFeeder("FishCorp", "FishFeeder 1000");
        LevelSensor levelSensor = new LevelSensor("LevelCorp", "LevelMaster 2000", 0.6f);
        TemperatureSensor temperatureSensor = new TemperatureSensor("TempCorp", "TempMaster 2000", 25);
        Alarm alarm = new Alarm("AlarmCorp", "AlarmMaster 2000");
        Heater heater = new Heater("HeatCorp", "HeatMaster 2000");
        PHSensor pHsensor = new PHSensor("PHCorp", "PHMaster 2000", 7.0f);
        Alarm pHAlarm = new Alarm("AlarmCorp", "AlarmMaster 3000");

        AquariumController controller = new AquariumController(feeder, "AquaCorp", "AquaMaster 3000", 12.0f, 14.5f, 24, levelSensor, temperatureSensor, alarm, heater, pHsensor, pHAlarm);

        controller.checkPH();
        pHsensor.setValue(7.4f);
        controller.checkPH();
        pHsensor.setValue(7.2f);
        controller.checkPH();
    }


}