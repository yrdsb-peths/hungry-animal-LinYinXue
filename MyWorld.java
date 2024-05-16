import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score = 0;
    private boolean appleExist = false;
    private boolean enemyExist = false;
    private int appleCounter=0;
    Label scoreLabel;
    int level =1;
    private boolean gameOver = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        Elephant elephant = new Elephant ();
        addObject (elephant, 300, 300);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        
        createObject();
    }
    
    public void gameOver()
    {
        List<Enemy> enemies = getObjects(Enemy.class); 
        for (Enemy enemy : enemies) 
        {
            removeObject(enemy); 
        }
        
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    public void act()
    {
        if(!gameOver)
        {
            createObject();
        }
    }
    public void createObject()
    {
        appleCounter++;
        
        if(!appleExist && appleCounter >= 0)
        {
            createApple();
            appleExist = true;
            appleCounter=0;
        }
        if(!enemyExist)
        {
            createEnemy();
            enemyExist = true;
        }
    }
    public boolean isGameOver()
    {
        return gameOver;
    }
    
    public void setGameOver(boolean gameOver)
    {
        this.gameOver = gameOver;
    }

    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level += 1;
        }
    }
    
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x,y);
    }
    
    public void createEnemy()
    {
        Enemy enemy = new Enemy();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(enemy, x,y);
        enemy.setSpeed(3);
    }
    
    public void enemyCollision()
    {
        score -= 2;
        scoreLabel.setValue(score);
        enemyExist = false;
    }
}
