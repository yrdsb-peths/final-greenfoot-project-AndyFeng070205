import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.*;

/**
 * Write a description of class buzzBomber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class buzzBomber extends Monsters
{
    /**
     * Act - do whatever the buzzBomber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean right = false;
    GreenfootImage[] buzzBomberLeft = new GreenfootImage[2];
    GreenfootImage[] buzzBomberRight = new GreenfootImage[2];
    GreenfootImage[] buzzBomberAttackLeft = new GreenfootImage[2];
    GreenfootImage[] buzzBomberAttackRight = new GreenfootImage[2];
    GreenfootImage start = new GreenfootImage("images/enemy/Buzzbomber/flyToLeft/tile0.png");
    SimpleTimer timer = new SimpleTimer();
    public double xDistance;
    public double yDistance;
    public double turnDegree;
    
    public buzzBomber(){
        super("buzzbomber");
        for(int i = 0; i < buzzBomberLeft.length; i++){
            buzzBomberLeft[i] = new GreenfootImage("images/enemy/Buzzbomber/flyToLeft/tile" + i + ".png");
            buzzBomberLeft[i].scale(60, 35);
        }
        for(int i = 0; i < buzzBomberRight.length; i++){
            buzzBomberRight[i] = new GreenfootImage("images/enemy/Buzzbomber/flyToRight/tile" + i + ".png");
            buzzBomberRight[i].scale(60, 35);
        }
        for(int i = 0; i < buzzBomberAttackLeft.length; i++){
            buzzBomberAttackLeft[i] = new GreenfootImage("images/enemy/Buzzbomber/attackLeft/tile" + i + ".png");
            buzzBomberAttackLeft[i].scale(50, 50);
        }
        for(int i = 0; i < buzzBomberAttackRight.length; i++){
            buzzBomberAttackRight[i] = new GreenfootImage("images/enemy/Buzzbomber/attackRight/tile" + i + ".png");
            buzzBomberAttackRight[i].scale(50, 50);
        }
    }
    
    
    private int leftFrame = 0;
    private int rightFrame = 0;
    private int moveTimes = 0;
    public void animation(){
        if(timer.millisElapsed() < 500) return;
        timer.mark();
        List<Sonic> sonic = getObjectsInRange(200, Sonic.class);
        if(!sonic.isEmpty()){
            Sonic nearestSonic = sonic.get(0);
            double xDistance = getX() - nearestSonic.getX();
            if(nearestSonic.takeDamage) return;
            if(xDistance > 0){
                right = false;
                setImage(buzzBomberAttackLeft[leftFrame]);
                leftFrame = (leftFrame + 1) % buzzBomberAttackLeft.length;
            } else if(xDistance < 0) {
                right = true;
                setImage(buzzBomberAttackRight[rightFrame]);
                if(rightFrame % 2 != 0) setLocation(getX(), getY() + 6);
                else setLocation(getX(), getY() - 6);
                rightFrame = (rightFrame + 1) % buzzBomberAttackRight.length;
            }
        } else {
            if(right == false){
                if(moveTimes == 5){
                    right = true;
                    moveTimes = 0;
                }
                setImage(buzzBomberLeft[leftFrame]);
                if(leftFrame % 2 != 0) setLocation(getX(), getY() + 6);
                else setLocation(getX(), getY() - 6);
                leftFrame = (leftFrame + 1) % buzzBomberLeft.length;
                moveTimes++;
                move(-10);
            } else {
                if(moveTimes == 5){
                    right = false;
                    moveTimes = 0;
                }
                setImage(buzzBomberRight[rightFrame]);
                rightFrame = (rightFrame + 1) % buzzBomberRight.length;
                if(rightFrame % 2 != 0) setLocation(getX(), getY() + 6);
                else setLocation(getX(), getY() - 6);
                move(10);
                moveTimes++;
            }
        }
    }
    
    private int recoverTime = 120;
    private boolean canFire = true;
    public void attackSonic(){
        List<Sonic> sonic = getObjectsInRange(200, Sonic.class);
        if(!sonic.isEmpty()){
            Sonic nearestSonic = sonic.get(0);
            xDistance = Math.abs(getX() - nearestSonic.getX());
            yDistance = Math.abs(getY() - nearestSonic.getY());
            turnDegree = Math.atan(yDistance / xDistance);
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
    
    public void act()
    {
        // Add your action code here.
        attackSonic();
        animation();
        if(isTouching(Sonic.class)){
            getWorld().removeObject(this);
        }
    }
}
