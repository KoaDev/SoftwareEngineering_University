package isp.lab10.raceapp;

class SemaphoreThread extends Thread {
    private final SemaphorePanel semaphorePanel;

    public SemaphoreThread(SemaphorePanel semaphorePanel) {
        this.semaphorePanel = semaphorePanel;
    }

    public void run() {
        try {
            semaphorePanel.setGray();
            Thread.sleep((int) (Math.random() * 5000) + 2000);

            semaphorePanel.setYellow();
            Thread.sleep((int) (Math.random() * 5000) + 2000);

            semaphorePanel.setGreen();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}