package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

//subclass og Jpanel , it has all the functions of jpanel
//Jpanel works like a gamescreen
public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int origanalTileSize= 16; //16x16 tile - 16 pixels
    final int scale=3;  // 16x3(scale)=48

    public final int tileSize=origanalTileSize*scale; //48 x 48
    public final int maxScreenCol=16;  // 16 columns - horizontal tiles
    public final int maxScreenRow=12 ;  // 12  rows - vertically
    public final int screenWidth= tileSize*maxScreenCol;   //48x16=768 pixels
    public final int screenHeight=tileSize*maxScreenRow;  //48x12=576 pixels

    //FPS
    int FPS= 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH=new KeyHandler();
    Thread gameThread; //acts as time in a game
    //The gameThread is the engine that drives your game loop. It runs continuously in the background,
    // updating the game state and redrawing the screen so your game feels alive and interactive.

    Player player = new Player(this,keyH);


    //Set player's default position -- dont need it now since we have Player clase
   // int playerX= 100;
   // int playerY= 100;
   // int playerSpeed=4;  //pixels


    //Constructor
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight)); //sets the size of this class(JPanel)
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true); //if true-all the drawing from this component will be done in an offscreen painting buffer
                                        // in short this can improves games  rendering performance
        this.addKeyListener(keyH); // so GamePanel can recognize the key input
        this.setFocusable(true); // GamePanel can be 'focused' to receive key input
    }

    public void startGameThread(){
        gameThread=new Thread(this); //this means the class GamePanel- passing this class to the gameThread constructor
        gameThread.start();// automatically call the run method
    }

    @Override
    public void run() {
        //we create the GameLoop here - the CORE of the game

        double drawInterval=1000000000/FPS;  // (1billion nanosecond= 1 second )/60 ----- meaning we draw the screen 60 times per second
        double nextDrawTime= System.nanoTime() +drawInterval; // the next draw time will be 0..016 s later

        while (gameThread != null){
            //System.out.println("The game loop is runniing");


            //Two thing we will be doing in this loop
            // 1 UPDATE: update information such as character position
            update();

            // 2 DRAW: draw the screen with the updated information
            repaint();// method to call paintComponent method

            try {
                double remainingTime= nextDrawTime -System.nanoTime(); //time left for next draw time
                remainingTime= remainingTime/1000000;  //converting nanosecond til mili- since sleep method only takes mili second in

                if (remainingTime<0){
                    remainingTime=0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
    public void update(){ //we change player position here

        player.update();
    }

    public void paintComponent(Graphics g){//built inn method in java
        super.paintComponent(g); //parent class is JPanel

        Graphics2D g2=(Graphics2D) g; // change Graphics g to Graphics2D- provides more sophisticated control over geometery, coordinate transformations, color management, and text layout.

        tileM.draw(g2); // this comes before player because its like a layer (tiles first and then player)
        player.draw(g2);

        g2.dispose(); //dispose of this grafics context and release any system resources that it is using

    }


}
