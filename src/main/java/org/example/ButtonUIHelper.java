package org.example;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class ButtonUIHelper {

    // Diese Methode stellt das UI für den Button ein
    public static void setupButtonUI(JButton button, JPanel panel1) {
        button.setFont(new Font("Arial Black", Font.PLAIN, 48));  // Schriftart und -größe

        button.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                super.paint(g, c);  // Standard Button Darstellung beibehalten
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Hintergrundfarbe und abgerundete Ecken
                int width = c.getWidth();
                int height = c.getHeight();
                int arc = 70;  // Eckenradius

                Color backgroundColor = panel1.getBackground();  // Panel-Hintergrundfarbe
                g2d.setColor(backgroundColor);
                g2d.fillRoundRect(0, 0, width, height, arc, arc);  // Füllt den Hintergrund mit abgerundeten Ecken

                // Rand zeichnen
                g2d.setColor(Color.WHITE);  // Randfarbe
                g2d.setStroke(new BasicStroke(0.5f));  // Randbreite
                g2d.drawRoundRect(0, 0, width - 1, height - 1, arc, arc);  // Rand zeichnen

                // Text zentrieren
                FontMetrics fm = g2d.getFontMetrics();
                String text = ((JButton) c).getText();
                int stringWidth = fm.stringWidth(text);
                int stringHeight = fm.getAscent() + fm.getDescent();   // Gesamthöhe des Textes

                // Berechnen der Textposition
                int x = (width - stringWidth) / 2;  // Horizontal zentrieren
                int y = (height + stringHeight) / 2 - fm.getDescent() - (fm.getDescent()/4);  // Vertikal zentrieren

                // Text auf dem Button zeichnen
                g2d.setColor(((JButton) c).getForeground());  // Textfarbe beibehalten
                g2d.drawString(text, x, y);
                g2d.dispose();
            }
        });
    }
}
