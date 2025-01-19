package org.example;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JPanel {
    private JPanel panel;
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
        panel.setPreferredSize(frame.getSize());
        RoundedButton.setupButtonUI(playButton, panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        add(panel,gbc);

        image = new ImageIcon("src/main/resources/Credits.png");
        image1 = new ImageIcon("src/main/resources/user_manual.png");
        image2 = new ImageIcon("src/main/resources/switch_user.png");
        image3 = new ImageIcon("src/main/resources/ELO.png");

        ImageButton.setupImageButton(instructionButton, this, "Anleitung anzeigen");
        ImageButton.setupImageButton(creditsButton, this, "Credits anzeigen");
        ImageButton.setupImageButton(ELOButton, this, "ELO Rangliste");
        ImageButton.setupImageButton(switchUserButton, this, "Benutzer wechseln");

        instructionButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int buttonWidth =  100;
                int buttonHeight =  100;

                Image scaledImage = image1.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                instructionButton.setIcon(new ImageIcon(scaledImage));
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

        add(panel);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Variation v = new Variation(frame);
                frame.setContentPane(v);
                frame.revalidate();
                frame.repaint();
            }
        });
        ELOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ELO el = new ELO(frame);
                frame.setContentPane(el);
                frame.revalidate();
                frame.repaint();
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
                Instruction i = new Instruction(frame);
                frame.setContentPane(i);
                frame.revalidate();
                frame.repaint();
            }
        });




    }
}
