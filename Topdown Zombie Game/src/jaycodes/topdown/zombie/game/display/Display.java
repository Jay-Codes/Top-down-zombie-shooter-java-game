/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.display;

import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;
import jaycodes.topdown.zombie.game.input.KeyInput;
import jaycodes.topdown.zombie.game.input.MouseInput;

/**
 *
 * @author joseph junior
 */
public class Display extends JFrame {
    public String title;
    public Canvas canvas;
    public static KeyInput keyInput;
    public static MouseInput mouseInput;

    public Display(String title, int width, int height, Color bgColor) {
        this.title = title;
        initialize(width, height,bgColor);
        
    }
    
    public void initialize(int width , int height, Color bg){
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        canvas = new Canvas();
        canvas.setSize(width, height);
        canvas.setBackground(bg);
        add(canvas);
//        setResizable(false);
        keyInput = new KeyInput();
        mouseInput = new MouseInput();
        canvas.addKeyListener(keyInput);
        canvas.addMouseListener(mouseInput);
        canvas.addMouseWheelListener(mouseInput);
        canvas.addMouseMotionListener(mouseInput);
    }
    
    public void display(){
        setVisible(true);
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
}
