import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Monsters
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer timer = new SimpleTimer();
    GreenfootImage explode = new GreenfootImage("images/explosion/explode0.png");
    GreenfootImage[] explosion = new GreenfootImage[8];
    public int X = 0;
    public int Y = 0;
    public String bombType;
    private boolean canExplode = false;
    public Bomb(String bomb){
        super("bomb");
        bombType = bomb;
        for(int i = 0; i < explosion.length; i++){
            explosion[i] = new GreenfootImage("images/explosion/explode" + i + ".png");
            explosion[i].scale(200, 181);
        }
        canExplode= true;
    }
    
    public boolean explodeCondition(){
        if(isTouching(Sonic.class)) canExplode = true;
        return canExplode;
    }
    
    private int explodeFrame = 0;
    public void explodeWhenTouch(){
        if(timer.millisElapsed() < 90) return;
        timer.mark();
        if (canExplode) {
            if (explodeFrame == explosion.length) {
                getWorld().removeObject(this);
                explodeFrame = 0;
                canExplode = false;
            } else {
                setImage(explosion[explodeFrame]);
                explodeFrame++;
            }
        }
}
    
    public void act()
    {
        // Add your action code here.
        X = getX();
        Y = getY();
    }
}
