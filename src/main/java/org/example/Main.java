package org.example;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setSize(dimension.width , dimension.height);


        frame.setLayout(new BorderLayout());

        Menu menu= new Menu(frame);
        frame.add(menu, BorderLayout.CENTER);

        frame.setSize(620, 312);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        //ScalingHelper.applyResizeListener(frame);



    }
}
