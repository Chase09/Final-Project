import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Donkey_Kong here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Donkey_Kong extends Actor
{
    private int frame = 1;
    private int animateCounter = 0;
    private GreenfootImage frames[] = new GreenfootImage[6];
    public Donkey_Kong()
    {
        frames [0] = new GreenfootImage("DonkeyKongFrame1.png");
        frames [1] = new GreenfootImage("DonkeyKongFrame2.png");
        frames [2] = new GreenfootImage("DonkeyKongFrame3.png");
        frames [3] = new GreenfootImage("DonkeyKongFrame4.png");
        frames [4] = new GreenfootImage("DonkeyKongFrame5.png");
        frames [5] = new GreenfootImage("DonkeyKongFrame6.png");
        GreenfootImage image = getImage();
        image.scale(70, 55);
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
            if(Greenfoot.getRandomNumber(2) == 0)
            {
                animate1();
                animateCounter = 60;
            }
            else if(Greenfoot.getRandomNumber(2) == 1)
            {
                animate2();
                animateCounter = 60;
            }
            else if( Greenfoot. getRandomNumber(100) < 75)
            {
                if(Greenfoot.getRandomNumber(2) < 1)
                {
                    animate3();
                    animateCounter = 80;
                }
            } 
        }    
    }
    private void animate1()
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
        else if(frame == 4)
        {
            setImage(frames [3]);
                addBarrels();
            frame = 1;
        }
    }
    private void animate2()
    {
        if(frame == 1)
        {
            setImage(frames [0]);
            frame++ ;
        }
        else if(frame == 2)
        {
            setImage(frames [1]);
            frame++;
        }
        else if(frame == 3)
        {
            setImage(frames [0]);
            frame++;
        }
        else if(frame == 4)
        {
            setImage(frames [1]);
            frame = 1;
        }
    }
    private void animate3()
    {
        if(frame == 1)
        {
            setImage(frames [5]);
            frame = 1;
        }   
    }
    private void addBarrels()
    {
        ((PlayField) getWorld()).addBarrel();
    }
}
