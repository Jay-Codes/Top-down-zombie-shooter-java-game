package jaycodes.topdown.zombie.game.gameobject;


import jaycodes.topdown.zombie.game.gameobject.GameObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author jay
 */
public interface CollisionListener {
    
    public abstract void onCollision(GameObject gameObject);
}
