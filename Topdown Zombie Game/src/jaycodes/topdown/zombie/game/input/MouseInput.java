/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 *
 * @author joseph junior
 */
public class MouseInput implements MouseWheelListener , MouseMotionListener ,MouseListener{

    public static int x ,y;
    public static boolean mouseMoving= false;
    
    public static  boolean buttons [];
    public static  boolean prevButtonPresses [];
    
    public static boolean isPressed = false;

    public MouseInput() {
        initButtons(100);
    }
    
    
    
    public void initButtons(int keys){
        this.buttons = new boolean[keys];
        this.prevButtonPresses = new boolean[keys];
    }
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
//        System.out.println(e.getScrollAmount());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        mouseMoving = true;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        mouseMoving =true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        prevButtonPresses[e.getButton()] = buttons[e.getButton()];
        try {
            buttons[e.getButton()] = true;
        } catch (Exception ex) {

        }
        isPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        prevButtonPresses[e.getButton()] = false;
        try {
            buttons[e.getButton()] = false;
        } catch (Exception ex) {

        }
        isPressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
     public static boolean getButtonPressed(int key){
        return buttons[key];
    }
    public static boolean getPrevButtonPress(int key){
        return prevButtonPresses[key];
    }
    public static void resetButtonPrevPress(int key){
        prevButtonPresses[key]=false;
    }
}
