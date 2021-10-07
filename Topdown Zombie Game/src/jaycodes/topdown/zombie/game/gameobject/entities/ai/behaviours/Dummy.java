/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gameobject.entities.ai.behaviours;

import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gameobject.entities.Entity;

/**
 *
 * @author jay
 */
public class Dummy extends Behaviour {

    public float seconds =3f;
    long passed, now;   
    
    float sightRange = 175f , maxFollowDist = 350f;
    boolean isFollowing = false;

    public Dummy(Entity us, GameObject target) {
        super(us, target);
    }
    
    @Override
    public void updateBehaviour() {
        now = System.currentTimeMillis();
        if (now - passed > seconds*1000) randomDirection();
        
        if( us.getPosition().distance(target.getPosition())<= sightRange){
            isFollowing = true;
            direction = steering.getDirectionTo(target.getPosition());
        }
        if( us.getPosition().distance(target.getPosition())<= maxFollowDist && isFollowing){
            isFollowing = true;
            direction = steering.getDirectionTo(target.getPosition());
        }
        else{
            isFollowing = false;
        }
        
    }
    
    public  void randomDirection(){
        direction.x =(float) (Math.random()-0.5);
        direction.y =(float) (Math.random()-0.5);
        direction = direction.normailize();
        passed = now;
    }
}
