package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;

public class SemaphorePanel extends JPanel {
    private Color color;

    public SemaphorePanel() {
        setPreferredSize(new Dimension(100, 300));
        color = Color.GRAY;
    }

    public void setGray() {
        color = Color.GRAY;
        repaint();
    }

    public void setYellow() {
        color = Color.YELLOW;
        repaint();
    }

    public void setGreen() {
        color = Color.GREEN;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diameter = Math.min(getWidth(), getHeight()) - 20;
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);

        g.setColor(Color.BLACK);
        g.drawOval(x, y, diameter, diameter);
    }
}
