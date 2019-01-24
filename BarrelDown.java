import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BarrelDown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BarrelDown extends Actor
{
    private boolean keepFalling = true;
    private int rightOrLeft = 0;
    private int vSpeed = 0; 
    public BarrelDown()
    {
        GreenfootImage image = new GreenfootImage("DonkeyKongBarrel.png");
        setImage(image);
    }
    /**
     * Act - do whatever the OilBucket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        addBarrels();
        checkFall();
    }    
    private void fall()
    {
        setLocation(getX(), getY() +vSpeed);
    }
    public void checkFall()
    {
        if(isTouching(MetalBar.class))
        {
            vSpeed = 2;
            fall();
        }
        else if(isTouching(StopBox.class))
        {
            vSpeed = 0;
            keepFalling = false;
            getWorld().removeObject(this);
        }
        else if(keepFalling == true)
        { 
            fall();
        }
    }
    private void addBarrels()
    {
        if(isTouching(StopBox.class))
        {
            ((PlayField)getWorld()).addBarrelOnGround();
        }
    }
}

