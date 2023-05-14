package isp.lab10.raceapp;

public class TimerThread extends Thread {
    private volatile boolean running = true;
    private long timer = 0;

    public void run() {
        while (running) {
            timer++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopTimer() {
        running = false;
    }

    public long getTimer() {
        return timer * 10; // Return time in milliseconds
    }
}