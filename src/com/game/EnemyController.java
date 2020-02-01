package com.game;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EnemyController {

    ExecutorService executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    Random r = new Random();
    private ObjectContainer objectContainer;
    private PlayerLife playerLife;
    private int scorekeeper = 0;

    public EnemyController(ObjectContainer objectContainer, PlayerLife playerLife)
    {
        this.objectContainer = objectContainer;
        this.playerLife = playerLife;
    }

    public void runEnemy() {
        scorekeeper++;

        if(scorekeeper >= 100)
        {
            scorekeeper = 0;
            playerLife.score(playerLife.getScore()+1);
            if(playerLife.getScore() >=  2) {
                Enemy e = new Enemy(r.nextInt(Main.WIDTH), r.nextInt(Main.HEIGHT), OPTIONS.Enemy);
                executor.submit(e);
                objectContainer.addObject(e);
                executor.execute(e);
            }
        }

    }

}
