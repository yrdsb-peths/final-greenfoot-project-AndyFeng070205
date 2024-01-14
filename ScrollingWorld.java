import greenfoot.*;

public class ScrollingWorld extends World {

    private int SCROLL_SPEED = 5;

    public ScrollingWorld() {
        // Create a new world with a width and height of 800x600 pixels
        super(800, 500, 1, false);
        prepare();
    }

    private void prepare() {
        // Add initial objects to the world (e.g., Sonic, monsters, ground, etc.)
        Sonic sonic = new Sonic();
        addObject(sonic, getWidth() / 2, 400);
        addObject(new Ground(), getWidth() / 2, getHeight() - 25);
        // Add other objects as needed
    }

    public void act() {
        // Check if Sonic is near the edges of the screen for scrolling
        Sonic sonic = getObjects(Sonic.class).get(0);
        int sonicX = sonic.getX();
        SCROLL_SPEED = sonic.speed;
        
        if (sonicX < getWidth() / 2 && sonicX > SCROLL_SPEED) {
            scrollWorld(-SCROLL_SPEED);
        } else if (sonicX > getWidth() / 2 && sonicX < getWidth() - SCROLL_SPEED) {
            scrollWorld(SCROLL_SPEED);
        }
    }

    private void scrollWorld(int speed) {
        for (Actor actor : getObjects(Actor.class)) {
            actor.setLocation(actor.getX() - speed, actor.getY());
        }
    }
}
