import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Sonic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sonic extends SmoothMover
{
/**
 * Write a description of class Sonic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
    private static int life = 3;
    public boolean right = true;
    SimpleTimer timer = new SimpleTimer();
    public boolean takeDamage;
    GreenfootImage SonicStart = new GreenfootImage("images/Sonic_walk/sonic_0.png");
    GreenfootImage SonicStopLeft = new GreenfootImage("images/sonicLeft.png");
    GreenfootImage SonicPrepare = new GreenfootImage("images/sonicPrepare/waiting0.png");
    GreenfootImage SonicRecover = new GreenfootImage("images/Sonicrecovering/sonicRecover0.png");
    GreenfootImage[] sonicWalkRight = new GreenfootImage[8];
    GreenfootImage[] sonicWalkLeft = new GreenfootImage[8];
    GreenfootImage[] sonicSprintRight = new GreenfootImage[4];
    GreenfootImage[] sonicSprintLeft = new GreenfootImage[4];
    GreenfootImage[] sonicJumpRight = new GreenfootImage[4];
    GreenfootImage[] sonicJumpLeft = new GreenfootImage[4];
    GreenfootImage[] sonicPrepare = new GreenfootImage[17];
    GreenfootImage[] sonicRecovering = new GreenfootImage[4];
    GreenfootImage[] sonicCrawl = new GreenfootImage[4];
    private boolean isWaiting = false;
    private int numCoins = 0;
    private int score = 0;
    Label coins = new Label("0", 35);
    Label scoreRecord = new Label("0", 35);
    public int speed = 0;
    
    public Sonic(){
        for(int i = 0; i < sonicPrepare.length; i++){
            sonicPrepare[i] = new GreenfootImage("images/sonicPrepare/waiting" + i + ".png");
            sonicPrepare[i].scale(51, 59);
        }
        for(int i = 0; i < sonicWalkRight.length; i++){
            sonicWalkRight[i] = new GreenfootImage("images/Sonic_walk/sonic_" + i + ".png");
            sonicWalkRight[i].scale(52, 61);
        }
        for(int i = 0; i < sonicWalkLeft.length; i++){
            sonicWalkLeft[i] = new GreenfootImage("images/Sonic_walk/sonic_" + i + ".png");
            sonicWalkLeft[i].mirrorHorizontally();
            sonicWalkLeft[i].scale(52, 61);
        }
        for(int i = 0; i < sonicSprintRight.length; i++){
            sonicSprintRight[i] = new GreenfootImage("images/Sonic_sprint/sonic_" + i + ".png");
            sonicSprintRight[i].scale(50, 61);
        }
        for(int i = 0; i < sonicSprintLeft.length; i++){
            sonicSprintLeft[i] = new GreenfootImage("images/Sonic_sprint/sonic_" + i + ".png");
            sonicSprintLeft[i].mirrorHorizontally(); 
            sonicSprintLeft[i].scale(50, 61);
        }
        for(int i = 0; i < sonicJumpRight.length; i++){
            sonicJumpRight[i] = new GreenfootImage("images/Sonic_jump/jump_" + i + ".png");
            sonicJumpRight[i].scale(51, 47);
        }
        for(int i = 0; i < sonicJumpLeft.length; i++){
            sonicJumpLeft[i] = new GreenfootImage("images/Sonic_jump/jump_" + i + ".png");
            sonicJumpLeft[i].mirrorHorizontally();
            sonicJumpLeft[i].scale(51, 47);
        }
        for(int i = 0; i < sonicRecovering.length; i++){
            sonicRecovering[i] = new GreenfootImage("images/sonicRecovering/sonicRecover" + i + ".png");
            sonicRecovering[i].scale(51, 47);
        }
        for(int i = 0; i < sonicCrawl.length; i++){
            sonicCrawl[i] = new GreenfootImage("images/sonicCrawl/tile" + i + ".png");
            sonicCrawl[i].scale(51, 47);
        }
        takeDamage = false;
        //sonicWalkRight[0].scale()
        //sonicWalkLeft[0].scale()
    }
    
    private int indexRight = 0;
    private int indexLeft = 0;
    private int indexSR = 0;
    private int indexSL = 0;
    private int indexJumpRight = 0;
    private int indexJumpLeft = 0;
    private int waitingIndex = 0;
    private int recoverFrame = 0;
    private int crawlFrame = 0;
    private void animation(){
        Ground ground = (Ground) getOneIntersectingObject(Ground.class);
        if(isWaiting && !takeDamage){
            if(timer.millisElapsed() < 220) return;
            timer.mark();
            setImage(sonicPrepare[waitingIndex]);
            waitingIndex = (waitingIndex + 1) % sonicPrepare.length;
        } else if(takeDamage && !isTouching(Ground.class)){
            if(upwardsVelocity >= 1){
                setImage(up);
                up.scale(65, 70);
            }
            if(upwardsVelocity < 1 && upwardsVelocity > -10){
                setImage(surprise);
                surprise.scale(67, 72);
            }
            if(upwardsVelocity <= -10){
                setImage(fall);
                fall.scale(50, 70);
            }
        } else if(takeDamage && isTouching(Ground.class)){
            if(timer.millisElapsed() < 500) return;
            timer.mark();
            if(recoverFrame >= sonicRecovering.length){
                recoverFrame = 0;
                takeDamage = false;
                isWaiting = false;
            } else {
                setImage(sonicRecovering[recoverFrame]);
                recoverFrame++;
            }
        } else {
            if(timer.millisElapsed() < 95) return;
            timer.mark();
            if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("a")){
                if(right){
                    setImage(sonicWalkRight[indexRight]);
                    indexRight = (indexRight + 1) % sonicWalkRight.length;
                } else {
                    setImage(sonicWalkLeft[indexLeft]);
                    indexLeft = (indexLeft + 1) % sonicWalkLeft.length;
                }
            }
            if(Greenfoot.isKeyDown("shift")){
                if(right){
                    setImage(sonicSprintRight[indexSR]);
                    indexSR = (indexSR + 1) % sonicSprintRight.length;
                } else {
                    setImage(sonicSprintLeft[indexSL]);
                    indexSL = (indexSL + 1) % sonicSprintLeft.length;
                }
            }
            if(!takeDamage && !isTouching(Ground.class)){
                if(right){
                    setImage(sonicJumpRight[indexJumpRight]);
                    indexJumpRight = (indexJumpRight + 1) % sonicJumpRight.length;
                } else {
                    setImage(sonicJumpLeft[indexJumpLeft]);
                    indexJumpLeft = (indexJumpLeft + 1) % sonicJumpRight.length;
                }
            } 
            if(Greenfoot.isKeyDown("s") && isTouching(Ground.class)){
                setImage(sonicCrawl[crawlFrame]);
                crawlFrame = (crawlFrame + 1) % sonicCrawl.length;
            }
        }
    }
    
    private void touchCheck() {
        Monsters monster = (Monsters) getOneIntersectingObject(Monsters.class);
        if(monster != null && monster instanceof buzzBomber){
            takeDamage = false;
            return;
        } else if(monster != null && monster instanceof Masher){
            takeDamage = true;
            return;
        } else if (monster != null) {
            double sonicTop = getY() - getImage().getHeight() / 2;
            double sonicBottom = getY() + getImage().getHeight() / 2; 
            double monsterTop = monster.getY() - monster.getImage().getHeight() / 2; 
            double monsterBottom = monster.getY() + monster.getImage().getHeight() / 2; 
    
            double sonicRight = getX() + getImage().getWidth() / 2; 
            double sonicLeft = getX() - getImage().getWidth() / 2; 
            double monsterRight = monster.getX() + monster.getImage().getWidth() / 2; 
            double monsterLeft = monster.getX() - monster.getImage().getWidth() / 2; 
    
            boolean isTouchingTop = sonicBottom >= monsterTop && sonicBottom <= monsterBottom;
            boolean isTouchingSide = ((sonicRight >= monsterLeft - 10 && sonicRight <= monsterRight + 10) || (sonicLeft <= monsterRight + 10 && sonicLeft >= monsterLeft - 10)) && sonicBottom >= monsterTop;
            boolean isTouchingBottom = sonicTop <= monsterBottom && sonicTop >= monsterTop;
            if(isTouchingTop) {
                isWaiting = false;
                takeDamage = false;
            }  else if(isTouchingSide) {
                isWaiting = false;
                takeDamage = true;
            } else if(isTouchingBottom) {
                isWaiting = false;
                takeDamage = true;
            } else {
                takeDamage = false;
            }
        } else {
            takeDamage = false;
            return;
        }
    }
    
    private void touchGround(){
        Ground ground = (Ground) getOneIntersectingObject(Ground.class);
        if(ground == null) return;
        int groundTop = ground.getY() - ground.getImage().getHeight() / 2;
        int groundBottom = ground.getY() + ground.getImage().getHeight() / 2;
        int groundLeft = ground.getX() - ground.getImage().getWidth() / 2;
        int groundRight = ground.getX() + ground.getImage().getWidth() / 2;
        
        double sonicTop = getY() - getImage().getHeight() / 2;
        double sonicBottom = getY() + getImage().getHeight() / 2; 
        double sonicRight = getX() + getImage().getWidth() / 2; 
        double sonicLeft = getX() - getImage().getWidth() / 2; 
        
        boolean touchingTop = sonicTop < groundTop && sonicBottom >= groundTop && isTouching(Ground.class);
        boolean touchingBottom = sonicTop <= groundBottom;
        boolean onLeftSide = getX() < groundLeft + 5;
        boolean onRightSide = getX() > groundRight - 5;
        
        if(touchingTop){
            onGround = true;
            setLocation(getX(), groundTop - getImage().getHeight() / 2 + 1);
            upwardsVelocity = 0;
        } else if(touchingBottom) {
            upwardsVelocity = 0;
            //while(!touchingTop){
                if(right) setLocation(getX() + 1, getY() - upwardsVelocity);
                else setLocation(getX() - 1, getY() - upwardsVelocity);
                upwardsVelocity -= gravity;
            //}
        } else if(onLeftSide || onRightSide){
            upwardsVelocity = 0;
            //while(!touchingTop){
                if(right) setLocation(getX() - (int) speed / 2, getY() - upwardsVelocity);
                else setLocation(getX() + (int) speed / 2, getY() - upwardsVelocity);
                upwardsVelocity -= gravity;
            //}
        }
    }
    
    private int gravity = 1;
    public boolean onGround = false;
    private int jumpForce = 20;
    private int upwardsVelocity = 0;
    private void jump(){
        if(!isTouching(Ground.class)){
            upwardsVelocity -= gravity;
            if(takeDamage){
                setLocation(getX() - 2, getY() - upwardsVelocity);
                return;
            }
            if(right) setLocation(getX() + 1, getY() - upwardsVelocity);
            else setLocation(getX() - 1, getY() - upwardsVelocity);
        }
        if(isTouching(Ground.class)){
            touchGround();
        }
        if(Greenfoot.isKeyDown("w") && onGround){
            if(takeDamage) return;
            upwardsVelocity += jumpForce;
            if(right) setLocation(getX() + 1, getY() - upwardsVelocity);
            else setLocation(getX() - 1, getY() - upwardsVelocity);
            onGround = false;
            upwardsVelocity -= gravity;
        }
    }
    
    private int afkTime = 120;
    private void afk(){
        if(!(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("shift") || Greenfoot.isKeyDown("w"))){
            if(afkTime <= 0) isWaiting = true;
            else afkTime--;
        }
        else{
            isWaiting = false;
            afkTime = 120;
        }
    }
    
    private void move(){
        Ground ground = (Ground) getOneIntersectingObject(Ground.class);
        if(isWaiting){
            return;
        } else if(Greenfoot.isKeyDown("d")){
            move(5);
            speed = 5;
            right = true;
        } else if(Greenfoot.isKeyDown("a")){
            move(-5);
            speed = 5;
            right = false;
        }
        if(ground == null) return;
        int groundTop = ground.getY() - ground.getImage().getHeight() / 2;
        if(Greenfoot.isKeyDown("shift")){
            if(right){
                move(7);
            } else {
                move(-7);
            }
            speed = 7;
        }
        if(Greenfoot.isKeyDown("s")){
            if(right) move(4);
            else move(-4);
            speed = 4;
        }
        if(!(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("shift") || Greenfoot.isKeyDown("s")) && isTouching(Ground.class)){
            if(right){
                setImage(SonicStart);
                SonicStart.scale(45, 59);
            }
            else{
                setImage(SonicStopLeft);
                SonicStopLeft.scale(47, 58);
            }
        }
    }
    
    GreenfootImage up = new GreenfootImage("images/fall/fall0.png");
    GreenfootImage surprise = new GreenfootImage("images/fall/fall1.png");
    GreenfootImage fall = new GreenfootImage("images/fall/fall2.png");
    private int pushBack = 14;
    public void damage(){
        Actor monster = getOneIntersectingObject(Monsters.class);
        Explosion explosion = (Explosion) getOneIntersectingObject(Explosion.class);
        if(monster != null && !(monster instanceof Bomb) && !(monster instanceof buzzBomber)){
            touchCheck();
            upwardsVelocity = pushBack;
            setLocation(getX(), getY() - upwardsVelocity);
            onGround = false;
            upwardsVelocity -= gravity;
        } else if(monster instanceof Bomb) {
            takeDamage = true;
            upwardsVelocity = pushBack;
            setLocation(getX(), getY() - upwardsVelocity);
            onGround = false;
            upwardsVelocity -= gravity;
        } else if(monster == null && explosion != null) {
            takeDamage = true;
            upwardsVelocity = pushBack;
            setLocation(getX(), getY() - upwardsVelocity);
            onGround = false;
            upwardsVelocity -= gravity;
        } else if(monster instanceof buzzBomber){
            return;
        }
        if(isTouching(Bullet.class)) {
            takeDamage = true;
            upwardsVelocity = pushBack;
            setLocation(getX(), getY() - upwardsVelocity);
            onGround = false;
            upwardsVelocity -= gravity;
        }
    }
    
    private void updateScore(){
        Monsters monster = (Monsters) getOneIntersectingObject(Monsters.class);
        if(!takeDamage && monster != null){
            if(monster instanceof BatBrain){
                score += 50;
            } else if(monster instanceof Caterkiller) {
                score += 90;
            } else if(monster instanceof Crabmeat) {
                score += 90;
            } else if(monster instanceof Motobug) {
                score += 100;
            } else if(monster instanceof Newtron) {
                score += 70;
            } else if(monster instanceof buzzBomber) {
                score += 70;
            }
            scoreRecord.setValue(score);
        } else if(takeDamage && monster != null){
            score -= 10;
            scoreRecord.setValue(score);
        }
    }
    
    public void coinUpdate(){
        if(isTouching(Coins.class)){
            removeTouching(Coins.class);
            numCoins++;
            coins.setValue(numCoins);
        }
    }
    
    public void act()
    {
        // Add your action code here.
        animation();
        if(takeDamage == false) move();
        jump();
        damage();
        afk();
        getWorld().addObject(coins, 128, 38);
        getWorld().addObject(scoreRecord, 130, 35);
        coinUpdate();
        updateScore();
        //System.out.println(getImage().getWidth() + " " + getImage().getHeight());
    }
}
