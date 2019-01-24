import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
        } 
        else if(animateDeathCounter == 0 && isTouching(Ladder.class))
        {
            if(Greenfoot.isKeyDown("up"))
            {
                vSpeed = 6;
                jumpStrenght = 0 ;
                upLadder();
                animateDeathCounter = 13;
            }
        } 
        checkKeys();   
        checkFall();       
    }
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
    private void moveRightAnimation()
    {
        if(animateCounter % 6 == 0)
        {
            animateRight();
        }
    }
    private void moveLeftAnimation()
    {
        if(animateCounter % 6 == 0)
        {
            animateLeft();
        }
    }
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
    public void moveRight()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+speed, getY());
            moveRightAnimation();
        }
    }
    private void moveLeft()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-speed, getY());
            moveLeftAnimation();
        }
    }
    public void jump()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            getImage();
            setImage(getImage());
            vSpeed = -jumpStrenght;
            fall(0);
        }
        else if(Greenfoot.isKeyDown("space")&& Greenfoot.isKeyDown("right"))
        {
            setImage("MarioJumpFrameRight.png");
            vSpeed = -jumpStrenght;
            fall(0);
        }
        else if(Greenfoot.isKeyDown("space")&& Greenfoot.isKeyDown("left"))
        {
            setImage("MarioJumpFrameLeft.png");
            vSpeed = -jumpStrenght;
            fall(0);
        }
    }
  
    public void checkFall()
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
           fall(0);
        }
    }
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
    private void downLadder()
    {
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+speed);
        }
    } 
    private void fall(int ySpeed)
    {
        setLocation(getX()+ySpeed, getY() + vSpeed);
        vSpeed+= 1;
    }
    private boolean onGround()
    {
        Actor under =  getOneIntersectingObject(MetalBar.class);
        return under != null;
    }
}    

