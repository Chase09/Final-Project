import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DonkeyKongPrincess extends Actor
{
    private int frame = 1;
    private int animateCounter = 0;
    private GreenfootImage frames[] = new GreenfootImage[2];
    
    /**
     * This constructor sets the frame of the DonkeyKongPrincess array to 
     * one of the existing pictures. Either PrincessFrame1, or PrincessFrame2.
     * This helps to create the feeling of movement and animation when the Princess
     * is initilized and added to the world.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public DonkeyKongPrincess()
    {
        frames [0] = new GreenfootImage("PrincessFrame1.png");
        frames [1] = new GreenfootImage("PrincessFrame2.png");
        GreenfootImage image = getImage();
        setImage(image);
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
     * Animate - is the method the alternates from frame 1 to frame 2. This helps
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
