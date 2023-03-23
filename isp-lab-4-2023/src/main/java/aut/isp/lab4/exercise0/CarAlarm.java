package aut.isp.lab4.exercise0;

public class CarAlarm {

    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CarAlarm{" +
                "active=" + active +
                '}';
    }
}
