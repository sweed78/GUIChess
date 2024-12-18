package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Credits extends JPanel {
    private JPanel panel;
    private JButton zurückButton;
    private JLabel title;
    private JLabel text;
    private Image backgroundImage;

    public Credits(JFrame jFrame){
        //backgroundImage = new ImageIcon("src/main/resources/WhatsApp Image 2024-12-15 at 03.06.14.jpeg").getImage();
        //backgroundImage = new ImageIcon("src/main/resources/WhatsApp Image 2024-12-16 at 03.35.04.jpeg").getImage();
        //backgroundImage = new ImageIcon("src/main/resources/WhatsApp Image 2024-12-16 at 03.43.01.jpeg").getImage();
        backgroundImage = new ImageIcon("src/main/resources/WhatsApp Image 2024-12-16 at 03.43.01 (1).jpeg").getImage();

        add(panel);
        zurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu(jFrame);
                jFrame.setContentPane(menu);
                jFrame.revalidate();
                jFrame.repaint();
            }
        });
        /**zurückButton.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                adjustSizes(jFrame.getWidth(), jFrame.getHeight());
            }
        });**/
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Bild zeichnen
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    /**private void adjustSizes(int width, int height) {
        int fontSize = Math.max(10, width / 30);
        Font font = new Font("Arial", Font.PLAIN, fontSize);

        zurückButton.setFont(font);
        title.setFont(font);
        Text.setFont(font);


        int buttonHeight = Math.max(30, height / 15);
        for (Component component : panel2.getComponents()) {
            component.setPreferredSize(new Dimension(width, buttonHeight));
        }
        panel2.revalidate();
        panel2.repaint();
    }**/


}
