package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Variation extends JPanel {
    private boolean isOnline = true;

    public Variation(JFrame frame) {
        frame.setTitle("Spielmodus");
        this.setBackground(new Color(44, 44, 44));
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(frame.getSize());

        JLabel variationLabel = new JLabel("Spielmodus");
        variationLabel.setFont(new Font("Arial BLACK", Font.BOLD, 78));
        variationLabel.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(variationLabel, gbc);

        JPanel statusPanel = createStatusPanel();
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 30, 0);
        this.add(statusPanel, gbc);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridBagLayout());
        optionsPanel.setOpaque(false);
        optionsPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        GridBagConstraints optionsGbc = new GridBagConstraints();
        optionsGbc.gridx = 0;
        optionsGbc.gridy = 0;
        optionsGbc.gridwidth = 2;
        optionsGbc.insets = new Insets(0, 0, 10, 0);
        optionsGbc.anchor = GridBagConstraints.WEST;

        addOption(optionsPanel, optionsGbc, "Figurenfarbe:   ", new String[]{"Weiß", "Schwarz"});
        optionsGbc.gridy++;
        addOption(optionsPanel, optionsGbc, "Startposition:   ", new String[]{"Standard", "Benutzerdefiniert"});
        optionsGbc.gridy++;
        addOption(optionsPanel, optionsGbc, "Timer:   ", new String[]{"-", "30 Sekunden"});

        gbc.gridy = 2;
        gbc.gridwidth = 2;
        this.add(optionsPanel, gbc);

        JButton playButton = new JButton("Spielen");
        RoundedButton.setupButtonUI(playButton, this);
        playButton.setFont(new Font("Arial Black", Font.PLAIN, 48));
        playButton.setForeground(Color.WHITE);
        playButton.setBackground(new Color(44, 44, 44));
        playButton.setMaximumSize(new Dimension(400, 60));
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> colorComboBox = (JComboBox<String>) optionsPanel.getComponent(0);
                String playerColor = (String) colorComboBox.getSelectedItem();
                ChessBoard chessBoard = new ChessBoard(frame, playerColor);
                frame.setContentPane(chessBoard);
                frame.revalidate();
                frame.repaint();
            }
        });
        gbc.gridy = 3;
        gbc.insets = new Insets(20, 0, 10, 0);
        this.add(playButton, gbc);

        JButton backButton = new JButton();
        ImageButton.setupImageButton(backButton, this, "Zurück zum Menü");

        try {
            ImageIcon image = new ImageIcon("src/main/resources/back.png");
            Image scaledImage = image.getImage().getScaledInstance(90, 70, Image.SCALE_SMOOTH);
            backButton.setIcon(new ImageIcon(scaledImage));
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

        gbc.gridy = 4;
        gbc.insets = new Insets(30, 0, 0, 0);
        this.add(backButton, gbc);

        frame.setContentPane(this);
        frame.setVisible(true);
    }

    private JPanel createStatusPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int width = 200;
                int height = 50;
                int arc = 25;

                Color backgroundColor = new Color(67, 69, 74);
                g2d.setColor(backgroundColor);
                g2d.fillRoundRect(0, 0, width, height, arc, arc);

                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Arial", Font.BOLD, 20));
                String text = isOnline ? "ONLINE" : "OFFLINE";
                int textWidth = g2d.getFontMetrics().stringWidth(text);
                g2d.drawString(text, (width - textWidth) / 2, height / 2 + 7);

                int circleX = isOnline ? width - 45 : 5;
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.fillOval(circleX, 5, 40, 40);
            }
        };

        panel.setPreferredSize(new Dimension(200, 50));
        panel.setOpaque(false);
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                isOnline = !isOnline;
                panel.repaint();
            }
        });

        return panel;
    }

    private void addOption(JPanel panel, GridBagConstraints gbc, String labelText, String[] options) {
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE);
        panel.add(label, gbc);

        gbc.gridx = 1;
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setPreferredSize(new Dimension(175, 20));
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.BLACK);
        panel.add(comboBox, gbc);
    }
}
