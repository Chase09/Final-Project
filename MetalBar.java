import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WalkingStand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MetalBar extends Actor
{
    private GreenfootImage MetalBars[] = new GreenfootImage[2];
    public MetalBar()
    {
        MetalBars[0] = new GreenfootImage("DonkeyKongFloor.png");
        MetalBars[1] = new GreenfootImage("DonkeyKongRamp.png");
        GreenfootImage image = getImage();
        image.scale(32, 15);
        setImage(image);
    }
    /**
     * Act - do whatever the WalkingStand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
