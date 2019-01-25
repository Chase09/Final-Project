import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HighScorePic extends Actor
{
    /**
     * This constructor sets the picture of the HighScorePic class to 
     * the original donkey kong 8 bit highscore logo. This is used to show the
     * current highScore. 
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public HighScorePic()
    {
        GreenfootImage image = getImage();
        image.scale(200, 23);
        setImage(image);
    }         
}