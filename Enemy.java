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

    public void act()
    {
        fall();
        remove();
    }
        
    private void fall()
    {
        setLocation(getX(),getY()+1);
    }
        
    private void remove()
    {
        if(getY() >= getWorld().getHeight()-1)
        {
            getWorld().removeObject(this);
        }
    }

}
