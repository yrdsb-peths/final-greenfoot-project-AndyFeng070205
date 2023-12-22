import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends SmoothMover
{
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] explosion = new GreenfootImage[8];
    GreenfootImage explode = new GreenfootImage("images/explosion/explode0.png");
    SimpleTimer timer = new SimpleTimer();
    
    public Explosion(){
        setImage(explode);
        explode.scale(200, 181);
        for(int i = 0; i < explosion.length; i++){
            explosion[i] = new GreenfootImage("images/explosion/explode" + i + ".png");
            explosion[i].scale(300, 281);
        }
    }
    
    
    private int explodeFrame = 0;
    public void explodeAnimation(){
        if(timer.millisElapsed() < 70) return;
        timer.mark();
        if(explodeFrame >= explosion.length){
            getWorld().removeObject(this);
            explodeFrame = 0;
            return;
        }
        else{
            setImage(explosion[explodeFrame]);
            explodeFrame++;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        explodeAnimation();
    }
}
