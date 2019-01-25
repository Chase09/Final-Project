import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Mario extends Actor
{
    private int speed = 1;
    private int vSpeed = 0;
    private int jumpStrenght = 6 ;
    private int spaceCoolDown = 0;
    private int frame = 0;
    private int deadFrame = 1;
    private int animateCounter = 0;
    private int animateDeathCounter = 0;
    
    private GreenfootImage frames[] = new GreenfootImage[4];
    private GreenfootImage deadFrames[] = new GreenfootImage[4];
    private GreenfootImage upLadder[] = new GreenfootImage[7];
    
    /**
     * This is the constructor for Mario. This stores the arrays that
     * hold the frames for Mario's animation. This help to give this game a 
     * old school feeling.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Mario()
    {
        frames [0] = new GreenfootImage("MarioFrame1.png");
        frames [1] = new GreenfootImage("MarioFrame2.png");
        frames [2] = new GreenfootImage("MarioFrame1Left.png");
        frames [3] = new GreenfootImage("MarioFrame2Left.png");
        
        deadFrames [0] = new GreenfootImage("MarioDeadFrame1.png");
        deadFrames [1] = new GreenfootImage("MarioDeadFrame2.png");
        deadFrames [2] = new GreenfootImage("MarioDeadFrame3.png");
        deadFrames [3] = new GreenfootImage("MarioDeadFrame4.png");
        
        upLadder [0] = new GreenfootImage("UpLadderFrame1.png");
        upLadder [1] = new GreenfootImage("UpLadderFrame2.png");
        upLadder [2] = new GreenfootImage("UpLadderFrame3.png");
        upLadder [3] = new GreenfootImage("UpLadderFrame4.png");
        upLadder [4] = new GreenfootImage("UpLadderFrame5.png");
        upLadder [5] = new GreenfootImage("UpLadderFrame6.png");
        upLadder [6] = new GreenfootImage("UpLadderFrame7.png");
        GreenfootImage image = new GreenfootImage("DonkeyKongMarioStandingRight.png");
        image.scale(25, 30);
        setImage(image);
    }
    
    /**
     * Act - is responsible with the delay that the 15 pictures go off at.
     * When animateCounter is zero the animations are initialized if the requirements
     * match. This method is called whenever the 'Act' or 'Run' button gets pressed 
     * in the environment.

     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        animateCounter++;
        if(animateDeathCounter > 0)
        { 
            animateDeathCounter -=1;
        }
        else if(animateDeathCounter == 0 && isTouching(OilBucket.class))
        {
            animateDeath();
            animateDeathCounter = 25;
            Greenfoot.stop();
        } 
        else if(isTouching(Ladder.class))
        {
            if(Greenfoot.isKeyDown("up"))
            {
                vSpeed = 6;
                jumpStrenght = 0 ;
                upLadder();
                animateDeathCounter =13;
            }
        }
        if(isTouching(BarrelsSpinning.class))
        {
            Greenfoot.stop();
            Greenfoot.delay(200);
            Greenfoot.setWorld(new StartScreen());
        }
        checkKeys();   
        checkFall();       
    }
    
    /**
     * checkKeys - Checks to the see if the spaceCoolDown has been
     * finished. If that is the case you can jump again.
     *
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void checkKeys()
    {
        moveRight();
        moveLeft();
        if(spaceCoolDown > 0)
        { 
            spaceCoolDown -=1;
        }
        else if(Greenfoot.isKeyDown("space") && (spaceCoolDown == 0))
        {
            jump(); 
            spaceCoolDown = 25;
        } 
    }
    
    /**
     * moveRightAnimation - is the delay used for the running 
     * right animation.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void moveRightAnimation()
    {
        if(animateCounter % 6 == 0)
        {
            animateRight();
        }
    }
    
    /**
     * moveLeftAnimation - is the delay used for the running 
     * left animation.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void moveLeftAnimation()
    {
        if(animateCounter % 6 == 0)
        {
            animateLeft();
        }
    }
    
    /**
     * animateRight - is the set of frames used to set the animation 
     * for moving to the right side.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void animateRight()
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
        else
        {
            frame = 1;
        }
    }
    
    /**
     * animateLeft - is the set of frames used to set the animation 
     * for moving to the left side.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void animateLeft()
    {
        if(frame == 1)
        {
            setImage(frames [2]);
            frame++;
        }
        else if(frame == 2)
        {
            setImage(frames [3]);
            frame++;
        }
        else
        {
            frame = 1;
        }
    }
    
    /**
     * animateDeath - is the set of frames used to set the animation 
     * for mario's death animation. This is used when marios intersects
     * with the OilBucket object or the barrels.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void animateDeath()
    {
        speed = 0;
        vSpeed = 0;    
        if(deadFrame == 1)
        {
            setImage(deadFrames [0]);
            deadFrame++;
        }
        else if(deadFrame == 2)
        {
            setImage(deadFrames [1]);
            deadFrame++;
        }
        else if(deadFrame == 3)
        {
            setImage(deadFrames [2]);
            deadFrame++;
        }
        else if(deadFrame == 4)
        {
            setImage(deadFrames[3]);
            deadFrame++;
        }
        else if(deadFrame == 5)
        {
            setImage(deadFrames [0]);
            deadFrame++;
        }
        else if(deadFrame == 6)
        {
            setImage(deadFrames [1]);
            deadFrame++;
        }
        else if(deadFrame == 7)
        {
            setImage(deadFrames [2]);
            deadFrame++;
        }
        else if(deadFrame == 8)
        {
            setImage(deadFrames[3]);
            deadFrame++;
        }
        else if(deadFrame == 9)
        {
            setImage(deadFrames[0]);
            deadFrame++;
        }
        else 
        {
            setImage(deadFrames[1]);  
            speed = 1;
        }
    }
    
    /**
     * moveRight - sets the location of mario to the x of + speed.
     * The Speed is set to 1 which is pretty good for how fast 
     * other things around mario move. 
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void moveRight()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+speed, getY());
            moveRightAnimation();
        }
    }
    
    /**
     * moveLeft - sets the location of mario to the x of - speed.
     * The Speed is set to 1 which is pretty good for how fast 
     * other things around mario move. 
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void moveLeft()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-speed, getY());
            moveLeftAnimation();
        }
    }
    
    /**
     * jump - is the method that mario uses to jump when is space
     * bar is pressed. There are three types of jumps.Rightjump,leftjump and
     * just jump.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void jump()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            getImage();
            setImage(getImage());
            vSpeed = -jumpStrenght;
            fall(0);
            ((PlayField)getWorld()).update();
        }
        else if(Greenfoot.isKeyDown("space")&& Greenfoot.isKeyDown("right"))
        {
            setImage("MarioJumpFrameRight.png");
            vSpeed = -jumpStrenght;
            fall(0);
            ((PlayField)getWorld()).update();
        }
        else if(Greenfoot.isKeyDown("space")&& Greenfoot.isKeyDown("left"))
        {
            setImage("MarioJumpFrameLeft.png");
            vSpeed = -jumpStrenght;
            fall(0);
            ((PlayField)getWorld()).update();
        }
    }
    
    /**
     * checkFall - checks to see if the object is intersecting with the
     * metalBar class. If so, the obejct stops falling and starts to move 
     * to the rightside or leftside. Otherwise if it is not intersecting
     * with the metal bar, it starts to fall down with the speed of 3.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void checkFall()
    {
        if(onGround())
        {
            vSpeed = 0;
            jumpStrenght = 7;  
            moveRight();
            moveLeft(); 
        }
        else if(!isTouching(Ladder.class))
        {
            fall(1);
        }
    }
    
    /**
     * upLadder - is what method is used when mario is intersecting 
     * with the ladder object and if the player has pressed the
     * up key on the keyboard. The up the ladder animation is also initilized 
     * when the upLadder method is initilized.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void upLadder()
    { 
        setLocation(getX(), getY()-vSpeed);
        if(frame == 1)
        {
            setImage(upLadder [0]);
            frame++;
        }
        else if(frame == 2)
        {
            setImage(upLadder [1]);
            frame++;
        }
        else if(frame == 3)
        {
            setImage(upLadder [2]);
            frame++;
        }
        else if(frame == 4)
        {
            setImage(upLadder [1]);
            frame++;
        }
        else if(frame == 5)
        {
            setImage(upLadder [2]);
            frame++;
        }
        else if(frame == 6)
        {
            setImage(upLadder [3]);
            frame++;
        }
        else if(frame == 7)
        {
            setImage(upLadder [6]);
            vSpeed = -jumpStrenght;
            fall(0);
            frame++;
        }
        else
        {
            frame = 1;
        }
    }
    
    /**
     * fall - sets the location of Mario to a (y) loation of vSpeed (vertical speed)
     * which is set to 2. This method is used whenever the object has to fall.
     * 
     * @param Speed could be used to set the spped of the x speed of mario
     * @return Nothing is returned
     */
    private void fall(int Speed)
    {
        setLocation(getX(), getY() + vSpeed);
        vSpeed += 1;
    }
    
    /**
     * onGround- checks to see if the mario characher is standing 
     * on a metalBar object. If so, it returns a boolean which accesses
     * the checkFall method and makes sure to not make Mario falls
     * if he is standing on a MatalBar object.
     * 
     * @param There are no parameters
     * @return Boolean is returned either null or !null
     */
    private boolean onGround()
    {
        Actor under =  getOneIntersectingObject(MetalBar.class);
        return under != null;
    }
}    

