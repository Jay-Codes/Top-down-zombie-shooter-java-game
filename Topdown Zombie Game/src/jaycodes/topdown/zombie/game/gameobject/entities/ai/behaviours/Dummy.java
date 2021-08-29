/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gameobject.entities.ai.behaviours;

import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gameobject.entities.Entity;
import jaycodes.topdown.zombie.game.math.Vector2f;

/**
 *
 * @author Jay
 */
public class Dummy extends Behaviour{

    GameObject target;
    public float seconds = 6f ; 
    long passed ;
    public float sightRange = 200f;
    public float maxFollowDistance = 400f; 
    boolean spotted = false;
    
    public Dummy(Entity us, GameObject target) {
        super(us);
        this.target=target;
        direction = new Vector2f();
        passed = System.currentTimeMillis();
    }
    
    Vector2f direction ;
    
    void random(){
        float randx= (float)(Math.random()) - 0.5f;
        float randy= (float)(Math.random()) - 0.5f;
        direction =new Vector2f(randx,randy).normailize();
    }

    @Override
    public void update() {
        steering.our_pos = us.getPosition();
        long now = System.currentTimeMillis();
//        random direction
        if ( now - passed > seconds*1000){
            random();
            passed = now;
        }
        
//        move in the direction of the player
        if ( us.getPosition().distance(target.getPosition()) <= sightRange ){
             direction =   steering.getDirectionTo(target.getPosition()).normailize(); 
             spotted = true;
        }
        else if (us.getPosition().distance(target.getPosition()) <= maxFollowDistance && spotted){
            direction =   steering.getDirectionTo(target.getPosition()).normailize(); 
            spotted = true;
        }
        else {
            spotted = false;
        }
        
        us.setVelocity(steering.getVelocity(direction, us.getSpeed()));
    }
    
    public void setTarget(GameObject object){
        target=object;
    }
    
}
