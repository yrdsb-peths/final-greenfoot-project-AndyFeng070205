import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blue extends Newtron
{
    /**
     * Act - do whatever the Blue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] blueFly = new GreenfootImage[2];
    GreenfootImage[] blueTransform = new GreenfootImage[3];
    
    public Blue(){
        for(int i = 0; i < blueFly.length; i++){
            blueFly[i] = new GreenfootImage("images/newtron/blue/fly/fly" + i + ".png");
        }
        for(int i = 0; i < blueTransform.length; i++){
            blueTransform[i] = new GreenfootImage("images/newtron/invisible/i" + i + ".png");
        }
    }
    
    public void attack(){
        
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
