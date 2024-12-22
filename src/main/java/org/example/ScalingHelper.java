package org.example;

import javax.swing.*;
import java.awt.*;

public class ScalingHelper {

    private static double originalWidth = 1920.0; // Vollbildgröße für das Skalieren
    private static double originalHeight = 1080.0;

    // Setze die Originalgröße (kann angepasst werden, wenn das Fenster im Vollbildmodus startet)
    public static void setOriginalSize(double width, double height) {
        originalWidth = width;
        originalHeight = height;
    }

    // Skalierung der Schriftgrößen und Komponenten im Panel
    public static void scaleComponent(Dimension newSize, JPanel panel) {
        int frameWidth = newSize.width;
        int frameHeight = newSize.height;

        // Berechnung des Skalierungsfaktors
        double widthScale = frameWidth / originalWidth;
        double heightScale = frameHeight / originalHeight;
        double scale = Math.min(widthScale, heightScale);  // Der kleinere Skalierungsfaktor wird verwendet

        // Alle Komponenten im Panel skalieren
        for (Component component : panel.getComponents()) {
            if (component != null) {
                // Skalierung der Schriftgröße (für AbstractButton und JLabel)
                if (component instanceof AbstractButton || component instanceof JLabel) {
                    Font originalFont = component.getFont();
                    float newFontSize = (float) (originalFont.getSize() * scale);  // Schriftgröße berechnen
                    component.setFont(originalFont.deriveFont(newFontSize));  // Schriftgröße anwenden
                }

                // Skalierung der Größe für Buttons
                if (component instanceof JButton) {
                    JButton button = (JButton) component;
                    Dimension preferredSize = button.getPreferredSize();
                    button.setPreferredSize(new Dimension(
                            (int) (preferredSize.width * scale),
                            (int) (preferredSize.height * scale)
                    ));
                }

                // Skalierung für Labels
                if (component instanceof JLabel) {
                    JLabel label = (JLabel) component;
                    Dimension preferredSize = label.getPreferredSize();
                    label.setPreferredSize(new Dimension(
                            (int) (preferredSize.width * scale),
                            (int) (preferredSize.height * scale)
                    ));
                }
            }
        }

        // Panel neu validieren und repainten, um die Änderungen anzuwenden
        panel.revalidate();
        panel.repaint();
    }
}
