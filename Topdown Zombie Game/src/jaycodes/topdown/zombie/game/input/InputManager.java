/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 *
 * @author joseph junior
 */
public class InputManager {
    
    private static HashMap<String, Integer> keys;
    private static HashMap<String, Integer> buttons;

    public InputManager() {
        keys = new HashMap<String,Integer>();
        buttons = new HashMap<String,Integer>();
        keys.put("w", KeyEvent.VK_W);
        keys.put("a", KeyEvent.VK_A);
        keys.put("s", KeyEvent.VK_S);
        keys.put("d", KeyEvent.VK_D);
        keys.put("q", KeyEvent.VK_Q);
        keys.put("e", KeyEvent.VK_E);
        keys.put("reload", KeyEvent.VK_R);
        keys.put("grenade", KeyEvent.VK_G);
        keys.put("turret", KeyEvent.VK_T);
        keys.put("1", KeyEvent.VK_1);
        keys.put("2",KeyEvent.VK_2);
        keys.put("3", KeyEvent.VK_3);
        keys.put("z", KeyEvent.VK_Z);
        keys.put("enter", KeyEvent.VK_ENTER);
        keys.put("escape", KeyEvent.VK_ESCAPE);
        keys.put("up",KeyEvent.VK_UP);
        keys.put("down", KeyEvent.VK_DOWN);
        
        buttons.put("right mouse", MouseEvent.BUTTON3);
        buttons.put("left mouse", MouseEvent.BUTTON1);
        buttons.put("middle mouse", MouseEvent.BUTTON2);
    }
            
    public static void update(){
    }
    public static boolean isMouseBtnFirstPress(int btn){
        boolean prev = MouseInput.getPrevButtonPress(btn);
        
        boolean result = false;
        
        if (MouseInput.getPrevButtonPress(btn))
            result = false;
        else if(!prev & MouseInput.getButtonPressed(btn))
            result = true;
        
        MouseInput.prevButtonPresses[btn]=true;
        
        return  result;
    }
    
    public static boolean getMouseButtonPressed(int btn){
        try {
            return MouseInput.getButtonPressed(btn);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    public static boolean isFirstPress(int key){
        
        boolean prev = KeyInput.getPrevKeyPress(key);
        
        boolean result = false;
        
        if (KeyInput.getPrevKeyPress(key))
            result = false;
        else if(!prev & KeyInput.getKeyPressed(key))
            result = true;
        
        KeyInput.prevKeyPresses[key]=true;
        
        return  result;
    }
    
    public static boolean getKeyPressed(String key){
        try {
            return KeyInput.getKeyPressed(keys.get(key));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean isFirstPressed(String key){
        try {
            return isFirstPress(keys.get(key));
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean getMouseKeyPressed(String key){
        try {
            return MouseInput.getButtonPressed(buttons.get(key));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean isMouseFirstPressed(String key){
        try {
            return isMouseBtnFirstPress(buttons.get(key));
        } catch (Exception e) {
            return false;
        }
    }
    
    public static int getMouseX(){
        return MouseInput.x;
    }
    
    public static int getMouseY(){
        return MouseInput.y;
    }
    
    public static boolean isMouseMoving(){
        return MouseInput.mouseMoving;
    }
}
