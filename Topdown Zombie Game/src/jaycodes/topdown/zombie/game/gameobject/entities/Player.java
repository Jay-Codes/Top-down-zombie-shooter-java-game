/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gameobject.entities;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jaycodes.topdown.zombie.game.gameobject.Collider;
import jaycodes.topdown.zombie.game.gameobject.CollisionListener;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gameobject.weapons.Gun;
import jaycodes.topdown.zombie.game.gameobject.weapons.Shotgun;
import jaycodes.topdown.zombie.game.gfx.animations.Animation;
import jaycodes.topdown.zombie.game.gfx.animations.AnimationController;
import jaycodes.topdown.zombie.game.input.InputManager;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.scene.Scene;
import jaycodes.topdown.zombie.game.scene.SceneManager;
import jaycodes.topdown.zombie.game.utilities.Util;

/**
 *
 * @author Jay
 */
public class Player extends Entity implements  CollisionListener{
    
    Animation walk , attack;
    AnimationController controller;
    Gun pistol;
    public Player(Scene scene,Vector2f position){
        super(scene,position,125,125);
        name = "player";
        health = 1000f;
        MAX_HEALTH = 1000f;
    }
    
    @Override
    public void init() {
        
        try {
            sprite = Util.loadImageFromFile("resources/images/characters/player/test.png");
            BufferedImage [] arr = Util.loadAnimationFromFile("resources/animations/zombie a/walk", 17);
            walk = new Animation(arr,0.7f,"walk") {
                @Override
                public void onAnimationComplete() {}
            };
            arr = Util.loadAnimationFromFile("resources/animations/zombie a/attack", 9);
            attack = new  Animation(arr,0.3f,"attack") {
                @Override
                public void onAnimationComplete() {}
            };
            
            controller = new AnimationController(new Animation[]{walk,attack});
            controller.setAnimation("walk");
            
            addComponent(new Collider(this,this));
            
            pistol = new Gun(scene);
            pistol.accuracy=95;
            
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        transform = AffineTransform.getTranslateInstance(position.x-width/2,position.y-height/2);
        speed = 3.6f;
    }
    
    @Override
    public void update() {
        manageAnimation();
        direction = new Vector2f();
        
        
        manageInput();
        rotateMouseFollow();
        manageTransform();
        manageShooting();
        
    }
    
    void manageShooting(){
        
        Vector2f mouse  = new Vector2f(InputManager.getMouseX(),InputManager.getMouseY());
        Vector2f shootDirection = mouse.sub(getOnScreenCoordinates());
        pistol.setDirection(shootDirection);
        pistol.setPosition(position);
        pistol.shoot();
    }
    
    void manageAnimation(){
        if (InputManager.getKeyPressed("q"))
            controller.setAnimation("walk");
        
        if (InputManager.getKeyPressed("e"))
            controller.setAnimation("attack");
        
        controller.update();
        
    }

    @Override
    public void render(Graphics2D graphics) {
        renderer.drawImage(sprite, graphics, position, rotationAngle,width,height);
//        renderer.drawImage(controller.getFrame(), graphics, position, rotationAngle, width, height);
    }
    private void  rotateMouseFollow(){
        float mX,mY , pX ,pY ,opp ,adj;
        mX = InputManager.getMouseX();
        mY = InputManager.getMouseY();
        pX = renderer.xoffset ;
        pY = renderer.yoffset ;
        opp = mX - pX;
        adj = mY - pY;
        
        double value = Math.atan((double)opp/(double)adj);
        
        rotationAngle =(float) ((value*-1 )+ 2.929998);
        
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
        
//        if (InputManager.isMouseFirstPressed("right mouse"))
//            System.out.println("left mouse bro");
        
    }
    
    private void manageTransform(){
        if(direction.getLength()>0)
            direction = direction.normailize();
        
        position = position.add(direction.scale(speed));
        
        transform = AffineTransform.getTranslateInstance(position.x-width/2,position.y-height/2);
        
        transform.rotate(rotationAngle, width/2,height/2);
    }

    @Override
    public void targetHasArrived(GameObject gobj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void targetHasnotArrived() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onCollision(GameObject gameObject) {
//        System.out.println(gameObject.getName());
    }

    @Override
    public void kill() {
        SceneManager.startScene("welcomescreen");
    }
}
