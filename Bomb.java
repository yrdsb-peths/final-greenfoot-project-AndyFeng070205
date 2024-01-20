import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Monsters {
    SimpleTimer timer = new SimpleTimer();
    GreenfootImage[] explosion = new GreenfootImage[8];
    private int explodeFrame = 0;
    private boolean canExplode = false;

    public Bomb(String bomb) {
        super("bomb");
        for(int i = 0; i < explosion.length; i++){
            explosion[i] = new GreenfootImage("images/explosion/explode" + i + ".png");
            explosion[i].scale(200, 181);
        }
    }
    
    //create a explosion and then remove itself
    public void explosion(){
        getWorld().addObject(new Explosion(), getX(), getY() - 30);
        getWorld().removeObject(this);
    }
    
    public void act() {
        
    }
}

