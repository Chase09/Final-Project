import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PrincessHelp extends Actor
{
    private int frame = 1;
    private int animateCounter = 0;
    private GreenfootImage frames[] = new GreenfootImage[2];
    
    /**
     * This constructor sets the frame of the PrincessHelp array to 
     * one of the existing pictures. Either PrincessHelp1, or PrincessHelp2.
     * This helps to create the feeling of needing help.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public PrincessHelp()
    {
        frames [0] = new GreenfootImage("PrincessHelp1.png");
        frames [1] = new GreenfootImage("PrincessHelp2.png");
    }
    
    /**
     * Act - is responsible with the delay that the two pictures go off at.
     * When animateCounter is zero the animate method is initilized. This method 
     * is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        if(animateCounter > 0)
        { 
            animateCounter -=1;
        }
        else if(animateCounter == 0)
        {
            animate();
            animateCounter = 25;
        } 
    }    
    
    /**
     * Animate - is the method that alternates frames from frame 1 to frame 2. This helps
     * to add a animation effect to the game. When animateCounter is zero this method is initilized.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void animate()
    {
        if(frame == 1)
        {
            setImage(frames [0]);
            frame++;
        }
        else if(frame == 2)
        {
            setImage(frames [1]);
            frame++;
        }
        else
        {
            frame = 1;
        }
    }
}
