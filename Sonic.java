import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    GreenfootImage[] sonicWalkRight = new GreenfootImage[8];
    GreenfootImage[] sonicWalkLeft = new GreenfootImage[8];
    GreenfootImage[] sonicSprintRight = new GreenfootImage[4];
    GreenfootImage[] sonicSprintLeft = new GreenfootImage[4];
    GreenfootImage[] sonicJumpRight = new GreenfootImage[4];
    GreenfootImage[] sonicJumpLeft = new GreenfootImage[4];
    GreenfootImage[] sonicPrepare = new GreenfootImage[17];
    GreenfootImage sonicInjured = new GreenfootImage("images/tile000.png");
    private boolean isWaiting = false;
    
    public Sonic(){
        setImage(SonicStart);
        SonicStart.scale(70, 70);
        for(int i = 0; i < sonicPrepare.length; i++){
            sonicPrepare[i] = new GreenfootImage("images/sonicPrepare/waiting" + i + ".png");
            sonicPrepare[i].scale(65, 65);
        }
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
        takeDamage = false;
    }
    
    private int indexRight = 0;
    private int indexLeft = 0;
    private int indexSR = 0;
    private int indexSL = 0;
    private int indexJumpRight = 0;
    private int indexJumpLeft = 0;
    private int waitingIndex = 0;
    private int restTime = 120;
    public void animation(){
        if(isWaiting){
            if(timer.millisElapsed() < 220) return;
            timer.mark();
            setImage(sonicPrepare[waitingIndex]);
            waitingIndex = (waitingIndex + 1) % sonicPrepare.length;
        }
        else if(takeDamage){
            if(upwardsVelocity >= 1){
                setImage(up);
                up.scale(85, 85);
            }
            if(upwardsVelocity < 1 && upwardsVelocity > -10){
                setImage(surprise);
                surprise.scale(80, 80);
            }
            if(upwardsVelocity <= -10){
                setImage(fall);
                fall.scale(70, 70);
            }
        }
        else{
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
    }
    
    public void touchCheck() {
        Monsters monster = (Monsters) getOneIntersectingObject(Monsters.class);
        if (monster != null) {
            double sonicTop = getY() - getImage().getHeight() / 2;
            double sonicBottom = getY() + getImage().getHeight() / 2; 
            double monsterTop = monster.getY() - monster.getImage().getHeight() / 2; 
            double monsterBottom = monster.getY() + monster.getImage().getHeight() / 2; 
    
            double sonicRight = getX() + getImage().getWidth() / 2; 
            double sonicLeft = getX() - getImage().getWidth() / 2; 
            double monsterRight = monster.getX() + monster.getImage().getWidth() / 2; 
            double monsterLeft = monster.getX() - monster.getImage().getWidth() / 2; 
    
            boolean isTouchingTop = sonicBottom >= monsterTop && sonicBottom <= monsterBottom;
            boolean isTouchingSide = (sonicRight >= monsterLeft && sonicRight <= monsterRight) || (sonicLeft <= monsterRight && sonicLeft >= monsterLeft);
            
            if (isTouchingTop) {
                takeDamage = false; 
            } else if (isTouchingSide && isTouchingTop) {
                takeDamage = true;
            } else if(isTouchingSide) {
                takeDamage = true;
            } else {
                takeDamage = false;
            }
        } else {
            takeDamage = false;
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
            upwardsVelocity -= gravity;
        }
    }
    
    private int afkTime = 120;
    public void afk(){
        if(!(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("shift") || Greenfoot.isKeyDown("w"))){
            if(afkTime <= 0) isWaiting = true;
            else afkTime--;
        }
        else{
            isWaiting = false;
            afkTime = 120;
        }
    }
    
    public void move(){
        if(isWaiting){
            return;
        }
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
    
    GreenfootImage up = new GreenfootImage("images/fall/fall0.png");
    GreenfootImage surprise = new GreenfootImage("images/fall/fall1.png");
    GreenfootImage fall = new GreenfootImage("images/fall/fall2.png");
    private int pushBack = 20;
    public void damage(){
        Actor monster = getOneIntersectingObject(Monsters.class);
        if(isTouching(Explosion.class)) takeDamage = true;
        if(monster != null){
            if(isTouching(Monsters.class)){
                touchCheck();
                if(getY() < 300){
                    setLocation(getX(), getY() - upwardsVelocity);
                    upwardsVelocity -= gravity;
                }
                upwardsVelocity = pushBack;
                setLocation(getX(), getY() - upwardsVelocity);
                onGround = false;
                upwardsVelocity -= gravity;
            }
        }
        if(getY() >= 300) takeDamage = false;
    }
    
    public void act()
    {
        // Add your action code here.
        animation();
        move();
        jump();
        damage();
        afk();
    }
}
