/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gameobject.entities.ai.behaviours;

import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gameobject.entities.Entity;
import jaycodes.topdown.zombie.game.gameobject.entities.ai.Steering;
import jaycodes.topdown.zombie.game.math.Vector2f;

/**
 *
 * @author jay
 */
public abstract class Behaviour {
    
    protected Entity us;
    protected Steering steering;
    protected Vector2f velocity,direction;
    protected GameObject target;
    public float attackRange = 20f;

    public Behaviour(Entity us,GameObject target) {
        this.us = us;
        steering = new Steering(us.getPosition());
        velocity = new Vector2f();
        direction = new Vector2f();
        this.target = target;
    }
    

    public Entity getEntity() {
        return us;
    }
    
    
    public void update(){  
        steering.our_pos = us.getPosition();
        updateBehaviour();
        velocity = steering.getVelocity(direction, us.getSpeed());
        us.setDirection(direction);
        us.setVelocity(velocity);
        if(us.getPosition().distance(target.getPosition()) < attackRange) handleArrival() ;
        else us.targetHasnotArrived();
    }
    
    public void handleArrival(){
        us.setVelocity(new Vector2f());
        us.targetHasArrived(target);
    }

    public void setTarget(GameObject target) {
        this.target = target;
    }
    
    public float getDistance(){
        return us.getPosition().distance(target.getPosition());
    }
    
    public abstract void updateBehaviour();
}
