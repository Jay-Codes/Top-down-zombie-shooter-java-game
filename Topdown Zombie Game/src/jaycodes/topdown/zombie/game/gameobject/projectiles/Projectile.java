/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jaycodes.topdown.zombie.game.gameobject.projectiles;

import jaycodes.topdown.zombie.game.gameobject.Collider;
import jaycodes.topdown.zombie.game.gameobject.CollisionListener;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.math.Vector2f;

/**
 *
 * @author josep
 */
public abstract class Projectile extends GameObject implements CollisionListener{
    protected Vector2f direction;
    protected float speed;
    protected Vector2f velocity;
    protected Collider collider;

    public Projectile() {
        direction = new Vector2f();
        speed = 0;
        velocity = new Vector2f();
        collider = new Collider(this,this);
    }
    
    public void setSpeed(float speed){
        this.speed = speed;
    }

    public Vector2f getDirection() {
        return direction;
    }

    public void setDirection(Vector2f direction) {
        this.direction = direction;
    }

    public Vector2f getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public Collider getCollider() {
        return collider;
    }

    public void setCollider(Collider collider) {
        this.collider = collider;
    }
    
    
}
