/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.main;
import java.awt.Color;
import jaycodes.topdown.zombie.game.display.Display;

/**
 *
 * @author joseph junior
 */
public class TopdownZombieGame {

    /**
     * @param args the command line arguments
     */
//    4:3

    public TopdownZombieGame() {
    }

    public static int width = 800, height =600;
    public static void main(String[] args) {
        // TODO code application logic here
        String title = "Zombie Game";
        Display display = new Display(title,width,height,new Color(0, 0, 0));
        
        display.display();
        
        GameManager manager = new GameManager(display);
        manager.start();
    }
    
}
