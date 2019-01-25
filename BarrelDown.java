import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BarrelDown extends Actor
{
    private boolean keepFalling = true;
    private int rightOrLeft = 0;
    private int vSpeed = 0; 
    
    /**
     * This constructor sets the picture of the BarrelDown class to a existing picture.
     * This is what donkey kong spawns after doing his iconic move"the drop." The barrel
     * than moves down to ground level and is later removed from the game.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public BarrelDown()
    {
        GreenfootImage image = new GreenfootImage("DonkeyKongBarrel.png");
        setImage(image);
    }
    
    /**
     * Act - is responsible with adding the barrel that moves down after Donkey Kong
     * has chose to initilized it and to check to see if the barrel is falling.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        addBarrels();
        checkFall();
    }
    
    /**
     * fall - sets the location of the BarrelDown object to a (y) loation of
     * vSpeed (vertical speed) which is set to 2. This method is used whenever
     * the object has to fall.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void fall()
    {
        setLocation(getX(), getY() +vSpeed);
    }
    
    /**
     * checkFall - checks to see if the object is intersecting with the
     * metalBar class. If so, the obejct starts to move down using the
     * fall method. There is a StopBox object placed on floor ground
     * that when the BarrelDown object comes in conatact with it removes it.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
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
    
    /**
     * addBarrels - adds the BarrelsSpinning object when the BarrelDown
     * object comes in contact with the invisible StopBox object.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void addBarrels()
    {
        if(isTouching(StopBox.class))
        {
            ((PlayField)getWorld()).addBarrelOnGround();
        }
    }
}

