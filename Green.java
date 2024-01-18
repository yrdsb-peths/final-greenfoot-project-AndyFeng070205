import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Green here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Green extends Newtron
{
    /**
     * Act - do whatever the Green wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage invisible = new GreenfootImage("images/newtron/Green/invisible.png");
    GreenfootImage visible = new GreenfootImage("images/newtron/Green/appear.png");
    
    public Green(){
        
    }
    
    private int recoverTime = 120;
    private boolean canFire = true;
    public void attackSonic(){
        List<Sonic> sonic = getObjectsInRange(200, Sonic.class);
        if(!sonic.isEmpty()){
            Sonic nearestSonic = sonic.get(0);
            double xDistance = Math.abs(getX() - nearestSonic.getX());
            double yDistance = Math.abs(getY() - nearestSonic.getY());
            double turnDegree = Math.atan(yDistance / xDistance);
            if(nearestSonic.takeDamage) return;
            if(canFire){
                Bullet b = new Bullet();
                if(right) b.setRotation((int)(turnDegree * 180 / Math.PI) - 180);
                else b.setRotation(-(int)(turnDegree * 180 / Math.PI));
                getWorld().addObject(b, getX() - 5, getY() + 10);
                canFire = false;
            } else {
                if(recoverTime <= 0){
                    recoverTime = 120;
                    canFire = true;
                }
                recoverTime--;
            }
        }
    }
    
    public void animation(){
        List<Sonic> sonic = getObjectsInRange(200, Sonic.class);
        if(!sonic.isEmpty()){
            setImage(visible);
        } else {
            setImage(invisible);
        }
    }
    
    public void act()
    {
        // Add your action code here.
        super.sonicInRange();
        animation();
        attackSonic();
    }
}
