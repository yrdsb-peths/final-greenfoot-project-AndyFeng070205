import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;
import java.util.*;

/**
 * Write a description of class Bomb2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb2 extends Bomb
{
    /**
     * Act - do whatever the Bomb2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] rangeBombLeft = new GreenfootImage[5];
    GreenfootImage[] rangeBombRight = new GreenfootImage[5];
    private boolean right = false;
    GreenfootImage bomb2start = new GreenfootImage("images/enemy/Bomb/bomb2/bomb0.png");
    public Bomb2(){
        super("Bomb2");
        for(int i = 0; i < rangeBombLeft.length; i++){
            rangeBombLeft[i] = new GreenfootImage("images/enemy/Bomb/bomb2/bomb" + i + ".png");
            rangeBombLeft[i].scale(45, 78);
        }
        for(int i = 0; i < rangeBombRight.length; i++){
            rangeBombRight[i] = new GreenfootImage("images/enemy/Bomb/bomb2/bomb" + i + ".png");
            rangeBombRight[i].mirrorHorizontally();
            rangeBombRight[i].scale(45, 78);
        }
        rangeBombRight[4].scale(53, 78);
        rangeBombLeft[4].scale(53, 78);
    }
    
    public boolean sonicInRange() {
        List<Sonic> inRange = getObjectsInRange(100, Sonic.class);
        return !inRange.isEmpty();
    }
    
    private int moveRight = 0;
    private int moveLeft = 0;
    private int moveLeftTimes = 0;
    private int moveRightTimes = 0;
    public void animation(){
        if(timer.millisElapsed() < 220) return;
        timer.mark();
        if(right == true){
            if(moveRightTimes == 8){
                right = false;
                moveRightTimes = 0;
            }
            move(5);
            moveRightTimes++;
            setImage(rangeBombRight[moveRight]);
            moveRight = (moveRight + 1) % rangeBombRight.length;
        }
        else{
            if(moveLeftTimes == 8){
                right = true;
                moveLeftTimes = 0;
            }
            move(-5);
            moveLeftTimes++;
            setImage(rangeBombLeft[moveLeft]);
            moveLeft = (moveLeft + 1) % rangeBombLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        animation();
        if(sonicInRange() == true) super.explosion();
    }
}
