/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import jaycodes.topdown.zombie.game.display.Display;
import jaycodes.topdown.zombie.game.input.InputManager;
import jaycodes.topdown.zombie.game.input.MouseInput;
import jaycodes.topdown.zombie.game.scene.GamePlayScene;
import jaycodes.topdown.zombie.game.scene.Scene;
import jaycodes.topdown.zombie.game.scene.SceneManager;

/**
 *
 * @author joseph junior
 */
public class GameManager extends Thread{

    public boolean running;
    public int fps = 60;
    public Display display;
    private BufferStrategy bufferStrategy;
    private InputManager inputManager;
    private Scene scene;
    public static  float DELTA = 0.0002f;
    public static  float FPS = 200;
    BufferedImage backBuffer;
    
    public GameManager(Display display) {
        running = true;
        fps = 60;
        this.display=display;
    }
    public void init(){
        backBuffer = new BufferedImage(TopdownZombieGame.width, TopdownZombieGame.height, BufferedImage.TYPE_INT_RGB);
        inputManager= new InputManager();
        SceneManager.initialize();
        SceneManager.startScene("welcomescreen");
        scene = SceneManager.getCurrentScene();
        scene.init();
        
    }
    
    public void update(){// all your updating code goes in here
        //System.out.println("updating");
        InputManager.update();
        scene = SceneManager.getCurrentScene();
        scene.update();
         
    }
    public void render(){// all the rendering or drawing code goes here
        //System.out.println("rendering");
        initGraphics();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, TopdownZombieGame.width, TopdownZombieGame.height);
        //all the drawing goes here
        
        
        
        Graphics2D g2d = (Graphics2D)backBuffer.getGraphics();
        g2d.clearRect(0, 0, display.getWidth(), display.getHeight());
        scene.render(g2d);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("fps : " + (int)FPS, 5, 25);
        //end of draing code
        graphics.drawImage(backBuffer, display.xPos ,display.yPos ,display.bufferWidth,display.bufferHeight, null);
        bufferStrategy.show();
        graphics.dispose();
        g2d.dispose();
    }
    public void initGraphics(){
        Canvas canvas = display.getCanvas();
        bufferStrategy = canvas.getBufferStrategy();
        
        if (bufferStrategy != null )
            return;
        
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        
    }
    @Override
    public void run(){
        init();
        int counter = 0;
        float timePerUpdate = 1000000000/fps;
        long currentTime = 0 , prevTime = System.nanoTime();
        
        long now , lastTime;
        lastTime = System.nanoTime();
        while (running){
            
            currentTime = System.nanoTime();
            
            DELTA = (float)(currentTime - prevTime)/1000000000.0f ;
            FPS = 1/DELTA;
            prevTime = currentTime;
            update();
            render();
        }
    }
    public Display getDisplay(){
        return display;
    }
}
