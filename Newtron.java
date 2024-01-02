import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Newtron here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Newtron extends Monsters
{
    /**
     * Act - do whatever the Newtron wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean inRange = false;
    public boolean right = true;
    
    public Newtron(){
        super("newtron");
    }
    
    public void sonicInRange(){
        List<Sonic> sonic = getObjectsInRange(150, Sonic.class);
        if(!sonic.isEmpty()){
            Sonic nearestSonic = sonic.get(0);
            double xDistance = getX() - nearestSonic.getX();
            if(xDistance > 0) right = false;
            else right = true;
        }
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
