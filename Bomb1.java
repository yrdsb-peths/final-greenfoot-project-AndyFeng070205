import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Bomb1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb1 extends Bomb
{
    /**
     * Act - do whatever the Bomb1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    SimpleTimer timer = new SimpleTimer();
    private boolean canExplode = false;
    private boolean right = false;
    GreenfootImage[] bomb1Left = new GreenfootImage[5];
    GreenfootImage[] bomb1Right = new GreenfootImage[5];
    GreenfootImage image = new GreenfootImage("images/enemy/Bomb/bomb1/bomb0.png");
    private boolean explode = false;
    public Bomb1(){
        super("Bomb1");
        for(int i = 0; i < bomb1Left.length; i++){
            bomb1Left[i] = new GreenfootImage("images/enemy/Bomb/bomb1/bomb" + i + ".png");
            bomb1Left[i].scale(46, 57);
        }
        for(int i = 0; i < bomb1Right.length; i++){
            bomb1Right[i] = new GreenfootImage("images/enemy/Bomb/bomb1/bomb" + i + ".png");
            bomb1Right[i].mirrorHorizontally();
            bomb1Right[i].scale(46, 57);
        }
        bomb1Left[4].scale(53, 57);
        bomb1Right[4].scale(53, 57);
    }
    
    private int moveRightIndex = 0;
    private int moveLeftIndex = 0;
    private int moveLeftTime = 0;
    private int moveRightTime = 0;
    public void animation(){
        if(timer.millisElapsed() < 220) return;
        timer.mark();
        if(right == true){
            if(moveRightTime == 8){
                right = false;
                moveRightTime = 0;
            }
            move(5);
            moveRightTime++;
            setImage(bomb1Right[moveRightIndex]);
            moveRightIndex = (moveRightIndex + 1) % bomb1Right.length;
        }
        if(right == false){
            if(moveLeftTime == 8){
                right = true;
                moveLeftTime = 0;
            }
            move(-5);
            moveLeftTime++;
            setImage(bomb1Left[moveLeftIndex]);
            moveLeftIndex = (moveLeftIndex + 1) % bomb1Left.length;
        }
    }
    
    public void explode(){
        Sonic sonic = (Sonic) getOneIntersectingObject(Sonic.class);
        if(sonic == null) return;
        super.explosion();
    }
    
    public void act()
    {
        // Add your action code here.
        animation();
        explode();
    }
}
