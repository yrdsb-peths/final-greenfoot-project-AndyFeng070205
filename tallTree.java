import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tallTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tallTree extends Tree
{
    /**
     * Act - do whatever the tallTree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage tallTree = new GreenfootImage("images/tallTree.png");
    public tallTree(int height, int width){
        setImage(tallTree);
        tallTree.scale(width, height);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
