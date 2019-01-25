import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen. This is what the
     * player sees when the game is first initilized. By pressing the
     * enter key you can switch worlds to playField which is
     * where all the objects and characters are stored and added to the world.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public StartScreen()
    {    
        super(450, 600, 1);
    }
    
    /**
     * Act - is responsible with making sure to change the world if the
     * enter key has been pressed.If so, the world is switched to playField.
     * This method is called whenever the 'Act' or 'Run' button gets pressed 
     * in the environment.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new PlayField());
        }
    }
}
