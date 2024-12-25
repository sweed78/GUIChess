package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private JPanel panel1;
    private JButton playButton;
    private JButton ELOButton;
    private JButton instructionButton;
    private JButton switchUserButton;
    private JButton creditsButton;
    private JLabel menu;
    private ImageIcon image;
    private ImageIcon image1;
    private ImageIcon image2;
    private ImageIcon image3;


    public Menu(JFrame frame) {
        frame.setTitle("Menü");
        panel1.setPreferredSize(frame.getSize());
        RoundedButton.setupButtonUI(playButton, panel1);

        image = new ImageIcon("src/main/resources/Credits.png");
        image1 = new ImageIcon("src/main/resources/user_manual.png");
        image2 = new ImageIcon("src/main/resources/switch_user.png");
        image3 = new ImageIcon("src/main/resources/ELO.png");

        instructionButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int buttonWidth =  100;
                int buttonHeight =  100;

                Image scaledImage = image1.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                instructionButton.setIcon(new ImageIcon(scaledImage)); // Skalierte Version setzen
            }
        });

        ELOButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int buttonWidth =  100;
                int buttonHeight =  100;

                Image scaledImage = image3.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                ELOButton.setIcon(new ImageIcon(scaledImage));
            }
        });

        creditsButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int buttonWidth =  100;
                int buttonHeight =  100;

                Image scaledImage = image.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                creditsButton.setIcon(new ImageIcon(scaledImage));
            }
        });

        switchUserButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int buttonWidth =  100;
                int buttonHeight =  90;

                Image scaledImage = image2.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                switchUserButton.setIcon(new ImageIcon(scaledImage));
            }
        });

        add(panel1);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ELOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        switchUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login l = new Login(frame);
                frame.setContentPane(l);
                frame.revalidate();
                frame.repaint();
            }
        });
        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Credits c = new Credits(frame);
                frame.setContentPane(c);
                frame.revalidate();
                frame.repaint();
            }
        });
        instructionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
