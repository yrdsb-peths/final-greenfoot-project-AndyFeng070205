import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sonic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sonic extends Actor
{
    /**
     * Act - do whatever the Sonic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int life = 3;
    public boolean right = true;
    SimpleTimer timer = new SimpleTimer();
    GreenfootImage SonicStart = new GreenfootImage("images/Sonic_walk/sonic_0.png");
    GreenfootImage SonicStopLeft = new GreenfootImage("images/sonicLeft.png");
    GreenfootImage[] sonicWalkRight = new GreenfootImage[8];
    GreenfootImage[] sonicWalkLeft = new GreenfootImage[8];
    GreenfootImage[] sonicSprintRight = new GreenfootImage[4];
    GreenfootImage[] sonicSprintLeft = new GreenfootImage[4];
    GreenfootImage[] sonicJumpRight = new GreenfootImage[4];
    GreenfootImage[] sonicJumpLeft = new GreenfootImage[4];
    
    public Sonic(){
        setImage(SonicStart);
        SonicStart.scale(70, 70);
        for(int i = 0; i < sonicWalkRight.length; i++){
            sonicWalkRight[i] = new GreenfootImage("images/Sonic_walk/sonic_" + i + ".png");
            sonicWalkRight[i].scale(70, 70);
        }
        for(int i = 0; i < sonicWalkLeft.length; i++){
            sonicWalkLeft[i] = new GreenfootImage("images/Sonic_walk/sonic_" + i + ".png");
            sonicWalkLeft[i].mirrorHorizontally();
            sonicWalkLeft[i].scale(70, 70);
        }
        for(int i = 0; i < sonicSprintRight.length; i++){
            sonicSprintRight[i] = new GreenfootImage("images/Sonic_sprint/sonic_" + i + ".png");
            sonicSprintRight[i].scale(70, 70);
        }
        for(int i = 0; i < sonicSprintLeft.length; i++){
            sonicSprintLeft[i] = new GreenfootImage("images/Sonic_sprint/sonic_" + i + ".png");
            sonicSprintLeft[i].mirrorHorizontally(); 
            sonicSprintLeft[i].scale(70, 70);
        }
        for(int i = 0; i < sonicJumpRight.length; i++){
            sonicJumpRight[i] = new GreenfootImage("images/Sonic_jump/jump_" + i + ".png");
            sonicJumpRight[i].scale(60, 60);
        }
        for(int i = 0; i < sonicJumpLeft.length; i++){
            sonicJumpLeft[i] = new GreenfootImage("images/Sonic_jump/jump_" + i + ".png");
            sonicJumpLeft[i].mirrorHorizontally();
            sonicJumpLeft[i].scale(60, 60);
        }
    }
    
    private int indexRight = 0;
    private int indexLeft = 0;
    private int indexSR = 0;
    private int indexSL = 0;
    private int indexJumpRight = 0;
    private int indexJumpLeft = 0;
    public void animation(){
        if(timer.millisElapsed() < 95) return; 
        timer.mark();
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("a")){
            if(right){
                    setImage(sonicWalkRight[indexRight]);
                    indexRight = (indexRight + 1) % sonicWalkRight.length;
            }
            else{
                setImage(sonicWalkLeft[indexLeft]);
                indexLeft = (indexLeft + 1) % sonicWalkLeft.length;
            }
        }
        if(Greenfoot.isKeyDown("shift")){
            if(right){
                setImage(sonicSprintRight[indexSR]);
                indexSR = (indexSR + 1) % sonicSprintRight.length;
            }
            else{
                setImage(sonicSprintLeft[indexSL]);
                indexSL = (indexSL + 1) % sonicSprintLeft.length;
            }
        }
        if(getY() < 300){
            if(right){
                setImage(sonicJumpRight[indexJumpRight]);
                indexJumpRight = (indexJumpRight + 1) % sonicJumpRight.length;
            }
            else{
                setImage(sonicJumpLeft[indexJumpLeft]);
                indexJumpLeft = (indexJumpLeft + 1) % sonicJumpRight.length;
            }
        }
    }
    
    private int gravity = 1;
    private boolean onGround = false;
    private int jumpForce = 20;
    private int upwardsVelocity = 0;
    public void jump(){
        if(getY() >= 300){
            onGround = true;
            setLocation(getX(), 300);
            upwardsVelocity = 0;
        }
        if(getY() < 300){
            upwardsVelocity -= gravity;
            if(right) setLocation(getX() + 1, getY() - upwardsVelocity);
            else setLocation(getX() - 1, getY() - upwardsVelocity);
        }
        if(Greenfoot.isKeyDown("w") && onGround){
            upwardsVelocity += jumpForce;
            if(right) setLocation(getX() + 1, getY() - upwardsVelocity);
            else setLocation(getX() - 1, getY() - upwardsVelocity);
            onGround = false;
            upwardsVelocity-=gravity;
        }
    }

    
    public void move(){    
        if(Greenfoot.isKeyDown("d")){
            move(5);
            right = true;
        }
        if(Greenfoot.isKeyDown("a")){
            move(-5);
            right = false;
        }
        if(Greenfoot.isKeyDown("shift")){
            if(right) move(7);
            else move(-7);
        }
        if(!(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("shift") || getY() < 300)){
            if(right){
                setImage(SonicStart);
                SonicStart.scale(70, 70);
            }
            else{
                setImage(SonicStopLeft);
                SonicStopLeft.scale(70, 70);
            }
        }
    }
    
    public void damage(){
        if(isTouching(Monsters.class)){
            life--;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        move();
        animation();
        jump();
    }
}
