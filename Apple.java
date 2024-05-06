import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elephant's food
 * 
 * @author Lin Yin
 * @version Apr 2024 
 */
public class Apple extends Actor
{
    private int speed = 1;
    public void act()
    {
        // Add your action code here.
        int x =getX();
        int y = getY()+2;
        setLocation(x,y);
        MyWorld world = (MyWorld) getWorld();
        if(getY()>=world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed=spd;
    }
}
