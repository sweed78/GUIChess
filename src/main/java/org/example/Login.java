package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Login extends JPanel {
    public Login(JFrame frame) {
        frame.setTitle("Login");
        this.setBackground(new Color(44, 44, 44));
        this.setLayout(new GridBagLayout());

        this.setPreferredSize(frame.getSize());

        JPanel roundedPanel = new RoundedPanel(new Color(255, 255, 255, 50), 30);
        roundedPanel.setLayout(new BoxLayout(roundedPanel, BoxLayout.Y_AXIS));
        roundedPanel.setBorder(new EmptyBorder(40, 80, 40, 80));

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Arial BLACK", Font.BOLD, 78));
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        RoundedPanel usernamePanel = new RoundedPanel(Color.WHITE, 20);
        usernamePanel.setLayout(new BorderLayout());
        usernamePanel.setMaximumSize(new Dimension(600, 80));
        usernamePanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        JLabel usernameIcon = new JLabel("\uD83D\uDC64");
        JTextField usernameField = new JTextField();
        usernameField.setBorder(null);
        usernameField.setOpaque(false);
        usernamePanel.add(usernameIcon, BorderLayout.WEST);
        usernamePanel.add(usernameField, BorderLayout.CENTER);

        RoundedPanel passwordPanel = new RoundedPanel(Color.WHITE, 20);
        passwordPanel.setLayout(new BorderLayout());
        passwordPanel.setMaximumSize(new Dimension(600, 80));
        passwordPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        JLabel passwordIcon = new JLabel("\uD83D\uDD12");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(null);
        passwordField.setOpaque(false);
        passwordPanel.add(passwordIcon, BorderLayout.WEST);
        passwordPanel.add(passwordField, BorderLayout.CENTER);

        JButton loginButton = new JButton("Login");
        RoundedButton.setupButtonUI(loginButton, this);
        loginButton.setFont(new Font("Arial Black", Font.BOLD, 20));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(44, 44, 44));
        loginButton.setMaximumSize(new Dimension(400, 60));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel registerLabel = new JLabel("Don't have an account? Register");
        registerLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
        registerLabel.setForeground(Color.WHITE);
        registerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        roundedPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        roundedPanel.add(loginLabel);
        roundedPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        roundedPanel.add(usernamePanel);
        roundedPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        roundedPanel.add(passwordPanel);
        roundedPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        roundedPanel.add(loginButton);
        roundedPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        roundedPanel.add(registerLabel);

        this.add(roundedPanel);

        frame.setContentPane(this);
        frame.setVisible(true);
    }
}
