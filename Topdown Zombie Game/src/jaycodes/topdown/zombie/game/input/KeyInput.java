/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author joseph junior
 */
public class KeyInput  implements KeyListener{

    public static  boolean keys [];
    public static  boolean prevKeyPresses [];
    
    
    public KeyInput() {
        initKeys(256);
    }

    public void initKeys(int keys){
        this.keys = new boolean[keys];
        this.prevKeyPresses = new boolean[keys];
    }
    
@Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        prevKeyPresses[e.getKeyCode()] = keys[e.getKeyCode()];
        try {
            keys[e.getKeyCode()] = true;
        } catch (Exception ex) {

        }
         
    }

    @Override
    public void keyReleased(KeyEvent e) {
        prevKeyPresses[e.getKeyCode()] = false;
        try {
            keys[e.getKeyCode()] = false;
        } catch (Exception ex) {

        }
    }
    
    public static boolean getKeyPressed(int key){
        return keys[key];
    }
    public static boolean getPrevKeyPress(int key){
        return prevKeyPresses[key];
    }
    public static void resetKeyPrevPress(int key){
        prevKeyPresses[key]=false;
    }
}
