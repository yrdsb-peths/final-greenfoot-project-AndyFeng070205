import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coins extends Actor
{
    /**
     * Act - do whatever the Coins wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] coins = new GreenfootImage[15];
    SimpleTimer timer = new SimpleTimer();
    
    public Coins(){
        for(int i = 0; i < coins.length; i++){
            coins[i] = new GreenfootImage("images/coins/coin" + i + ".gif");
            coins[i].scale(30, 30);
        }
    }
    
    private int frame = 0;
    public void animation(){
        if(timer.millisElapsed() < 80) return;
        timer.mark();
        setImage(coins[frame]);
        frame = (frame + 1) % coins.length;
    }
    
    public void act()
    {
        // Add your action code here.
        animation();
    }
}
