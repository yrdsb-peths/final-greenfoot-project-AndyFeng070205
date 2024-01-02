import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Masher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Masher extends Monsters
{
    /**
     * Act - do whatever the Masher wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] masherRight = new GreenfootImage[2];
    GreenfootImage[] masherLeft = new GreenfootImage[2];
    private boolean right = true;
    SimpleTimer timer = new SimpleTimer();
    public Masher(){
        super("masher");
        for(int i = 0; i < masherRight.length; i++){
            masherRight[i] = new GreenfootImage("images/masher/masher" + i + ".png");
            masherRight[i].scale(60, 60);
        }
        for(int i = 0; i < masherLeft.length; i++){
            masherLeft[i] = new GreenfootImage("images/masher/masher" + i + ".png");
            masherLeft[i].mirrorHorizontally();
            masherLeft[i].scale(60, 60);
        }
    }
    
    private int rightFrame = 0;
    private int leftFrame = 0;
    public void animation(){
        if(timer.millisElapsed() < 300) return;
        timer.mark();
        if(right){
            setImage(masherRight[rightFrame]);
            rightFrame = (rightFrame + 1) % masherRight.length;
        } else {
            setImage(masherLeft[leftFrame]);
            leftFrame = (leftFrame + 1) % masherLeft.length;
        }
    }
    
    private int gravity = 1;
    private int jumpForce = 20;
    private int upwardsVelocity = 0;
    private void jumpAround(){
        if(getY() == 400){
            if(right) right = false;
            else right = true;
            setLocation(getX(), 399);
            upwardsVelocity = jumpForce;
        }
        if(getY() < 400){
            upwardsVelocity -= gravity;
            if(right) setLocation(getX() + 5, getY() - jumpForce);
            else setLocation(getX() - 5, getY() - jumpForce);
        }
        if(right) setLocation(getX(), getY() - upwardsVelocity);
        else setLocation(getX(), getY() - upwardsVelocity);
        upwardsVelocity -= gravity;
    }
    
    public void act()
    {
        // Add your action code here.
        animation();
        jumpAround();
    }
}
