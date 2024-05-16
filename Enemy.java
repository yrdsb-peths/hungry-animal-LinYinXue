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
    private int speed = 2;
    
    public void act()
    {
       MyWorld world = (MyWorld)getWorld();
       if(!world.isAppleDrop())
       {
           setLocation(getX(), getY() + speed);
       }
    }
        
    public void setSpeed(int spd)
    {
        speed=spd;
    }

}
