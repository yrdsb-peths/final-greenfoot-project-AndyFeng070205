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
    
    // is touched by sonic, the monster will be removed
    public void getRecked(){
        if(isTouching(Sonic.class)){
            getWorld().removeObject(this);
        }
    }
    public void act()
    {
        // Add your action code here.
        
    }
}
