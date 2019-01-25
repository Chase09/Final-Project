import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StopBox extends Actor
{
    /**
     * This is the constructor that sets the image of the StopBox to a black box that 
     * causes the BarrelsSpinningDown to stop rotate to the left of the screen when later it is removed.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public StopBox()
    {
        GreenfootImage image = new GreenfootImage("TurnBox.png");
        setImage(image);
    } 
}
