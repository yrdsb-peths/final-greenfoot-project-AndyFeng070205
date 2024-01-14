import greenfoot.*;

/**
 * Class MyWorld: sample world to show how to make use of my world super-class SWorld
 */
public class MyWorld extends SWorld
{
    /**
     * Creates a scrolling world using a main actor, a background, some obstacles, and a non-scrolling score.
     */
    public MyWorld()
    {    
        super(800, 500, 1, 1000); // scroll world constructor call; last parameter is scroll width
        // in the following statement, the main actor is placed in the center of the window
        setMainActor(new Sonic(), 400, 400); // the int parameters are centered window x and y ranges
        // to start the main actor elsewhere
        //GreenfootImage bg = new GreenfootImage("scene.jpg");
        //setScrollingBackground(bg); // set the scolling background image
        // add other scrollable objects normally
        // use of the following also adds scrollable objects
        //addObject(new Ground(), 380, 345, true); // the boolean determines scrollable state
        // use the following for non-scrollable objects
        //addObject(new Score(), 40, 390, false);
        addObject(new Ground(), 400, 400, true);
    }
}