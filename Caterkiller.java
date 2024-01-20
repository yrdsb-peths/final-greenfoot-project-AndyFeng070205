import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caterkiller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caterkiller extends Monsters
{
    /**
     * Act - do whatever the Caterkiller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] caterKillerR = new GreenfootImage[12];
    GreenfootImage[] caterKillerL = new GreenfootImage[12];
    private boolean right = true;
    SimpleTimer timer = new SimpleTimer();
    public Caterkiller(){
        super("caterkiller");
        for(int i = 0; i < caterKillerR.length; i++){
            caterKillerR[i] = new GreenfootImage("images/caterkiller/c" + i + ".png");
            caterKillerR[i].scale(100, 60);
        }
        for(int i = 0; i < caterKillerL.length; i++){
            caterKillerL[i] = new GreenfootImage("images/caterkiller/c" + i + ".png");
            caterKillerL[i].mirrorHorizontally();
            caterKillerL[i].scale(100, 60);
        }
    }
    
    
    /**
     * this method is responsible for both the animation and movement
     * of caterkiller, the purpose is that let caterkiller move once 
     * every frame, and turns around every 12 moves
     */
    private int frame = 0;
    private int moveTimes = 0;
    public void animation(){
        if(timer.millisElapsed() < 150) return;
        timer.mark();
        if(right){
            //after caterkiller moves 12 times, it turns around
            if(moveTimes >= 12){
                right = false;
                moveTimes = 0;
            }
            move(5);
            moveTimes++;
            setImage(caterKillerR[frame]);
            frame = (frame + 1) % caterKillerR.length;
        } else {
            //after caterkiller moves 12 times, it turns around
            if(moveTimes >= 12){
                right = true;
                moveTimes = 0;
            }
            move(-5);
            moveTimes++;
            setImage(caterKillerL[frame]);
            frame = (frame + 1) % caterKillerL.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        animation();
        super.getRecked();
    }
}
