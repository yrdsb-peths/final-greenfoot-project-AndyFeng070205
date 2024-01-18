import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class instructionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class instructionWorld extends World
{
    private Label label4 = new Label("< back to menu", 30);
    private Label label5 = new Label("Keys", 40);
    private Label label6 = new Label("Monsters", 40);
    private Label label7 = new Label("how to play?", 40);
    /**
     * Constructor for objects of class instructionWorld.
     * 
     */
    public instructionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void act(){
        backToMenu(label4);
        backToMenu(label5);
        backToMenu(label6);
        backToMenu(label7);
    }
    
    public void backToMenu(Label label){
        if(label.getValue() == "< back to menu" && Greenfoot.mouseClicked(label)){
            Greenfoot.setWorld(new titleWorld());
        }
    }
    
    private void prepare()
    {
        addObject(label4, 140, 35);
        Label label = new Label("press <W> <A> <S> <D> to move", 34);
        addObject(label,297,168);
        label.setLocation(322,157);
        Label label2 = new Label("press <shift> to sprint", 34);
        addObject(label2,305,245);
        label2.setLocation(310,245);
        label.setLocation(317,173);
        label2.setLocation(399,221);
        Label label3 = new Label("Don't touch little creatures and enjoy!!!", 34);
        addObject(label3,303,309);
        label3.setLocation(341,300);
        label2.setLocation(315,239);
        label.setLocation(317,185);
        label.setLocation(320,190);
        label2.setLocation(308,243);
    }
}
