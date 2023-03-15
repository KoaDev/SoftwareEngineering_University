package isp.lab3.exercise2;

// no test class for this exercise
public class Exercise2 {
    private int length;
    private int width;
    private String color;

    public Exercise2() {
        length = 2;
        width = 1;
        color = "red";
    }

    public Exercise2(int length, int width) {
        this.length = length;
        this.width = width;
        color = "red";
    }

    public Exercise2(int length, int width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }

    public int getArea() {
        return length * width;
    }
}
