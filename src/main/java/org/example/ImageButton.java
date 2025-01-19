package org.example;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageButton extends BasicButtonUI {
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arcWidth = 30;
        int arcHeight = 30;

        g2d.setColor(c.getBackground());
        g2d.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), arcWidth, arcHeight);

        super.paint(g2d, c);
        g2d.dispose();
        }
     public static void setupImageButton(JButton button, JPanel panel, String tooltipText){
         button.setContentAreaFilled(false);
         button.setBorderPainted(false);
         button.setFocusPainted(false);
         button.setOpaque(false);
         button.setUI(new ImageButton());
         Color defaultColor = new Color(44, 44, 44);
         button.setBackground(defaultColor);

         button.setToolTipText(tooltipText);

         button.addMouseListener(new MouseAdapter() {
             private final Color hoverColor = new Color(67 , 69, 74);
             private final Color pressColor = new Color(200, 200, 200);
             @Override
             public void mouseExited(MouseEvent e) {
                 button.setBackground(defaultColor);
                 button.repaint();
             }

             @Override
             public void mouseEntered(MouseEvent e) {
                 button.setBackground(hoverColor);
                 button.repaint();
             }

             @Override
             public void mousePressed(MouseEvent e) {
                 button.setBackground(pressColor);
                 button.repaint();
             }

             @Override
             public void mouseReleased(MouseEvent e) {
                 button.setBackground(hoverColor);
                 button.repaint();
             }
         });
    }

    }

