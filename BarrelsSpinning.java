import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BarrelsSpinning extends Actor
{
    private int rightOrLeft = 0;
    private int speed = 1;
    private int frame = 1;
    private int animateCounter = 0;
    private GreenfootImage frames[] = new GreenfootImage[3];
    
    /**
     * This constructor sets the frame of the BarrelsSpinning array to 
     * one of the existing pictures. Either BarrelSpinning1, BarrelSpinning2, 
     * or BarrelSpinning3. This helps to create the effect of rolling when 
     * the barrels are added to the world.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public BarrelsSpinning()
    {
        frames [0] = new GreenfootImage("BarrelSpinning1.png");
        frames [1] = new GreenfootImage("BarrelSpinning2.png");
        frames [2] = new GreenfootImage("BarrelSpinning3.png");
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
        if(animateCounter > 0)
        { 
            animateCounter -=1;
        }
        else if(animateCounter == 0)
        {
            animate();
            animateCounter = 8  ;
        } 
        checkFall();
    }
    /**
     * Animate - is the method that alternates frames from frame 1 to frame 3. This helps
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
        else if(frame == 3)
        {
            setImage(frames [2]);
            frame++;
        }
        else
        {
            frame = 1;
        }
    }
    
    /**
     * moveRight - is what is initilized after the barrel is spawned in.
     * It moves the barrel to the right when Donkey kong firt picks up and 
     * puts down the barrel.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void moveRight()
    {
        setLocation(getX()+speed, getY());
    }
    
    /**
     * checkFall - checks to see if the object is intersecting with the
     * metalBar class. If so, the obejct stops falling and starts to move 
     * to the right. If it is at the edge of the world, it is removed.
     * Otherwise if it is not intersecting with the metal bar, it starts
     * to fall down with the speed of 3.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void checkFall()
    {
        if(isTouching(MetalBar.class))
        {
            fall(0);
            moveRight();
            if(isAtEdge())
            {
                getWorld().removeObject(this);
            }
        }
        else
        {
           fall(3);
           rightOrLeft();
        }
    }
    
    /**
     * fall - sets the location of the BarrelsSpinning object to a (y) loation of
     * vSpeed (vertical speed) which is set to 3. This method is used whenever
     * the object has to fall.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void fall(int ySpeed)
    {
        setLocation(getX(), getY() + ySpeed);
        ySpeed++;
    }
    
    /**
     * rightOrLeft- is what happens after the BarrelsSpinning objects
     * reaches the end of the ramp. That is when it has to choose what
     * direction to start rotating at. That is when this method is initilized.
     * Everytime a BarrelsSpinning object comes in conatct with a TurnBox object it
     * changes the direction of what the Barrels were spinning towards.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void rightOrLeft()
    {
        if(isTouching(TurnBox.class))
        {
            speed = -1;
        }
        else if(isTouching(TurnBox2.class))
        {
            speed = 1;
        }
        else if(isTouching(TurnBox3.class))
        {
            speed = -1;
        }
        else if(isTouching(TurnBox4.class))
        {
            speed = 1;
        }
        else if(isTouching(TurnBox5.class))
        {
            speed = -1;
        }
        else if(isTouching(StopBox.class))
        {
            speed = -1;
        }
    }
}
