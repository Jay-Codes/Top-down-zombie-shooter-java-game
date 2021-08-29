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
public class Seek extends Behaviour{
    
    GameObject target;
    Vector2f direction;
    public Seek(Entity us, GameObject target) {
        super(us);
        this.target=target;
        
    }
    
    
    @Override
    public void update() {
        steering.our_pos = us.getPosition();
        Vector2f direction = steering.getDirectionTo(target.getPosition()).normailize(); 
        us.setVelocity(steering.getVelocity(direction, us.getSpeed()));
    }
    
    public void setTarget(GameObject object){
        target=object;
    }
    
}
