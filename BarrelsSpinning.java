import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BarrelsSpinning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BarrelsSpinning extends Actor
{
    private int speed = 1;
    private int frame = 1;
    private int animateCounter = 0;
    private GreenfootImage frames[] = new GreenfootImage[3];
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
     * Act - do whatever the OilBucket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
        moveRight();
    }    
    
    public void animate()
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
    private void moveRight()
    {
        setLocation(getX()+speed, getY());
    }
}
