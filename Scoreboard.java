import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The scoreboard class is responsible for counting and adding the
 * score that you get by collecting avoiding barrels and jumping as Mario. The maximum 
 * amount of points that you can gather is 1 Billion. The scoreboard is located
 * on the top left of the screen.
 * 
 * @author Hirad Abbasi 
 * @version Thursday, January 24, 2019
 */
public class Scoreboard extends Actor
{
    private int points;
    private Font myFont = new Font("Comic Sans MS", true, false, 18);

    public Scoreboard()
    {
        points += 0;
        GreenfootImage img = new GreenfootImage(150,30);
        img.setColor(Color.WHITE);
        img.setFont( myFont );
        img.drawString("" + points, 5,25);
        setImage(img);
    }
    
    /**
     * AddToScore will make sure to show, count and display the score on the top 
     * left of the screen. Each time you recive score, the existing score is
     *  removed from the screen and it is updated with the new score.
     * 
     * @param None There are no parameters
     * @return Nothing is returnted
     */
    public void addToScore() 
    {
        points += 100;
        GreenfootImage img = getImage();
        img.clear();
        if(points < 1000000000) 
        {
            img.drawString("" + points, 5,25); 
        }
        else 
        {
            Greenfoot.stop();
        } 
    }
}
