import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class BatBrain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BatBrain extends Monsters
{
    /**
     * Act - do whatever the BatBrain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage waiting = new GreenfootImage("images/batbrain/hanging.png");
    GreenfootImage[] flyingRight = new GreenfootImage[3];
    GreenfootImage[] flyingLeft = new GreenfootImage[3];
    private boolean right = true;
    private boolean canMove = false;
    SimpleTimer timer = new SimpleTimer();
    public BatBrain(){
        super("batbrain");
        waiting.scale(20, 40);
        for(int i = 0; i < flyingRight.length; i++){
            flyingRight[i] = new GreenfootImage("images/batbrain/flying/fly" + i + ".png");
            flyingRight[i].scale(40, 30);
        }
        for(int i = 0; i < flyingLeft.length; i++){
            flyingLeft[i] = new GreenfootImage("images/batbrain/flying/fly" + i + ".png");
            flyingLeft[i].mirrorHorizontally();
            flyingLeft[i].scale(40, 30);
        }
        flyingRight[1].scale(40, 20);
        flyingLeft[1].scale(40, 20);
    }
    
    public void sonicInRange(){
        List<Sonic> sonic = getObjectsInRange(500, Sonic.class);
        if(!sonic.isEmpty()){
            canMove = true;
            Sonic nearestSonic = sonic.get(0);
            if(nearestSonic.getY() < getY()){
                setImage(waiting);
                return;
            } else {
                flying();
            }
        } else {
            setImage(waiting);
            canMove = false;
        }
    }
    
    private int frame = 0;
    public void flying(){
        if(timer.millisElapsed() < 190) return;
        timer.mark();
        if(!canMove) return;
        if(right){
            setImage(flyingRight[frame]);
            frame = (frame + 1) % flyingRight.length;
        } else {
            setImage(flyingLeft[frame]);
            frame = (frame + 1) % flyingLeft.length;
        }
    }
    
    private int moveTimes = 0;
    private void moveAround(){
        if(!canMove) return;
        if(right){
            if(moveTimes >= 100){
                moveTimes = 0;
                right = false;
            }
            move(2);
            moveTimes++;
        } else {
            if(moveTimes >= 100){
                moveTimes = 0;
                right = true;
            }
            move(-2);
            moveTimes++;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        sonicInRange();
        moveAround();
        if(isTouching(Sonic.class)){
            getWorld().removeObject(this);
        }
    }
}
