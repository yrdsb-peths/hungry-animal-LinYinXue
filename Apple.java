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
  
    public Apple()
    {
        GreenfootImage originalApple = getImage();
        
        int newHeight = 50;
        int newWidth = 50;
        originalApple.scale(newWidth, newHeight);
        
        setImage(originalApple);
    }
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
