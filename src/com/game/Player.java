package com.game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Player extends BasicObject {

    Random r = new Random();
    ObjectContainer objectContainer;
    private ImageIcon player;

    public  Player(int x, int y, OPTIONS OPTIONS, ObjectContainer objectContainer)
    {
        super(x,y, OPTIONS);
        this.objectContainer = objectContainer;

    }


    public void collision(){
        for(int i = 0; i< objectContainer.object.size(); i++){
            BasicObject tempObject = objectContainer.object.get(i);
            if(tempObject.getOPTIONS() == OPTIONS.Enemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    PlayerLife.HEALH -=2;
                }
            }
        }
    }

    @Override
    public void GraphicsChange(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        player = new ImageIcon("gamer1.png");
        player.paintIcon(this, g, xPoint, yPoint );
        //g.setColor(Color.BLACK);
        //g.fillOval(xPoint, yPoint,32,23);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPoint, yPoint,32,32);
    }


    @Override
    public void run() {
        xPoint += xMovement;
        yPoint += yMovement;

        xPoint = Main.ControllerMovement(xPoint, 0, Main.WIDTH - 37);
        yPoint = Main.ControllerMovement(yPoint, 0, Main.HEIGHT - 68);

        collision();
    }
}
