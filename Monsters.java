import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.*;
/**
 * Write a description of class Monsters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monsters extends Actor
{
    /**
     * Act - do whatever the Monsters wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String type;
    
    public Monsters(String name){
        type = name;
    }
    
    public void getRecked(int h, int w){
        double radius = Math.pow(w * w + h * h, 1/2);
        List<Sonic> sonic = getObjectsInRange((int)radius, Sonic.class);
        if(sonic == null) return;
        Sonic nearestSonic = sonic.get(0);
        if(!nearestSonic.takeDamage){
            getWorld().removeObject(this);
        } else {
            return;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        
    }
}
