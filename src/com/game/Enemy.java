package com.game;

import java.awt.*;

public class Enemy extends BasicObject {

    public Enemy(int x, int y, OPTIONS OPTIONS){
        super(x,y, OPTIONS);
        xMovement = 5;
        yMovement = 5;
    }

    @Override
    public void GraphicsChange(Graphics g)
    {
        g.setColor(Color.red);
        g.fillOval(xPoint, yPoint,16,16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPoint, yPoint,16,16);
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
