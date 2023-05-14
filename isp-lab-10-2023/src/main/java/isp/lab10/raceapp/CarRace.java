package isp.lab10.raceapp;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class CarRace {


    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Car Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();

        frame.getContentPane().add(carPanel);
        frame.pack();
        frame.setSize(500,300);
        frame.setVisible(true);



        JFrame frame2 = new JFrame("Semaphore");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SemaphorePanel semaphorePanel = new SemaphorePanel();

        frame2.getContentPane().add(semaphorePanel);
        frame2.pack();
        frame2.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();

        // Wait until the semaphore thread finishes execution
        semaphoreThread.join();


        Car car1 = new Car("Red", carPanel);
        Car car2 = new Car("Blue", carPanel);
        Car car3 = new Car("Green", carPanel);
        Car car4 = new Car("Yellow", carPanel);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
    }

}