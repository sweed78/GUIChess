package org.example;

import javax.swing.*;
        import javax.swing.border.EmptyBorder;
import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ELO extends JPanel {
    public ELO(JFrame frame) {
        frame.setTitle("ELO");
        this.setBackground(new Color(44, 44, 44));
        this.setLayout(new GridBagLayout());

        this.setPreferredSize(frame.getSize());
        Color panelColor= this.getBackground();
        JPanel roundedPanel = new RoundedPanel(panelColor, 30);
        roundedPanel.setLayout(new BoxLayout(roundedPanel, BoxLayout.Y_AXIS));
        roundedPanel.setBorder(new EmptyBorder(40, 80, 40, 80));

        JLabel ELOLabel = new JLabel("ELO");
        ELOLabel.setFont(new Font("Arial BLACK", Font.BOLD, 78));
        ELOLabel.setForeground(Color.WHITE);
        ELOLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel registerLabel = new JLabel(" highscore:");
        registerLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
        registerLabel.setForeground(Color.WHITE);
        registerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        roundedPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        roundedPanel.add(ELOLabel);

        roundedPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        roundedPanel.add(registerLabel);


        JButton button = new JButton();
        ImageButton.setupImageButton(button, this, "Zurück zum Menü");

        try {
            ImageIcon image = new ImageIcon("src/main/resources/back.png");
            Image scaledImage = image.getImage().getScaledInstance(90, 70, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage));
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.addComponentListener(new java.awt.event.ComponentAdapter() {
                @Override
                public void componentResized(java.awt.event.ComponentEvent e) {
                    int buttonWidth = 90;
                    int buttonHeight = 70;

                    Image scaledImage = image.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
                    button.setIcon(new ImageIcon(scaledImage));
                }
            });

            button.addActionListener(new ActionListener() {
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

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(roundedPanel, gbc);


        gbc.gridy=1;
        gbc.weighty=0;
        gbc.insets = new Insets(0, 0, 30, 0);
        gbc.anchor = GridBagConstraints.SOUTH;
        this.add(button,gbc);



        frame.setContentPane(this);
        frame.setVisible(true);
    }
}

