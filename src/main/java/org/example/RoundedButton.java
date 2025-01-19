package org.example;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton
{

    public static void setupButtonUI(JButton button, JPanel panel) {
        button.setFont(new Font("Arial Black", Font.PLAIN, 48));
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(false);


        button.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                super.paint(g, c);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int width = c.getWidth();
                int height = c.getHeight();
                int arc = 65;

                Color backgroundColor = button.getBackground();
                g2d.setColor(backgroundColor);
                g2d.fillRoundRect(0, 0, width, height, arc, arc);

                g2d.setColor(Color.WHITE);
                g2d.setStroke(new BasicStroke(0.5f));
                g2d.drawRoundRect(1, 1, width - 2, height - 2, arc, arc);

                FontMetrics fm = g2d.getFontMetrics();
                String text = ((JButton) c).getText();
                int stringWidth = fm.stringWidth(text);
                int stringHeight = fm.getAscent() + fm.getDescent();

                int x = (width - stringWidth) / 2;
                int y = (height + stringHeight) / 2 - fm.getDescent() - (fm.getDescent()/4);

                g2d.setColor(((JButton) c).getForeground());
                g2d.drawString(text, x, y);
                g2d.dispose();
            }
        });

        button.addMouseListener(new MouseAdapter() {
            private Color originalBackground = panel.getBackground();
            private Color background = new Color(67, 69, 74);

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(48,50,52));
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(originalBackground);
                button.repaint();
            }

            public void mousePressed(MouseEvent e) {
                button.setBackground(background);
                button.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(background);
                button.repaint();
            }

        });

    }
}
