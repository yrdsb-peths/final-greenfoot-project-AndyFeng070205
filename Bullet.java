import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever.zxz 
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage bullet = new GreenfootImage("images/red-draught.png");
    private boolean right = false;
    public Bullet(){
        setImage(bullet);
        bullet.scale(10, 10);
    }
    
    /*
    Only buzzBomber and Green shoots bullet, however, the direction
    is unknown. So b and g help me access the right variable of 
    buzzBomber and Green for the bullet to travel to the right direction
    */
    public void updateRight(){
       buzzBomber b = (buzzBomber) getOneIntersectingObject(buzzBomber.class);
       Green g = (Green) getOneIntersectingObject(Green.class);
       if(b == null || g == null) return;
       if(b != null) right = b.right;
       if(g != null) right = g.right;
    }
    
    public void act()
    {
        // Add your action code here.
        updateRight();
        if(right) move(5);
        else move(-5);
        //bullet only remove if and only if it touches Sonic, the edge of the world or the ground
        if(isAtEdge() || isTouching(Ground.class)) getWorld().removeObject(this);
    }
}
