import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lossing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lossing extends endWorld
{

    /**
     * Constructor for objects of class lossing.
     * 
     */
    private Label label4 = new Label("restart", 35);
    private Label label5 = new Label("back to menu", 35);
    private Label label6 = new Label("0", 30);
    private Label label7 = new Label("0", 30);
    private int endScore = 0;
    private int endCoin = 0;
    
    public lossing(int score, int coin)
    {
        endScore = score;
        endCoin = coin;
        prepare();
    }
    
    public void act(){
        click(label4);
        click(label5);
        label6.setValue(endScore);
        label7.setValue(endCoin);
    }
    
    public void click(Label label){
        if(label.getValue() == "restart" && Greenfoot.mouseClicked(label)){
            Greenfoot.setWorld(new MyWorld());
        } else if(label.getValue() == "back to menu" && Greenfoot.mouseClicked(label)){
            Greenfoot.setWorld(new titleWorld());
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Label label = new Label("You Failed :(", 50);
        addObject(label,280,165);
        label.setLocation(320,146);
        Label label2 = new Label("Score: ", 30);
        addObject(label2,227,199);
        label2.setLocation(238,210);
        Label label3 = new Label("Coins: ", 30);
        addObject(label3,221,255);
        label3.setLocation(231,247);
        label2.setLocation(241,206);
        label2.setLocation(240,205);
        label3.setLocation(237,241);
        addObject(label4,222,318);
        label4.setLocation(202,320);
        label3.setLocation(229,259);
        label2.setLocation(230,203);
        label4.setLocation(198,321);
        addObject(label5,363,311);
        label5.setLocation(390,324);
        label5.setLocation(413,322);
        addObject(label6,335,203);
        label6.setLocation(342,209);
        label2.setLocation(249,209);
        label3.setLocation(239,255);
        addObject(label7,343,251);
        label7.setLocation(339,259);
        label.setLocation(352,155);
        label.setLocation(246,134);
        label.setLocation(321,136);
        label.setLocation(319,136);
        label.setLocation(287,142);
    }
}
