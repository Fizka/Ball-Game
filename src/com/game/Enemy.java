package com.game;

import javax.swing.*;
import java.awt.*;

public class Enemy extends BasicObject {

    private ImageIcon enemy;

    public Enemy(int x, int y, OPTIONS OPTIONS){
        super(x,y, OPTIONS);
        xMovement = 5;
        yMovement = 5;
    }

    @Override
    public void GraphicsChange(Graphics g)
    {
       // g.setColor(Color.red);
        //g.fillOval(xPoint, yPoint,16,16);
        enemy = new ImageIcon("enemy.png");
        enemy.paintIcon(this, g, xPoint, yPoint );
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPoint, yPoint,20,20);
    }

    @Override
    public void run() {

        xPoint += xMovement;
        yPoint += yMovement;

        if( yPoint <= 0 || yPoint >= Main.HEIGHT - 32)
        {
            yMovement *= -1;
        }
        if( xPoint <= 0 || xPoint >= Main.WIDTH - 32)
        {
            xMovement *= -1;
        }
    }
}
