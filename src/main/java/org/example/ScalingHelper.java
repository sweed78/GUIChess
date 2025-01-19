package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ScalingHelper {

    public static void applyResizeListener(JFrame frame) {
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeComponents(frame.getContentPane(), frame.getWidth(), frame.getHeight());
            }
        });
    }

    public static void resizeComponents(Component component, int frameWidth, int frameHeight) {
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                resizeComponents(child, frameWidth, frameHeight);
            }
        }

        if (component instanceof JButton) {
            JButton button = (JButton) component;
            Dimension newSize = new Dimension(frameWidth / 4, frameHeight / 10);
            button.setPreferredSize(newSize);
            button.setFont(new Font("Arial Black", Font.PLAIN, frameWidth / 50));

        } else if (component instanceof JPanel) {
            JPanel panel = (JPanel) component;
            panel.setPreferredSize(new Dimension(frameWidth, frameHeight));
            panel.revalidate();
            panel.repaint();


        } else if (component instanceof JLabel) {
            JLabel label = (JLabel) component;
            label.setFont(new Font("Arial Black", Font.BOLD, frameWidth / 40));
        } else if (component instanceof JTextField || component instanceof JPasswordField) {
            JTextField textField = (JTextField) component;
            textField.setFont(new Font("Arial Black", Font.PLAIN, frameWidth / 50));
        }
    }

}
