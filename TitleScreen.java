import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  TitleScreen .
 * 
 * @author (Lin Yin) 
 * @version (May 2024)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant",70);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bgImage = new GreenfootImage("Title.png");
        bgImage.scale(getWidth(), getHeight());
        setBackground(bgImage);
        
        addObject(titleLabel, getWidth()/2, 90);
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,515,101);
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,295,283);
        elephant.setLocation(300,200);
        Label label2 = new Label("Use \u2190 and \u2192 to Move", 30);
        addObject(label2,312,327);
        label.setLocation(310,323);
        label2.setLocation(300,275);
        Label label3 = new Label("Press <r> to replay,\nbeat your best score!", 20);
        addObject(label3,376,195);
        label3.setLocation(130,220);
    }
}
