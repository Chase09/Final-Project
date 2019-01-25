    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import javax.swing.JOptionPane;
    import java.io.*;
    
    /**
     * Name: Hirad Abbasi
     * Class: Software Development 10S
     * Teacher: Mr.Hardman
     * Last date modified: Thursday, January 24, 2019
     */
    
    /**
     * Quick note
     * While finilizing my game I noticed multiple glitches that I could not fix in the time
     * of uploading and handing in this project. Things such as the jump height of what mario uses to 
     * determine it's jump height and Mario's head getting glitched whenever he comes in contact with 
     * the MetalBar object.
     */
    
    
    public class PlayField extends World
    {
        private Ladder[] ladders = new Ladder[]{ new Ladder(0), new Ladder(1),
        new Ladder(2),new Ladder(3),new Ladder(4),new Ladder(5),new Ladder(6),new Ladder(7),
        new Ladder(8),new Ladder(9),new Ladder(10),new Ladder(11),new Ladder(12),
        new Ladder(13),new Ladder(14),new Ladder(15),new Ladder(16),new Ladder(17),new Ladder(18)};
        
        private int[] ladderXs = new int[]{ 146,262,373,200,200,54,138,330,330,374,246,120,120,74,202,374,170,170,169};
        private int[] ladderYs = new int[]{ 150,177,240,218,262,320,321,289,350,399,399,367,427,476,476,552,525,575,150};
    
        private int animateCounter = 0;     
        private boolean startGame = true;
        private boolean nameSelected = true;
        private Mario player = null;
        private Donkey_Kong dk = null;
        private Barrels barrel = null;
        private DonkeyKongPrincess princess = null;
        private HighScorePic highScore = null;
        private PrincessHelp helpSign = null;
        private OilBucket bucket = null;
        private long score = 50000;
        private long highScoreNum ;
        private String playerName ;
        private Scoreboard scores;
        int p ;
        int x = 17;
        int y = 20;
        
    /**
     * This constructor of the PlayField world. This is where all information 
     * about what location an object should be located at when the game is initilized.
     * The world size is set to 450 width and 600 height and the paint order is set to Mario 
     * being the first priority being followed by Donkey Kong.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public PlayField()
    {        
        super(450, 600, 1);
        
        //Sets the paint order
        setPaintOrder(Mario.class, Donkey_Kong.class);
        
        //Initilizes the initializePlayingField method
        initializePlayingField(); 
        
        scores = new Scoreboard();
        addObject(scores, 76, 10);
        
        player = new Mario();
        addObject(player, 90, 570);
        
        dk = new Donkey_Kong();
        addObject(dk ,100, 170);
        
        barrel = new Barrels();
        addObject(barrel ,37, 169);
        
        princess = new DonkeyKongPrincess();
        addObject(princess ,209, 119);
        
        helpSign = new PrincessHelp();
        addObject(helpSign, 276, 102);
        
        highScore = new HighScorePic();
        addObject(highScore, 225, 15);

        bucket = new OilBucket();
        addObject(bucket, 40, 561);
        //The Ground Mario is standing on when first intilized
        addObject(new MetalBar(), 17, 592);
        addObject(new MetalBar(), 49, 592);
        addObject(new MetalBar(), 81, 592);
        addObject(new MetalBar(), 113, 592);
        addObject(new MetalBar(), 145, 592);
        addObject(new MetalBar(), 177, 592);
        addObject(new MetalBar(), 209, 592);
        //The Ground starts to rise up
        addObject(new MetalBar(), 241, 589);
        addObject(new MetalBar(), 273, 587);
        addObject(new MetalBar(), 305, 585);
        addObject(new MetalBar(), 337, 583);
        addObject(new MetalBar(), 369, 581);
        addObject(new MetalBar(), 401, 579);
        addObject(new MetalBar(), 433, 577);
        //The First ramp moving upwards towards the left side of the screen
        addObject(new MetalBar(), 401, 525);
        addObject(new MetalBar(), 369, 523);
        addObject(new MetalBar(), 337, 521);
        addObject(new MetalBar(), 305, 519);
        addObject(new MetalBar(), 273, 517);
        addObject(new MetalBar(), 241, 515);
        addObject(new MetalBar(), 209, 513);
        addObject(new MetalBar(), 177, 511);
        addObject(new MetalBar(), 145, 509);
        addObject(new MetalBar(), 113, 507);
        addObject(new MetalBar(), 81, 505);
        addObject(new MetalBar(), 49, 503);
        addObject(new MetalBar(), 17, 501);
        //The Second ramp moving upwards towards the right side of the screen
        addObject(new MetalBar(), 49, 448);
        addObject(new MetalBar(), 81, 446);
        addObject(new MetalBar(), 113, 444);
        addObject(new MetalBar(), 145, 442);
        addObject(new MetalBar(), 177, 440);
        addObject(new MetalBar(), 209, 438);
        addObject(new MetalBar(), 241, 436);
        addObject(new MetalBar(), 273, 434);
        addObject(new MetalBar(), 305, 432);
        addObject(new MetalBar(), 337, 430);
        addObject(new MetalBar(), 369, 428);
        addObject(new MetalBar(), 401, 426);
        addObject(new MetalBar(), 433, 424);
        //The Second ramp moving upwards towards the left side of the screen
        addObject(new MetalBar(), 401, 371);
        addObject(new MetalBar(), 369, 369);
        addObject(new MetalBar(), 337, 367);
        addObject(new MetalBar(), 305, 365);
        addObject(new MetalBar(), 273, 363);
        addObject(new MetalBar(), 241, 361);
        addObject(new MetalBar(), 209, 359);
        addObject(new MetalBar(), 177, 357);
        addObject(new MetalBar(), 145, 355);
        addObject(new MetalBar(), 113, 353);
        addObject(new MetalBar(), 81, 351);
        addObject(new MetalBar(), 49, 349);
        addObject(new MetalBar(), 17, 347);
        //The Third ramp moving upwards towards the right side of the screen
        addObject(new MetalBar(), 49, 289);
        addObject(new MetalBar(), 81, 287);
        addObject(new MetalBar(), 113, 285);
        addObject(new MetalBar(), 145, 283);
        addObject(new MetalBar(), 177, 281);
        addObject(new MetalBar(), 209, 279);
        addObject(new MetalBar(), 241, 277);
        addObject(new MetalBar(), 273, 275);
        addObject(new MetalBar(), 305, 273);
        addObject(new MetalBar(), 337, 271);
        addObject(new MetalBar(), 369, 269);
        addObject(new MetalBar(), 401, 267);
        addObject(new MetalBar(), 433, 265);
        //The ramp starts to move up four blocks to the 
        addObject(new MetalBar(), 401, 212);
        addObject(new MetalBar(), 369, 210);
        addObject(new MetalBar(), 337, 208);
        addObject(new MetalBar(), 305, 206);
        addObject(new MetalBar(), 273, 204);
        //The Ground Donkeykong and the Barrells are located on when first intilized
        addObject(new MetalBar(), 241, 204);
        addObject(new MetalBar(), 209, 204);
        addObject(new MetalBar(), 241, 204);
        addObject(new MetalBar(), 209, 204);
        addObject(new MetalBar(), 177, 204);
        addObject(new MetalBar(), 145, 204);
        addObject(new MetalBar(), 113, 204); 
        addObject(new MetalBar(), 81, 204);
        addObject(new MetalBar(), 49, 204);
        addObject(new MetalBar(), 17, 204);
        //The Ground Princess Pauline is standing on
        addObject(new MetalBar(), 255, 149);
        addObject(new MetalBar(), 225, 149);
        addObject(new MetalBar(), 195, 149);
        //The Boxes that cause the barrels to rotate the other way
        addObject(new TurnBox(),434,226);
        addObject(new TurnBox2(),17,299);
        addObject(new TurnBox3(),435,380);
        addObject(new TurnBox4(),17,460);
        addObject(new TurnBox5(),434,534);
        addObject(new StopBox(),100,579);
        addObject(new StopBox(),212,580);
        
        addLadder();
        getData();
        saveData();
        if(score > highScoreNum)
        {
            showText(Long.toString(score),220,40);
        }
        else
        {
            showText(Long.toString(highScoreNum),220,40);
        }   
    }
    
    /**
     * Act - is responsible with showing a Input Dialog asking for the players
     * name. After the name is typed up and selected, the Input Dialog is removed from
     * the screen. Now you will be able to see your name located on the top right of
     * the screen. This method is called whenever the 'Act' or 'Run' button gets 
     * pressed in the environment.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        showText("" + playerName, 380, 10);
        boolean playerLose= true;   
        if(nameSelected == true)
        {
            playerName = JOptionPane.showInputDialog( "Please enter your name:",null );
            nameSelected = false;
        }
    }
    
    /**
     * initializePlayingField - this method sets the background of the world
     * to black. This is to make the game look as close as it can to the original 
     * Donkey Kong 8 bit game.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void initializePlayingField()
    {
        getBackground().setColor(Color.BLACK);
        getBackground().fillRect( 0, 0, getWidth() ,getHeight());
    }
    
    /**
     * addLadder - is the mathod that uses a loop to add all 19 
     * ladders to thier corresponding location. This loop uses
     * parallel arrays to add all objets to the world.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void addLadder()
    {
        for(int i = 0; i < ladders.length; i++)
        {
            addObject(ladders[i],ladderXs[i],ladderYs[i]);
        }
    }
    
    /**
     * getData - gets the information from the HighScore.txt file and
     * saves it as the highScoreNum varriable. That varriable is later used 
     * to show the high score in the middle of the world.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void getData()
    {
        FileInputStream fis;
        BufferedReader r = null;
        try
        { 
            fis = new FileInputStream("HighScore.txt");
            r = new BufferedReader(new InputStreamReader(fis));
            highScoreNum = Long.parseLong(r.readLine());
        }
        catch(FileNotFoundException e1)
        {
            e1.printStackTrace();
        }
        catch(IOException e2)
        {
            e2.printStackTrace();
        }
    }
    
    /**
     * saveData - saves the score if it has been beated by than the
     * high score. If the score is higher than the highscore, the new
     * updated information is shared on the HighScore.txt file and later is used 
     * to share to the highscore.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void saveData()
    {
        if(score >  highScoreNum)
        {
            highScoreNum = score;
        }
        try
        {
            FileWriter writer = null;
            writer = new FileWriter("HighScore.txt");
            writer.write(Long.toString(highScoreNum));
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * addBarrel - adds a BarrelsSpinning object to the world
     * when it is initilized by donkey kong.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void addBarrel()
    {
        addObject(new BarrelsSpinning(),144,190);
    }
    
    /**
     * addBarrelOnGround - adds a BarrelsSpinning object to the world
     * when it is initilized by donkey kong on ground level.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void addBarrelOnGround()
    {
        addObject(new BarrelsSpinning(),100,564);
    }
    
    /**
     * addBarrelsDown - adds a BarrelDown object to the world
     * when it is initilized by donkey kong after his special 
     * move has been finished.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void addBarrelsDown()
    {
        addObject(new BarrelDown(), 100, 190);
    }  
  
    /**
     * update will add the score that Mario has collected in the PlayField to 
     * the scoreboard that is located at the top left of the screen.
     * 
     * @param None There are no parameters
     * @return Nothing is returnted
     */
    public void update()
    {
        scores.addToScore();
    } 
}
    