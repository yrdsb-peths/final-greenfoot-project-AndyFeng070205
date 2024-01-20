import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
public class SWorld extends World
{
    private int scrollingWidth, scrollingHeight; // dimensions of scrolling area
    private int actorMinX, actorMaxX, actorMinY, actorMaxY; // limits for main actor within world coordinates
    private int scrolledX, scrolledY; // horizontal and vertical scrolled amounts
    private int scrollType; // indicates scrolling directions (0=none, 1=horizontal, 2=vertical, 3=both)
    Actor mainActor = null; // the actor that always stays visible
    private List<Actor>genActors = new ArrayList(); // lists all generic scrolling actor objects
    private GreenfootImage background = null;

    public SWorld(int wide, int high, int cellSize, int scrollWide, int scrollHigh)
    {
        super(cellSize == 1 ? wide:(wide/2)*2+1, cellSize == 1 ? high : (high/2)*2+1, cellSize, false);
        scrollType = (scrollWide > wide ? 1 : 0)+(scrollHigh>high?2:0);
        scrollingWidth = scrollType%2 == 1 ? scrollWide : wide;
        scrollingHeight = scrollType/2 == 1 ? scrollHigh : high;
    }

    public SWorld(int wide, int high, int cellSize, int scrollWide)
    {
        this(wide, high, cellSize, scrollWide, high);
    }
    
    /**
     * Adds the main actor into the world at the center of the window and
     * sets the range in movement within the window for the actor,<br>
     * <br>
     * NOTE: this method must be called prior to calling <i>setScrollingBackground</i>
     * <br>
     * NOTE 2: if placing the main actor to a location where scrolling will end up taking place before moving it,
     * place a call the the 'act' method of this class at the end of the constructor of its subclass
     * using 'super.act()'.<br>
     *
     * @param main the actor that is to always stay in view
     * @param xRange the horizontal range of movement within the window
     * @param yRange the vertical range of movement within the window
     */
    public void setMainActor(Actor main, int xRange, int yRange)
    {
        if (main == null)
        {
            System.out.println("A main actor MUST be supplied.");
            System.out.println("");
            return;
        }
        super.addObject(main, 400, 350);
        mainActor = main;
        xRange = (int)Math.min(xRange, getWidth());
        yRange = (int)Math.min(yRange, getHeight());
        actorMinX = getWidth()/2-xRange/2;
        actorMaxX = getWidth()/2+xRange/2;
        actorMinY = getHeight()/2-yRange/2;
        actorMaxY = getHeight()/2+yRange/2;
    }

    /*
       add a scrolling background to the world
    */
    public void setScrollingBackground(GreenfootImage scrollingBackground)    
    {
        if(mainActor==null)
        {
            System.out.println("'setMainActor' MUST be called prior to calling 'setScrollingBackground'.");
            System.out.println("");
            return;
        }
        background = new GreenfootImage(scrollingBackground);
        background.scale(scrollingWidth*getCellSize(), scrollingHeight*getCellSize());
        scrollBackground();
    }
    /*
    this method draws the background as the mainActor move forward.
    when the mainActor move forward, this method will draws the part 
    of the background image at x and y.
    */
    public void fillScrollingBackground(GreenfootImage fillImage)
    {
        if(mainActor==null)
        {
            System.out.println("'setMainActor' MUST be called prior to calling 'fillScrollingBackground'.");
            System.out.println("");
            return;
        }
        if (fillImage.getWidth() < getWidth() && fillImage.getHeight() < getHeight())
        {
            setBackground(new GreenfootImage(fillImage));
            fillImage = getBackground();
        }
        background = new GreenfootImage(scrollingWidth*getCellSize(), scrollingHeight*getCellSize());
        for (int x=0; x<background.getWidth(); x+=fillImage.getWidth())
            for (int y=0; y<background.getHeight(); y+=fillImage.getHeight())
                background.drawImage(fillImage, x, y);
        scrollBackground();
    }
    
    /*
    the new addObject has one more variable, scroller, which decides
    whether or not the actor scroll as the world scroll
    */
    public void addObject(Actor obj, int xLoc, int yLoc, boolean scroller)
    {
        super.addObject(obj, xLoc, yLoc);
        if (scroller) genActors.add(obj);
    }
    
    public void addObject(Actor obj, int xLoc, int yLoc)
    {
        addObject(obj, xLoc, yLoc, true);
    }

    public void removeObject(Actor obj)
    {
        if (obj == null) return;
        if (obj.equals(mainActor)) mainActor = null;
        else genActors.remove(obj);
        super.removeObject(obj);
    }

    public void removeObjects(List<Actor>objs)
    {
        for (Actor obj : objs) removeObject(obj);
    }

    public void act()
    {
        scrollObjects();
        scrollBackground();
    }
    
    //Scroll the background
    private void scrollBackground() {
        if (background == null) return;
        int w = getWidth(), h = getHeight(), c = getCellSize();
        int bw = background.getWidth(), bh = background.getHeight();
        getBackground().drawImage(background, (w * c - bw) / 2 - scrolledX * c, (h * c - bh) / 2 - scrolledY * c);
    }

    private void scrollObjects()
    {
        if (mainActor==null) return;
        // determine how far the main actor is outside its standard window limits
        int dx=0, dy=0;
        if (mainActor.getX() < actorMinX) dx = actorMinX-mainActor.getX();
        if (mainActor.getX() > actorMaxX) dx = actorMaxX-mainActor.getX();
        if (mainActor.getY() < actorMinY) dy = actorMinY-mainActor.getY();
        if (mainActor.getY() > actorMaxY) dy = actorMaxY-mainActor.getY();
        if (dx == 0 && dy == 0) return; // not outside window limits
        // ** outside standard window limits **
        int dxSum = dx, dySum = dy; // hold changes in scroll amount
        scrolledX -= dx; scrolledY -= dy;// track scroll amount
        // move main actor back within standard window limits
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        // determine how far the background is inside the world limits
        dx=0; dy=0;
        if (scrolledX > scrollingWidth/2-getWidth()/2) dx = scrolledX-(scrollingWidth/2-getWidth()/2);
        if (scrolledX < getWidth()/2-scrollingWidth/2) dx = scrolledX-(getWidth()/2-scrollingWidth/2);
        if (scrolledY > scrollingHeight/2-getHeight()/2) dy = scrolledY-(scrollingHeight/2-getHeight()/2);
        if (scrolledY < getHeight()/2-scrollingHeight/2) dy = scrolledY-(getHeight()/2-scrollingHeight/2);
        // ** background does not completely cover world limits
        dxSum += dx; dySum += dy; // keep running sum of changes in scroll amount
        scrolledX -= dx; scrolledY -= dy; // adjust scroll amount
        // move all objects so background covers the world
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        for (Object obj : genActors)
        {
            Actor actor = (Actor)obj;
            actor.setLocation(actor.getX()+dxSum, actor.getY()+dySum);
        }
        // determine how far main actor is outside universal limits
        dx = 0; dy = 0;
        if (mainActor.getX() < 0) dx = 0-mainActor.getX();
        if (mainActor.getX() > getWidth()-1) dx = (getWidth()-1)-mainActor.getX();
        if (mainActor.getY() < 0) dy = 0-mainActor.getY();
        if (mainActor.getY() > getHeight()-1) dy = (getHeight()-1)-mainActor.getY();
        if (dx == 0 && dy == 0) return;
        // ** outside universal limits
        // move main actor back within world limits
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
    }

    public int getScrolledX()
    {
        return scrolledX;
    }

    public int getScrolledY()
    {
        return scrolledY;
    }

    public int getScrollingWidth()
    {
        return scrollingWidth;
    }

    public int getScrollingHeight()
    {
        return scrollingHeight;
    }
}