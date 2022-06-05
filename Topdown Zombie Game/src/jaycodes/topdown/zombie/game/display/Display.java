/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
import jaycodes.topdown.zombie.game.input.KeyInput;
import jaycodes.topdown.zombie.game.input.MouseInput;
import jaycodes.topdown.zombie.game.main.TopdownZombieGame;

/**
 *
 * @author joseph junior
 */
public class Display extends JFrame implements  ComponentListener {
    public String title;
    public Canvas canvas;
    public static KeyInput keyInput;
    public static MouseInput mouseInput;
    public int xPos =0 ,yPos=0, bufferWidth,bufferHeight;
    public static float aspect;
    public Display(String title, int width, int height, Color bgColor) {
        this.title = title;
        initialize(width, height,bgColor);
        
    }
    
    public void initialize(int width , int height, Color bg){
        aspect =  TopdownZombieGame.getApsectRatio();
        setSize(width, height);
        bufferHeight = height;
        bufferWidth = width;
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setUndecorated(true);
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
        addComponentListener(this);
    }
    
    public void display(){
        setVisible(true);
    }
    
    public Canvas getCanvas(){
        return canvas;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        bufferHeight =  e.getComponent().getHeight();
        bufferWidth =  (int) (bufferHeight * aspect);
        xPos = (e.getComponent().getWidth() - bufferWidth)/2;
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}

}
