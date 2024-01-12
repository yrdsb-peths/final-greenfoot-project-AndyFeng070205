import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.*;
/**
 * Write a description of class Blue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blue extends Newtron
{
    /**
     * Act - do whatever the Blue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] blueFlyR = new GreenfootImage[2];
    GreenfootImage[] blueFlyL = new GreenfootImage[2];
    GreenfootImage[] blueTransform = new GreenfootImage[3];
    SimpleTimer timer = new SimpleTimer();
    public Blue(){
        for(int i = 0; i < blueFlyR.length; i++){
            blueFlyR[i] = new GreenfootImage("images/newtron/blue/fly/fly" + i + ".png");
            blueFlyR[i].scale(50, 14);
        }
        for(int i = 0; i < blueFlyL.length; i++){
            blueFlyL[i] = new GreenfootImage("images/newtron/blue/fly/fly" + i + ".png");
            blueFlyL[i].mirrorHorizontally();
            blueFlyL[i].scale(50, 14);
        }
        for(int i = 0; i < blueTransform.length; i++){
            blueTransform[i] = new GreenfootImage("images/newtron/Blue/invisible/i" + i + ".png");
        }
    }
    
    private int frame = 0;
    private int transformFrame = blueTransform.length - 1;
    private int transformBack = blueTransform.length - 1;
    public void animation(){
        if(!super.sonicInRange()){
            if(timer.millisElapsed() < 100) return;
            timer.mark();
            if(transformFrame <= 0){
                transformFrame = 0;
            }
            setImage(blueTransform[transformFrame]);
            transformFrame--;
        } else {
            if(right){
                setImage(blueFlyR[frame]);
                frame = (frame + 1) % blueFlyR.length;
            } else if(!right){
                setImage(blueFlyL[frame]);
                frame = (frame + 1) % blueFlyL.length;
            }
        }
    }
    
    private int moveTimes = 0;
    private void moveAround(){
        if(!super.sonicInRange()) return;
        if(right){
            if(moveTimes >= 10){
                moveTimes = 0;
                right = false;
            }
            move(5);
            moveTimes++;
        } else {
            if(moveTimes >= 10){
                moveTimes = 0;
                right = true;
            }
            move(-5);
            moveTimes++;
        }
    }
    
    public void attack(){
        List<Sonic> sonic = getObjectsInRange(100, Sonic.class);
        if(!sonic.isEmpty()){
            Sonic nearestSonic = sonic.get(0);
            int xDistance = Math.abs(getX() - nearestSonic.getX());
            int yDistance = Math.abs(getY() - nearestSonic.getY());
            double hypDistance = Math.pow(xDistance * xDistance + yDistance * yDistance, 1/2);
            double turnDegree = Math.atan(yDistance / xDistance);
            if(hypDistance < 100){
                if(right) move(5);
                else move(-5);
            }
            if(right){
                setRotation((int)(turnDegree * 180 / Math.PI));
                move(3);
            } else {
                  setRotation(-(int)(turnDegree * 180 / Math.PI));
                move(-3);
            }
            if(isTouching(Sonic.class)){ 
                nearestSonic.damage();
                getWorld().removeObject(this);
            }
        }
    }
    
    public void act()
    {
        // Add your action code here.
       animation();
       //transform();
       super.sonicInRange();
       moveAround();
       attack();
    }
}
