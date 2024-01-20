import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Motobug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Motobug extends Monsters
{
    /**
     * Act - do whatever the Motobug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer timer = new SimpleTimer();
    GreenfootImage[] motobugRight = new GreenfootImage[2];
    GreenfootImage[] motobugLeft = new GreenfootImage[2];
    private boolean right = false;
    GreenfootImage motobug = new GreenfootImage("images/enemy/Motobug/moveLeft/left0.png");
    public Motobug(){
        super("motobug");
        for(int i = 0; i < motobugLeft.length; i++){
            motobugLeft[i] = new GreenfootImage("images/enemy/Motobug/moveLeft/left" + i + ".png");
            motobugLeft[i].scale(77, 55);
        }
        for(int i = 0; i < motobugRight.length; i++){
            motobugRight[i] = new GreenfootImage("images/enemy/Motobug/moveRight/right" + i + ".png");
            motobugRight[i].scale(77, 55);
        }
    }
    
    
    /**
     * this method is responsible for the moving and animation of 
     * motobug. The purpose is to let motobug move in every frame. After
     * moving 8 times, motobug will turns around and move the opposite
     * direction
     */
    private int moveRight = 0;
    private int moveLeft = 0;
    private int moveLeftTimes = 0;
    private int moveRightTimes = 0;
    public void animation(){
        List<Sonic> sonic = getObjectsInRange(200, Sonic.class);
        if(timer.millisElapsed() < 220) return;
        timer.mark();
        if(right == true){
            if(moveRightTimes == 8){
                right = false;
                moveRightTimes = 0;
            }
            move(5);
            moveRightTimes++;
            setImage(motobugRight[moveRight]);
            moveRight = (moveRight + 1) % motobugRight.length;
        }
        else{
            if(moveLeftTimes == 8){
                right = true;
                moveLeftTimes = 0;
            }
            move(-5);
            moveLeftTimes++;
            setImage(motobugLeft[moveLeft]);
            moveLeft = (moveLeft + 1) % motobugLeft.length;
        }
    }
    
    /**
     * if sonic is in range, motobug will dashes towards sonic. The
     * direction is different when sonic is at different position
     */
    public void attackSonic(){
        List<Sonic> sonic = getObjectsInRange(300, Sonic.class);
        if(!sonic.isEmpty() && isTouching(Ground.class)){
            Sonic nearestSonic = sonic.get(0); // Get the first Sonic in the list
            double distance = getX() - nearestSonic.getX();
            if(nearestSonic.takeDamage) return;
            //motobug only attack sonic when it is on the ground
            if(distance > 0 && nearestSonic.onGround == true){
                right = false;
                move(-7);
            } else if (distance < 0 && nearestSonic.onGround == true){
                right = true;
                move(7);
            } else {
                if(right) move(7);
                else move(-7);
            }
            if(isTouching(Sonic.class)){
                //deal damage to sonic if sonic touches it
                nearestSonic.damage();
            }
        }
    }
    
    /**
     * the purpose of this class is to let motobug drops when it is not
     * on the ground.
     */
    private int up = 0;
    private int gravity = 1;
    public void drop(){
        if(!isTouching(Ground.class)){
            /*
            when it is not touching ground.class, motobug position will 
            be set down in an acceleration like pattern. As up decreases
            , the speed of falling down will get faster.
            */
            up -= gravity;
            setLocation(getX(), getY() - up);
        }
        Ground ground = (Ground) getOneIntersectingObject(Ground.class);
        if(ground == null) return;
        int groundTop = ground.getY() - ground.getImage().getHeight() / 2;
        if(isTouching(Ground.class)) setLocation(getX(), groundTop - getImage().getHeight() / 2);
    }
    
    public void act()
    {
        // Add your action code here.
        animation();
        attackSonic();
        drop();
        super.getRecked();
    }
}
