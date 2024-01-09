import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage groundImage = new GreenfootImage("images/ground.png");
    public int groundTop = 0;
    public int groundBottom = 0;
    public int groundLeft = 0;
    public int groundRight = 0;
    public Ground(){
        setImage(groundImage);
    }
    public void act()
    {
        // Add your action code here.
        groundTop = getY() - getImage().getHeight() / 2;
        groundBottom = getY() + getImage().getHeight() / 2;
        groundLeft = getX() - getImage().getWidth() / 2;
        groundRight = getX() + getImage().getWidth() / 2;
    }
}
