import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spring here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spring extends Actor
{
    /**
     * Act - do whatever the Spring wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage spring1 = new GreenfootImage("images/spring.png");
    GreenfootSound bounce = new GreenfootSound("sounds/bounce.mp3");
    public Spring(){
        setImage(spring1);
        spring1.scale(55, 27);
        bounce.setVolume(30);
    }
    
    public void act()
    {
        // Add your action code here.
        if(isTouching(Sonic.class)){
            bounce.play();
        }
    }
}
