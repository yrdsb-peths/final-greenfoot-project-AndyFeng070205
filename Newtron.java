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
    public boolean right = true;
    
    public Newtron(){
        super("newtron");
    }
    
    public boolean sonicInRange(){
        List<Sonic> sonic = getObjectsInRange(200, Sonic.class);
        if(!sonic.isEmpty()){
            Sonic nearestSonic = sonic.get(0);
            if(getX() - nearestSonic.getX() > 0) right = false;
            else right = true;
            return true;
        } 
        return false;
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
