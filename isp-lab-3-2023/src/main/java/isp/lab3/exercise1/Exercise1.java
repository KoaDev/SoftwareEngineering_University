package isp.lab3.exercise1;

public class Exercise1 {
    private int height;

    public Exercise1() {
        height = 15;
    }

    public void grow(int meters) {
        if (meters >= 1) {
            height += meters;
        }
    }

    public String toString() {
        return "Height of tree is " + height + " meters.";
    }
}
