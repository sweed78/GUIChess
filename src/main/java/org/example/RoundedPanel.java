package org.example;

import javax.swing.*;
import java.awt.*;

class RoundedPanel extends JPanel {
    private final Color backgroundColor;
    private final int arc;

    public RoundedPanel(Color backgroundColor, int arc) {
        this.backgroundColor = backgroundColor;
        this.arc = arc;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
    }
}
