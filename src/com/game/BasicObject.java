package com.game;

import javax.swing.*;
import java.awt.*;

public abstract class BasicObject extends JPanel implements Runnable {

    protected int xPoint, yPoint;
    protected OPTIONS OPTIONS;
    protected  int xMovement, yMovement;

    public BasicObject(int xPoint, int yPoint, OPTIONS OPTIONS) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.OPTIONS = OPTIONS;
    }

    public abstract void run();
    public abstract void GraphicsChange(Graphics g);
    public abstract Rectangle getBounds();

    public int getxPoint() {
        return xPoint;
    }

    public void setxPoint(int xPoint) {
        this.xPoint = xPoint;
    }

    public int getyPoint() {
        return yPoint;
    }

    public void setyPoint(int yPoint) {
        this.yPoint = yPoint;
    }

    public OPTIONS getOPTIONS() {
        return OPTIONS;
    }

    public void setOPTIONS(OPTIONS OPTIONS) {
        this.OPTIONS = OPTIONS;
    }

    public int getxMovement() {
        return xMovement;
    }

    public void setxMovement(int xMovement) {
        this.xMovement = xMovement;
    }

    public int getyMovement() {
        return yMovement;
    }

    public void setyMovement(int yMovement) {
        this.yMovement = yMovement;
    }
}
