import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends Actor
{
    /**
     * Act - do whatever the End wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage end = new GreenfootImage("images/endSign.png");
    
    public End(){
        setImage(end);
        end.scale(200, 100);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
