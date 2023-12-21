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
        for(int i = 0; i < rangeBombLeft.length / 2; i++){
            rangeBombLeft[i] = new GreenfootImage("images/enemy/Bomb/bomb2/bomb" + i + ".png");
            rangeBombLeft[i].scale(70, 85);
        }
        for(int i = 0; i < rangeBombRight.length; i++){
            rangeBombRight[i] = new GreenfootImage("images/enemy/Bomb/bomb2/bomb" + i + ".png");
            rangeBombRight[i].mirrorHorizontally();
            rangeBombRight[i].scale(70, 85);
        }
    }
    
    private int moveRight = 0;
    private int moveLeft = 0;
    private int moveLeftTimes = 0;
    private int moveRightTimes = 0;
    public void animation(){
        List<Sonic> sonic = getIntersectingObjects(Sonic.class);
        if(sonic.isEmpty()){
            if(timer.millisElapsed() < 220) return;
            timer.mark();
            if(right){
                setImage(rangeBombRight[moveRight]);
                moveRight = (moveRight + 1) % rangeBombRight.length;
                if(moveRightTimes == 5){
                    right = false;
                    moveRightTimes = 0;
                }
                else{
                    moveRightTimes++;
                    move(5);
                }
            }
            else{
                setImage(rangeBombLeft[moveLeft]);
                moveLeft = (moveLeft + 1) % rangeBombLeft.length;
                if(moveLeftTimes == 5){
                    right = true;
                    moveLeftTimes = 0;
                }
                else{
                    moveLeftTimes++;
                    move(-5);
                }
            }
        }
        else super.explodeWhenTouch();
    }
    
    public void act()
    {
        // Add your action code here.
        animation();
    }
}
