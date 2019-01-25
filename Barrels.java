import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barrels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrels extends Actor
{
    /**
     * This constructor sets the picture of the Barrels class to a existing picture. 
     * This is what Donkey Kong uses to add the barrelss to the world. The Barrels are
     * located on the top left of the screen when the games is first initilized.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
     public Barrels()
    {
        GreenfootImage image = getImage();
        image.scale(45, 53);
        setImage(image);
    } 
}
