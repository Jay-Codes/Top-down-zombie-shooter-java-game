/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gameobject.entities.ai.behaviours;

import jaycodes.topdown.zombie.game.gameobject.entities.Entity;
import jaycodes.topdown.zombie.game.gameobject.entities.ai.Steering;
import jaycodes.topdown.zombie.game.math.Vector2f;

/**
 *
 * @author Jay
 */
public abstract class Behaviour {
    
    protected Entity us;
    protected  Steering steering;
    public Vector2f direction;

    public Behaviour(Entity us) {
        this.us = us;
        steering = new Steering(us.getPosition());
        direction = new Vector2f();
    }
    public abstract  void update();

    public Entity getEntity() {
        return us;
    }
    
    public Steering getSteering(){
        return steering;
    }
}
