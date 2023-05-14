package isp.lab10.raceapp;

import java.util.HashMap;
import java.util.Map;

class Car extends Thread {
    private final String name;
    private int distance = 0;
    private final CarPanel carPanel;
    private static int finishedCars = 0;
    private static final Map<String, Long> raceTimes = new HashMap<>();


    public Car(String name, CarPanel carPanel) {
        //set thread name;
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
    }

    public void run() {
        // create new instances of PlaySound and TimerThread for each Car
        final PlaySound playSound = new PlaySound();
        final TimerThread timerThread = new TimerThread();

        //call sound play method.
        playSound.playSound();
        timerThread.start();

        while (distance < 400) {
            // simulate the car moving at a random speed
            int speed = (int) (Math.random() * 10) + 1;
            distance += speed;

            carPanel.updateCarPosition(name, distance);

            try {
                // pause for a moment to simulate the passage of time
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        playSound.stopSound();
        timerThread.stopTimer();

        carPanel.carFinished(name);

        finishedCars++;
        long finishTime = timerThread.getTimer();
        raceTimes.put("DurationOfCourse", finishTime);

        if (finishedCars == 1) {
            System.out.println("The winner is: " + name);
            raceTimes.put(name, finishTime);
        }

        if (finishedCars == 2) {
            System.out.println("The second place is: " + name);
            raceTimes.put(name, finishTime);
        }

        if (finishedCars == 3) {
            System.out.println("The third place is: " + name);
            raceTimes.put(name, finishTime);
        }

        if (finishedCars == 4) {
            System.out.println("The fourth place is: " + name);


            System.out.println("Race times (in milliseconds): " + raceTimes);
            System.out.println("Total race time: " + timerThread.getTimer() + " milliseconds");
            raceTimes.put(name, finishTime);
            playSound.stopSound();
            timerThread.stopTimer();
        }
    }
}