/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gameobject.entities;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jaycodes.topdown.zombie.game.input.InputManager;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.scene.Scene;
import jaycodes.topdown.zombie.game.utilities.Util;

/**
 *
 * @author Jay
 */
public class Player extends Entity{

    public Player(Scene scene,Vector2f position){
        super(scene,position,125,125);
        name = "player";
    }
    
    @Override
    public void init() {
        
        try {
            sprite = Util.loadImageFromFile("resources/images/characters/player/test.png");
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        transform = AffineTransform.getTranslateInstance(position.x-width/2,position.y-height/2);
        speed = 3.6f;
    }
    
    @Override
    public void update() {
        
        direction = new Vector2f();
        
        manageInput();
        rotateMouseFollow();
        manageTransform();
        
    }

    @Override
    public void render(Graphics2D graphics) {
        renderer.drawImage(sprite, graphics, position, rotationAngle,width,height);
    }

    private void  rotateMouseFollow(){
        float mX,mY , pX ,pY ,opp ,adj;
        mX = InputManager.getMouseX();
        mY = InputManager.getMouseY();
        pX = (float) (position.x + width/2) ;
        pY = (float) (position.y + height/2) ;
        opp = mX - pX;
        adj = mY - pY;
        
        double value = Math.atan((double)opp/(double)adj);
        rotationAngle = (float) -(value+2.2355708216122423);
        
         if(adj < 0)
		rotationAngle = (float) (-Math.PI + rotationAngle);
         
         
    }
    
    private void manageInput(){
        if(InputManager.getKeyPressed("w"))
            direction.y--;
        if(InputManager.getKeyPressed("s"))
            direction.y++;
        if(InputManager.getKeyPressed("a"))
            direction.x--;
        if(InputManager.getKeyPressed("d"))
            direction.x++;
        if(InputManager.isFirstPressed("grenade"))
            System.out.println("first time g was pressed");
    }
    
    private void manageTransform(){
        if(direction.getLength()>0)
            direction = direction.normailize();
        
        position = position.add(direction.scale(speed));
        
        transform = AffineTransform.getTranslateInstance(position.x-width/2,position.y-height/2);
        
        transform.rotate(rotationAngle, width/2,height/2);
    }
    
}
