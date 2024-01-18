import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Crabmeat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crabmeat extends Monsters
{
    /**
     * Act - do whatever the Crabmeat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] crabs = new GreenfootImage[3];
    GreenfootImage crab = new GreenfootImage("images/enemy/crabmeat/tile0.png"); 
    SimpleTimer timer = new SimpleTimer();
    public Crabmeat(){
        super("crabmeat");
        setImage(crab);
        for(int i = 0; i < crabs.length; i++){
            crabs[i] = new GreenfootImage("images/enemy/crabmeat/tile" + i + ".png");
            crabs[i].scale(83, 64);
        }
    }
    private int index = 0;
    public void animation(){
        if(timer.millisElapsed() < 150) return;
        timer.mark();
        setImage(crabs[index]);
        index = (index + 1) % crabs.length;
    }
    
    public void act()
    {
        // Add your action code here.
        animation();
        super.getRecked();
    }
}
