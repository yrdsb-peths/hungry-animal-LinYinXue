import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Enemy that will decrease the score.
 * 
 * @author (Lin Yin) 
 * @version (May 2024)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    
    public Enemy()
    {
        GreenfootImage originalEnemy = getImage();
        
        int newHeight = 50;
        int newWidth = 145;
        originalEnemy.scale(newWidth, newHeight);
        
        setImage(originalEnemy);
    }
    public void act()
    {
       MyWorld world = (MyWorld) getWorld();
        if(!world.isGameOver())
        {
            setLocation(getX(), getY()+ speed);
        }
        if(getY()>=getWorld().getHeight()-1)
        {
            setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()),0);
        }
    }

    public void setSpeed(int spd)
    {
        speed=spd;
    }

}
