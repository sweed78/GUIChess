package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Credits extends JPanel {
    private JPanel panel;
    private JButton backButton;
    private JLabel title;
    private JLabel text;
    private JLabel text1;
    private ImageIcon image;

    public Credits(JFrame frame){
        frame.setTitle("Credits");
        panel.setPreferredSize(frame.getSize());
        ImageButton.setupImageButton(backButton, this, "Zurück zum Menü");

        try {
            image = new ImageIcon("src/main/resources/back.png");

            backButton.addComponentListener(new java.awt.event.ComponentAdapter() {
                @Override
                public void componentResized(java.awt.event.ComponentEvent e) {
                    int buttonWidth = 90;
                    int buttonHeight = 70;

                    Image scaledImage = image.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                    backButton.setIcon(new ImageIcon(scaledImage));
                }
            });

            backButton.addActionListener(new ActionListener() {
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

        add(panel);

    }




}
