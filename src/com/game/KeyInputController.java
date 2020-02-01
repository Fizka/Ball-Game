package com.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputController extends KeyAdapter {

    private ObjectContainer objectContainer;

    public KeyInputController(ObjectContainer objectContainer) {
        this.objectContainer = objectContainer;
    }

    public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();

        for(int i = 0; i< objectContainer.object.size(); i++)
        {
            BasicObject tempObject = objectContainer.object.get(i);

            if(tempObject.getOPTIONS() == OPTIONS.Player){

                if(key == KeyEvent.VK_W) tempObject.setyMovement(-5);
                if(key == KeyEvent.VK_S) tempObject.setyMovement(5);
                if(key == KeyEvent.VK_D) tempObject.setxMovement(5);
                if(key == KeyEvent.VK_A) tempObject.setxMovement(-5);

            }

        }

        if(key == KeyEvent.VK_ESCAPE){
            System.exit(1);
        }

    }

    public void keyReleased(KeyEvent e){

        int key = e.getKeyCode();

        for(int i = 0; i< objectContainer.object.size(); i++)
        {
            BasicObject tempObject = objectContainer.object.get(i);

            if(tempObject.getOPTIONS() == OPTIONS.Player){

                if(key == KeyEvent.VK_W) tempObject.setyMovement(-5);
                if(key == KeyEvent.VK_S) tempObject.setyMovement(5);
                if(key == KeyEvent.VK_D) tempObject.setxMovement(5);
                if(key == KeyEvent.VK_A) tempObject.setxMovement(-5);
            }

        }
    }

}
