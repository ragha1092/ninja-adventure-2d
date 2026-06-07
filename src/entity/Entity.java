package entity;

import java.awt.image.BufferedImage;

//super class , will store variables that will be used in player, monster and NPC classes
public class Entity {
    public int x,y;
    public  int speed;

    // BufferedImage it describes an image with an accessible buffer of image data ( we use this to store our image files)
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    // To make our character look like its walking
    public int spriteCounter = 0;
    public int spritNum= 1;

}
