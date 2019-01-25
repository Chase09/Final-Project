import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TurnBox extends Actor
{
    /**
     * This is the constructor that sets the image of the TurnBox to a black box that 
     * causes the BarrelsSpinning to rotate to the other direction.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public TurnBox()
    {
        GreenfootImage image = new GreenfootImage("TurnBox.png");
        setImage(image);
    } 
}
