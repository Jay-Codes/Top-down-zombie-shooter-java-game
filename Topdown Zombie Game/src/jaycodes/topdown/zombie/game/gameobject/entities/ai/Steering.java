/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gameobject.entities.ai;

import jaycodes.topdown.zombie.game.math.Vector2f;

/**
 *
 * @author Jay
 */
public class Steering {
    
    public Vector2f our_pos;

    public Steering(Vector2f our_pos) {
        this.our_pos = our_pos;
    }
    
    public Vector2f getDirectionTo(Vector2f point){
        return point.sub(our_pos).normailize();
    }
    
    public Vector2f getVelocity(Vector2f direction,float speed){
        return direction.scale(speed);
    }
}
