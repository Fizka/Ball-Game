package com.game;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;


public class PanelFrame extends Canvas {

    private static final long serialVersionUID = 6228250119386383305L;

    public PanelFrame(int width, int height, String title, Main game){

        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();


    }

}
