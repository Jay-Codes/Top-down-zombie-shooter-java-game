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
public class Seek extends Behaviour{

    public Seek(Entity us, GameObject target) {
        super(us, target);
    }
    
    
    @Override
    public void updateBehaviour() {
        direction = steering.getDirectionTo(target.getPosition());
        
    }
}
