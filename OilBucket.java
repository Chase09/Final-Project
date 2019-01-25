import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class OilBucket extends Actor
{
    private int frame = 1;
    private int animateCounter = 0;
    private GreenfootImage frames[] = new GreenfootImage[3];
    
    /**
     * This constructor sets the frame of the OilBucket array to 
     * one of the existing pictures. Either DonkeyKongOilBucket1, DonkeyKongOilBucket2, or
     * DonkeyKongOilBucket3. This helps to create the feeling of fire. The animation of the fire
     * also helps to give the game a oldschool feeling. 
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public OilBucket()
    {
        frames [0] = new GreenfootImage("DonkeyKongOilBucket1.png");
        frames [1] = new GreenfootImage("DonkeyKongOilBucket2.png");
        frames [2] = new GreenfootImage("DonkeyKongOilBucket3.png");
        GreenfootImage image = getImage();
        image.scale(32, 50);
        setImage(image);
    }
    
    /**
     * Act - is responsible with the delay that the three pictures go off at.
     * When animateCounter is zero the animate method is initilized. This method 
     * is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        // Add your action code here.
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
     * Animate - is the method the alternates from frame 1 to frame 2 to frame 3. This helps
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
            setImage(frames [1]);
            frame++;
        }
        else if(frame == 2)
        {
            setImage(frames [2]);
            frame++;
        }
        else
        {
            frame = 1;
        }
    }
}