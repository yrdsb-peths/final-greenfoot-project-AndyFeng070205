import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage heart = new GreenfootImage("images/heart.png");
    GreenfootImage brokenHeart = new GreenfootImage("images/broken_heart.png");
    
    public Heart(){
        setImage(heart);
        heart.scale(25, 25);
        brokenHeart.scale(25, 25);
    }
    
    public void changeImage(){
        
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
