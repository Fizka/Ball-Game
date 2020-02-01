package com.game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GamePanel extends MouseAdapter {

    private Main game;
    private ObjectContainer objectContainer;
    Random r = new Random();
    private PlayerLife playerLife;

    public GamePanel(Main game, ObjectContainer objectContainer, PlayerLife playerLife)
    {
        this.game = game;
        this.objectContainer = objectContainer;
        this.playerLife = playerLife;
    }

    public void mousePressed(MouseEvent e){

        int nx = e.getX();
        int ny = e.getY();

        if(game.gameState == Main.STATE.Menu) {

            if (mouserOver(nx, ny, 210, 150, 200, 64)) {
                game.gameState = Main.STATE.Game;
                objectContainer.addObject(new Player(Main.WIDTH / 2 - 32, Main.HEIGHT / 2 - 32, OPTIONS.Player, objectContainer));
                objectContainer.clearEnemy();
                objectContainer.addObject(new Enemy(r.nextInt(Main.WIDTH), r.nextInt(Main.HEIGHT), OPTIONS.Enemy));
            }

            if (mouserOver(nx, ny, 210, 350, 280, 64)) {
                System.exit(1);
            }

            if (mouserOver(nx, ny, 210, 250, 280, 64)) {
                game.gameState = Main.STATE.Wynik;
            }

        }

        if(game.gameState == Main.STATE.Wynik){

            if(mouserOver(nx, ny, 210,350,280,64)){
                game.gameState = Main.STATE.Menu;
            }
        }

        if(game.gameState == Main.STATE.End){
            if (mouserOver(nx, ny, 210, 150, 280, 64)) {
                game.gameState = Main.STATE.Menu;
            }

            if(mouserOver(nx, ny, 270,290,280,64)){
                playerLife.score(0);
                game.gameState = Main.STATE.Game;
            }
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouserOver(int nx, int ny, int x, int y, int width, int height)
    {
        if(nx > x && nx < x + width){
            if(ny > y && ny < y + height){
                {
                    return true;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void tick(){

    }

    public void GraphicsChange(Graphics g){
        if(game.gameState == Main.STATE.Menu) {

            Font fnt = new Font("arial", 1, 50);
            Font fnt1 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("MENU", 240, 70);

            g.setFont(fnt1);
            g.setColor(Color.white);
            g.drawRect(210, 150, 280, 64);
            g.drawString("GRAJ", 270, 190);

            g.setColor(Color.white);
            g.drawRect(210, 250, 280, 64);
            g.drawString("WYNIKI", 270, 290);

            g.setColor(Color.white);
            g.drawRect(210, 350, 280, 64);
            g.drawString("KONIEC", 270, 390);

        }else if(game.gameState == Main.STATE.Wynik){

            Font fnt = new Font("arial", 1, 50);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("WYNIKI", 240, 70);
            Font fnt1 = new Font("arial", 1, 30);
            g.setFont(fnt1);
            g.drawString("Wynik :" + playerLife.getScore(), 270, 210);
            g.setColor(Color.white);
            g.drawString("BACK", 270, 390);

        }else if(game.gameState == Main.STATE.End){

            Font fnt = new Font("arial", 1, 50);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Koniec", 240, 150);

            Font fnt1 = new Font("arial", 1, 20);
            g.setFont(fnt1);
            g.setColor(Color.white);
            g.drawString("Wynik :" + playerLife.getScore(), 270, 210);

            g.setFont(fnt);
            g.drawString("Graj", 270, 390);

        }
    }
}
