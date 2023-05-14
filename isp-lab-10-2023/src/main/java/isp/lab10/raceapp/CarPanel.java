package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;

public class CarPanel extends JPanel {
    private int[] carPositions;
    private String[] carNames;
    private Color[] carColors;

    public CarPanel() {
        carPositions = new int[4];
        carNames = new String[]{"Red car", "Blue car", "Green car", "Yellow car"};
        carColors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 4; i++) {
            int yPos = 50 + i * 50; // Vertical position of the car
            int xPos = carPositions[i]; // Horizontal position of the car
            int carSize = 30; // Size of the car

            g.setColor(carColors[i]);
            g.fillOval(xPos, yPos, carSize, carSize);
            g.setColor(Color.BLACK);
            g.drawString(carNames[i], xPos, yPos - 5);
        }
    }

    public void updateCarPosition(String carName, int distance) {
        int carIndex = getCarIndex(carName);
        if (carIndex != -1) {
            carPositions[carIndex] = distance;
            repaint();
        }
    }

    public void carFinished(String carName) {
        System.out.println("Car finished race. (" + carName + ")");
    }

    private int getCarIndex(String carName) {
        for (int i = 0; i < 4; i++) {
            if (carNames[i].equals(carName)) {
                return i;
            }
        }
        return -1;
    }
}