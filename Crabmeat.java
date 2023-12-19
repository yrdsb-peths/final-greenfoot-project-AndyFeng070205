import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    GifImage image = new GifImage("images/crabmeat.gif");
    public Crabmeat(){
        super("crabmeat");
        setImage(image.getCurrentImage());
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
