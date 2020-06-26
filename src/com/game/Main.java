package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.concurrent.*;

public class Main extends Canvas implements Runnable {

    private static final long serialVersionUID = -8478170199981923620L;

    public static final int WIDTH = 800, HEIGHT = 500;
    private ImageIcon background;
    private Thread thread;
    private boolean running = false;
    ExecutorService executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());
    private ObjectContainer objectContainer;
    private Random rand;
    private PlayerLife hudy;
    private EnemyController spawner;
    private GamePanel gamePanel;

    public enum STATE{
        Menu,
        Wynik,
        End,
        Game;
    };

    public STATE gameState = STATE.Menu;

    public Main(){

        hudy = new PlayerLife();
        objectContainer = new ObjectContainer();
        this.addKeyListener(new KeyInputController(objectContainer));
        gamePanel = new GamePanel(this, objectContainer, hudy);
        this.addMouseListener(gamePanel);

        new PanelFrame(WIDTH, HEIGHT, "Java Game", this);
        rand = new Random();
        spawner = new EnemyController(objectContainer, hudy);

    }

    public synchronized void start(){

        thread = new Thread(this);
        executor.submit(objectContainer);
        executor.submit(hudy);
        thread.start();
        running = true;

    }

    public synchronized void stop(){

        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run() {

        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running){

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){

                ThraedRunner();
                delta--;
            }
                if(running){
                    GraphicsChange();
                }
            frames++;

                if(System.currentTimeMillis() - timer > 1000 ){
                    timer+= 1000;
                    frames = 0;
                }
        }
        stop();
    }

    private void ThraedRunner(){

        executor.execute(objectContainer);
        if(gameState == STATE.Game) {

            executor.execute(hudy);
           spawner.runEnemy();
            if(PlayerLife.HEALH <= 0){
                PlayerLife.HEALH = 100;
                objectContainer.clearEnemy();
                gameState = STATE.End;
            }
        }else if(gameState == STATE.Menu || gameState == STATE.End  )
        {
            gamePanel.tick();
        }
    }

    private void GraphicsChange(){

        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if(bufferStrategy == null)
        {
            // max 3
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        background = new ImageIcon("2.jpg");
        background.paintIcon(this, graphics, 0, 0 );
      // graphics.setColor(Color.YELLOW);
     //  graphics.fillRoundRect(0,0,WIDTH, HEIGHT,10,10);
        objectContainer.GraphicsChange(graphics);

        if(gameState == STATE.Game)
        {
            hudy.GraphicsChange(graphics);

        }else if(gameState == STATE.Menu || gameState == STATE.Wynik
                || gameState == STATE.End )
        {
            gamePanel.GraphicsChange(graphics);
        }

        graphics.dispose();
        bufferStrategy.show();
        }

public static int ControllerMovement(int Point, int min, int max){
        if(Point >= max)
        {
            return Point = max;
        }else if( Point <= min)
            {
                return Point = min;
            } else
            {
                return Point;
            }
        }

public static void main(String[] args) {
        new Main(); }
        }
