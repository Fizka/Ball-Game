package com.game;

import java.awt.*;
import java.util.LinkedList;

public class ObjectContainer implements Runnable {

    LinkedList<BasicObject> object = new LinkedList<>();

    public void clearEnemy(){
        for(int i=0; i<object.size(); i++) {
            BasicObject tempObject = object.get(i);
            if (tempObject.getOPTIONS() == OPTIONS.Player){
                object.clear();
                addObject(new Player((int)tempObject.getxPoint() ,(int)tempObject.getyPoint(), OPTIONS.Player, this));
            }
        }
    }

    public void GraphicsChange(Graphics g){
        for(int i =0; i<object.size(); i++)
        {
            BasicObject tempObject = object.get(i);
            tempObject.GraphicsChange(g);
        }
    }

    public void addObject(BasicObject object)
    {
        this.object.add(object);
    }

    public void remove(BasicObject object)
    {
        this.object.remove(object);
    }

    @Override
    public void run() {
        for(int i =0; i<object.size(); i++)
        {
            BasicObject tempObject = object.get(i);
            tempObject.run();
        }
    }
}
