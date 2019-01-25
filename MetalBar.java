import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MetalBar extends Actor
{
    
    /**
     * This constructor sets the picture of the MetalBar class to 
     * a existing picture. This is what mario will be located on when the game
     * is first initilized and also when Mario moves around.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public MetalBar()
    {
        GreenfootImage image = new GreenfootImage("DonkeyKongFloor.png");
        image.scale(32, 15);
        setImage(image);
    } 
}
