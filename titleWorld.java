import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class titleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class titleWorld extends World
{

    /**
     * Constructor for objects of class titleWorld.
     * 
     */
    Label label2 = new Label("Start", 34);
    Label label = new Label("Button", 34);
    public titleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void clickButton(Label label){
        if(label.getValue() == "Start" && Greenfoot.mouseClicked(label)){
            Greenfoot.setWorld(new MyWorld());
        }
        else if(label.getValue() == "Button" && Greenfoot.mouseClicked(label)){
            Greenfoot.setWorld(new instructionWorld());
        }
    }
    
    public void act(){
        clickButton(label);
        clickButton(label2);
    }
    
    private void prepare()
    {
        addObject(label,429,361);
        label.setLocation(400,365);
        label.setLocation(409,362);
        addObject(label2,200,364);
        label2.setLocation(215,366);
        label.setLocation(390,361);
        label.setLocation(397,369);
        label2.setLocation(192,362);
        label.setLocation(400,363);
        label2.setLocation(209,362);
        label.setLocation(417,356);
        label2.setLocation(191,359);
        label.setLocation(429,358);
        label2.setLocation(212,353);
        label2.setLocation(201,356);
        label.setLocation(417,361);
        label.setLocation(423,356);
        label.setLocation(420,358);
        label.setLocation(396,361);
        label.setLocation(396,363);
        label.setLocation(392,351);
    }
}
