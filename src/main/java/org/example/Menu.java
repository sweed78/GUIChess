package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private JPanel panel1;
    private JButton spielenButton;
    private JButton ELOZahlButton;
    private JButton anleitungButton;
    private JButton nutzerWechselnButton;
    private JButton creditsButton;
    private JLabel menu;
    private ImageIcon image;
    private ImageIcon image1;
    private ImageIcon image2;
    private ImageIcon image3;


    public Menu(JFrame frame) {
        frame.setTitle("Menü");
        panel1.setPreferredSize(frame.getSize());
        ButtonUIHelper.setupButtonUI(spielenButton, panel1);

        image = new ImageIcon("src/main/resources/Credits.png");
        image1 = new ImageIcon("src/main/resources/icons8-user-manual-100.png");
        image2 = new ImageIcon("src/main/resources/user_switch-512.png");
        image3 = new ImageIcon("src/main/resources/ELO.png");

        anleitungButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int buttonWidth =  100; //creditsButton.getWidth();
                int buttonHeight =  100; //creditsButton.getHeight();

                // Bild auf Button-Größe skalieren
                Image scaledImage = image1.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                anleitungButton.setIcon(new ImageIcon(scaledImage)); // Skalierte Version setzen
            }
        });

        ELOZahlButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int buttonWidth =  100; //creditsButton.getWidth();
                int buttonHeight =  100; //creditsButton.getHeight();

                // Bild auf Button-Größe skalieren
                Image scaledImage = image3.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                ELOZahlButton.setIcon(new ImageIcon(scaledImage)); // Skalierte Version setzen
            }
        });

        creditsButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int buttonWidth =  100; //creditsButton.getWidth();
                int buttonHeight =  100; //creditsButton.getHeight();

                // Bild auf Button-Größe skalieren
                Image scaledImage = image.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                creditsButton.setIcon(new ImageIcon(scaledImage)); // Skalierte Version setzen
            }
        });

        nutzerWechselnButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int buttonWidth =  100; //creditsButton.getWidth();
                int buttonHeight =  90; //creditsButton.getHeight();

                // Bild auf Button-Größe skalieren
                Image scaledImage = image2.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                nutzerWechselnButton.setIcon(new ImageIcon(scaledImage)); // Skalierte Version setzen
            }
        });

        add(panel1);

        spielenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ELOZahlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        nutzerWechselnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        anleitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
