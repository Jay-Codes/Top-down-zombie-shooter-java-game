/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gameobject.entities;


import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.scene.Scene;

/**
 *
 * @author Jay
 */
public abstract class Entity extends GameObject {
    protected float health;
    protected float speed ;
    protected Vector2f direction , velocity = new Vector2f(0,0);
    
    public Entity (Scene scene){
        super(scene);
        health = 100;
        speed = 1.2f;
        direction = new Vector2f();
    }
    
    public Entity (Scene scene,Vector2f position , float width , float height){
        super(scene,position ,width ,height);
        health = 100;
        speed = 1.2f;
        direction = new Vector2f();
    }

    public float getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    public Vector2f getDirection() {
        return direction;
    }

    public void setVelocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public void setDirection(Vector2f direction) {
        this.direction = direction;
    }
    
    public void hit(float damage){
        health-= damage;
        health = health < 0? 0 : health;
    }
    
    public abstract void targetHasArrived();
    public abstract  void targetHasnotArrived();
    
}
