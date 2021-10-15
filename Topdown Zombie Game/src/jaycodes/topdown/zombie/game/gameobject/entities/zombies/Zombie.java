/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gameobject.entities.zombies;

import java.awt.Graphics2D;
import jaycodes.topdown.zombie.game.gameobject.entities.Entity;
import jaycodes.topdown.zombie.game.gameobject.entities.ai.behaviours.Behaviour;
import jaycodes.topdown.zombie.game.gfx.animations.AnimationController;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.scene.Scene;

/**
 *
 * @author Jay
 */
public abstract class Zombie extends  Entity{
    protected  AnimationController anim_controller;
    protected Behaviour behaviour;
    protected  float damage =10f;
    public Zombie (Scene scene,Vector2f position , float width , float height){
        super(scene,position ,width ,height);
        health = 100;
        speed = 1.2f;
        direction = new Vector2f();
    }
    
    public Zombie (Scene scene,Vector2f position , float width , float height,float health , float speed){
        super(scene,position ,width ,height);
        super.health = health;
        super.speed = speed;
        direction = new Vector2f();
    }

    @Override
    public void update() {
        update_zombie();
        
        if(anim_controller!= null) anim_controller.update();
        
        if (behaviour != null) behaviour.update();
        
        position = position.add(velocity);
        
        //Manage Rotation
        double value = Math.atan((double)direction.y/(double)direction.x);
        
        rotationAngle =(float) ((value));
        
         if(direction.x < 0)
		rotationAngle = (float) (-Math.PI + rotationAngle);
    }
    
    protected  abstract  void update_zombie();

    @Override
    public void render(Graphics2D graphics) {
        if(anim_controller!= null)
            renderer.drawImage(anim_controller.getFrame(), graphics, position, rotationAngle, width, height);
    }
}
