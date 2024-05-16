import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private boolean dropApple = false;
    Label scoreLabel;
    int level =1;
    
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
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    public void createObject()
    {
        if(!appleExist)
        {
            createApple();
            appleExist = true;
        }
        if(!enemyExist)
        {
            createEnemy();
            enemyExist = true;
        }
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
        enemy.setSpeed(10);
    }
    
    public void enemyCollison()
    {
        score -= 2;
        scoreLabel.setValue(score);
        enemyExist = false;
    }
    
    public void dropApple()
    {
        dropApple =true;
    }
    
    public boolean isAppleDrop()
    {
        return dropApple;
    }
}
