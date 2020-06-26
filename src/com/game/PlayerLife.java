package com.game;

import java.awt.*;

public class PlayerLife implements Runnable{

    public static int HEALH = 100;
    private int greenValue = 255;

    private int score = 0;
    private int level = 0;

    public void GraphicsChange(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(500,25, 200, 16);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(500,25, HEALH*2, 16);
        g.setColor(Color.black);
        g.drawRect(500,25, 200, 16);
        g.drawString("Score " + score, 15, 60);
    }

    public void score(int score){
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void run() {
        HEALH = Main.ControllerMovement(HEALH, 0, 100);
        greenValue = Main.ControllerMovement(greenValue,0,255);
        greenValue = HEALH *2;
        level++;
    }
}
