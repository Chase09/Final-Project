import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Donkey_Kong extends Actor
{
    private int frame = 1;
    private int animateCounter = 0;
    private GreenfootImage frames[] = new GreenfootImage[6];
    
    /**
     * This constructor sets the frame of the Donkey_Kong array to 
     * one of the existing pictures. Either DonkeyKongFrame1, DonkeyKongFrame2, etc...
     * This helps to create the feeling of Donkey_Kong having a mind of his own.
     *  That is because his movemnet is randomized into three different possible animations.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
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
     * Act - is responsible with the delay that the six pictures go off at.
     * When animateCounter is zero the animations are initialized if the randomized 
     * number generator is matching with the requirements. This method is called 
     * whenever the 'Act' or 'Run' button gets pressed in the environment.

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
            if(Greenfoot.getRandomNumber(2) == 0)
            {
                animate1();
                animateCounter = 35;
            }
            else if(Greenfoot.getRandomNumber(2) == 1)
            {
                animate2();
                animateCounter = 35 ;
            }
            else if( Greenfoot. getRandomNumber(100) < 50)
            {
                animate3();
                animateCounter = 60;
            } 
        }    
    }
    
    /**
     * Animate - is the method that alternates frames from 1 to 4. This helpsto add a animation
     * effect to the game. When animateCounter is zero this method is initilized.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
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
    
    /**
     * Animate - is the method that alternates frames from 1 to 4. This helpsto add a animation
     * effect to the game. When animateCounter is zero this method is initilized.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
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
    /**
     * Animate - is the method that alternates frames from 1 to 1. This helpsto add a animation
     * effect to the rest of the game. When animateCounter is zero this method is initilized.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void animate3()
    {
        if(frame == 1)
        {
            setImage(frames [5]);
            addBarrelDown();
            frame = 1;
        }   
    }
    
    /**
     * addBarrels - adds the BarrelsSpinning object to the world at the location
     * of Donkey Kong. This method is initilized whenever the frame is on 3. This 
     * helps to give the game a well timed placement of objects.
     * 
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void addBarrels()
    {
        ((PlayField) getWorld()).addBarrel();
    }
    
    /**
     * addBarrelDown- adds the BarrelDown object to the world and slowy drops the object until 
     * the object is at ground level. This is what is used to create DonkeyKong's iconic move
     * the "barrel drop." This move has the chance of hitting mario while he his at the respectced x location.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void addBarrelDown()
    {
        ((PlayField) getWorld()).addBarrelsDown();
    }
}
