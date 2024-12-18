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


    public Menu(JFrame jFrame) {
        panel1.setPreferredSize(new Dimension(jFrame.getWidth(), jFrame.getHeight()));
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
                Credits c = new Credits(jFrame);
                jFrame.setContentPane(c);
                jFrame.revalidate();
                jFrame.repaint();
            }
        });
        anleitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        }
}
