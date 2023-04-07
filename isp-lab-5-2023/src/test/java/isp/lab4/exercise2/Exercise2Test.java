package isp.lab4.exercise2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise2Test{

    @Test
    public void testLaptopCharge() {
        Laptop laptop = new Laptop();
        assertEquals(0, laptop.getBatteryLevel());

        laptop.charge(30);
        assertEquals(100, laptop.getBatteryLevel()); // 5 * 30 = 150, but max is 100
    }

    @Test
    public void testSmartPhoneCharge() {
        SmartPhone smartPhone = new SmartPhone();
        assertEquals(0, smartPhone.getBatteryLevel());

        smartPhone.charge(60);
        assertEquals(100, smartPhone.getBatteryLevel()); // 10 * 60 = 600, but max is 100
    }

    @Test
    public void testSmartWatchCharge() {
        SmartWatch smartWatch = new SmartWatch();
        assertEquals(0, smartWatch.getBatteryLevel());

        smartWatch.charge(120);
        assertEquals(100, smartWatch.getBatteryLevel()); // 2 * 120 = 240, but max is 100
    }
}