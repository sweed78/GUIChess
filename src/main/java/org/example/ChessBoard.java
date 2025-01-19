package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class ChessBoard extends JPanel {
    private JPanel boardPanel;
    private JPanel player1Panel, player2Panel;
    private Point initialClick;
    private JLabel draggedPieceLabel;
    private String[][] initialBoard;
    private Map<JPanel, String> boardSquares;

    public ChessBoard(JFrame frame, String player1Color) {
        setLayout(new BorderLayout());

        String player2Color = player1Color.equals("Weiß") ? "Schwarz" : "Weiß";

        player1Panel = createPlayerPanel("Spieler 1", player1Color);
        player2Panel = createPlayerPanel("Spieler 2", player2Color);

        createChessBoard();

        add(player1Panel, BorderLayout.WEST);
        add(boardPanel, BorderLayout.CENTER);
        add(player2Panel, BorderLayout.EAST);
    }

    private JPanel createPlayerPanel(String player, String color) {
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        playerPanel.setBorder(BorderFactory.createTitledBorder(player));

        JLabel playerLabel = new JLabel(player);
        JLabel playerColorLabel = new JLabel(color);

        playerPanel.add(playerLabel);
        playerPanel.add(playerColorLabel);

        return playerPanel;
    }

    private void createChessBoard() {
        boardPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        boardSquares = new HashMap<>();

        for (int row = 0; row < 8; row++) {
            gbc.gridx = 0;
            gbc.gridy = row;
            boardPanel.add(new JLabel(String.valueOf(8 - row)), gbc);
        }

        for (int column = 0; column < 8; column++) {
            gbc.gridx = column + 1;
            gbc.gridy = 8;
            boardPanel.add(new JLabel(String.valueOf((char) ('a' + column))), gbc);
        }

        initialBoard = new String[][]{
                {"R", "L", "B", "K", "Q", "B", "L", "R"},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {"r", "l", "b", "k", "q", "b", "l", "r"}
        };

        boolean isWhite = true;
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                gbc.gridx = column;
                gbc.gridy = row;
                JPanel square = new JPanel();
                square.setPreferredSize(new Dimension(50, 50));
                square.setBackground(isWhite ? Color.WHITE : Color.GRAY);

                String figure = initialBoard[row][column];
                String imagePath = getImage(figure, row < 2 ? "white" : "black");
                if (imagePath != null) {
                    ImageIcon pieceIcon = new ImageIcon(imagePath);
                    Image scaledImage = pieceIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    pieceIcon = new ImageIcon(scaledImage);
                    JLabel pieceLabel = new JLabel(pieceIcon);
                    square.add(pieceLabel);

                    boardSquares.put(square, figure);
                    addDragAndDropListeners(square, pieceLabel);
                }

                boardPanel.add(square, gbc);
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }
    }

    private void addDragAndDropListeners(JPanel square, JLabel pieceLabel) {
        pieceLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                draggedPieceLabel = pieceLabel;
            }
        });

        pieceLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX() - initialClick.x + draggedPieceLabel.getX();
                int y = e.getY() - initialClick.y + draggedPieceLabel.getY();
                draggedPieceLabel.setLocation(x, y);
            }
        });

        pieceLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Point dropLocation = e.getPoint();
                JPanel targetSquare = findTargetSquare(dropLocation);
                if (targetSquare != null) {
                    targetSquare.removeAll();
                    targetSquare.add(draggedPieceLabel);
                    targetSquare.revalidate();
                    targetSquare.repaint();
                }
            }
        });
    }

    private JPanel findTargetSquare(Point dropLocation) {
        for (Map.Entry<JPanel, String> entry : boardSquares.entrySet()) {
            JPanel square = entry.getKey();
            if (square.getBounds().contains(dropLocation)) {
                return square;
            }
        }
        return null;
    }

    private String getImage(String figure, String color) {
        if (figure.equals("R") || figure.equals("r")) {
            return "src/main/resources/" + (color.equals("white") ? "rook" : "queen") + "_" + color + ".png";
        } else if (figure.equals("K") || figure.equals("k")) {
            return "src/main/resources/" + (color.equals("white") ? "king" : "king") + "_" + color + ".png";
        } else if (figure.equals("L") || figure.equals("l")) {
            return "src/main/resources/" + (color.equals("white") ? "knight" : "knight") + "_" + color + ".png";
        } else if (figure.equals("Q") || figure.equals("q")) {
            return "src/main/resources/" + (color.equals("white") ? "queen" : "queen") + "_" + color + ".png";
        } else if (figure.equals("B") || figure.equals("b")) {
            return "src/main/resources/" + (color.equals("white") ? "bishop" : "bishop") + "_" + color + ".png";
        } else if (figure.equals("P") || figure.equals("p")) {
            return "src/main/resources/" + (color.equals("white") ? "pawn" : "pawn") + "_" + color + ".png";
        }
        return null;
    }
}
