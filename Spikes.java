import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spikes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spikes extends Actor
{
    /**
     * Act - do whatever the Spikes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage spike = new GreenfootImage("images/spikes.png");
    public Spikes(){
        setImage(spike);
        spike.scale(50, 50);
    }
    
    public void act()
    {
        // Add your action code here.
        
    }
}
