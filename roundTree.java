import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class roundTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class roundTree extends Tree
{
    /**
     * Act - do whatever the roundTree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage roundTree = new GreenfootImage("images/roundTree.png");
    
    public roundTree(int sideLength){
        setImage(roundTree);
        roundTree.scale(sideLength, sideLength);
    }
    public void act()
    {
        // Add your action code here.
        
    }
}
