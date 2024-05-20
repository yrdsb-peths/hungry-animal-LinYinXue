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
    private int appleCount=0;
    Label scoreLabel;
    int level =1;
    private boolean gameOver = false;
    private int [] bestScore = {Integer.MIN_VALUE};
    private GreenfootSound bgm;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        bgm = new GreenfootSound("BGM.mp3");
        bgm.setVolume(50);
        bgm.playLoop();
        
        Elephant elephant = new Elephant ();
        addObject (elephant, 300, 300);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        
        createObject();
    }
    public void gameOver()
    {
        newBestScore();
        
        List<Enemy> enemies = getObjects(Enemy.class); 
        for (Enemy enemy : enemies) 
        {
            removeObject(enemy); 
        }
        Label bestScoresLabel = new Label("Best Score:", 30);
        addObject(bestScoresLabel, 300, 50);
    
        for(int i =0 ; i< bestScore.length; i++)
        {
           Label scoreLabel = new Label (bestScore[i],60);
           addObject(scoreLabel, 300, 100 + i*30);
           
        }
        
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        
        bgm.stop();
        
        gameOver = true;
    }
    public void newBestScore()
    {
        for(int i=0; i<bestScore.length;i++)
        {
            if(score>bestScore[i])
            {
                for(int j = bestScore.length-1;j>i;j--)
                {
                    bestScore[j] = bestScore[j-1];
                }
                bestScore[i] = score;
                break;
            }
        }
    }
   
    public void act()
    {
        if(!gameOver)
        {
            createObject();
        }
        if(Greenfoot.isKeyDown("r"))
        {
            replayGame();
        }
    }
    public void createObject()
    {
        appleCount++;
        
        if(!appleExist && appleCount >= 0)
        {
            createApple();
            appleExist = true;
            appleCount=0;
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
        score -= 1;
        scoreLabel.setValue(score);
        enemyExist = false;
    }
    public void replayGame()
    {
        removeObjects(getObjects(null));
        score =0;
        appleExist = false;
        enemyExist = false;
        appleCount = 0;
        level = 1;
        gameOver = false;
        
        Elephant elephant = new Elephant();
        addObject (elephant, 300, 300);
        scoreLabel.setValue(score);
        addObject(scoreLabel,50,50);
        createObject();
        bgm.playLoop();
    }
}
