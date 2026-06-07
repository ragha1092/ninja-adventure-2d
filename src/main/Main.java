package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window= new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exist on x
        window.setResizable(false);
        window.setTitle("Ninja advendture");

        GamePanel gamePanel= new GamePanel();
        window.add(gamePanel);
        window.pack(); //causes the window to be sized to fit preferred size and layouts of its subcompenents (=GamePanel)

        window.setLocationRelativeTo(null); // window will be displayed at the center of screen.
        window.setVisible(true); // so we can see the window

        gamePanel.startGameThread();

    }
}
