package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Credits extends JPanel {
    private JPanel panel;
    private JButton zurückButton;
    private JLabel title;
    private JLabel text;
    private JLabel text1;
    private ImageIcon image;

    public Credits(JFrame frame){
        frame.setTitle("Credits");
        panel.setPreferredSize(frame.getSize());
        try {
            image = new ImageIcon("src/main/resources/IconsByAndreaFryer_GameUI_Chunky_Back-512.png");

            zurückButton.addComponentListener(new java.awt.event.ComponentAdapter() {
                @Override
                public void componentResized(java.awt.event.ComponentEvent e) {
                    int buttonWidth = 90;
                    int buttonHeight = 70;

                    // Bild auf Button-Größe skalieren
                    Image scaledImage = image.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                    zurückButton.setIcon(new ImageIcon(scaledImage)); // Skalierte Version setzen
                }
            });

            zurückButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Menu menu = new Menu(frame);
                    frame.setContentPane(menu);
                    frame.revalidate();
                    frame.repaint();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Skalierung nur bei Fenstergrößenänderung
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {

                // Wenn sich die Fenstergröße geändert hat, führe die Skalierung durch
                ScalingHelper.scaleComponent(frame.getSize(), Credits.this);

            }
        });

        add(panel);

    }




}
