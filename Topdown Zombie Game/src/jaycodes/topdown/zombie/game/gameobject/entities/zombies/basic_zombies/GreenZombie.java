/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gameobject.entities.zombies.basic_zombies;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jaycodes.topdown.zombie.game.gameobject.entities.ai.behaviours.Dummy;
import jaycodes.topdown.zombie.game.gameobject.entities.ai.behaviours.Seek;
import jaycodes.topdown.zombie.game.gameobject.entities.zombies.Zombie;
import jaycodes.topdown.zombie.game.gfx.animations.Animation;
import jaycodes.topdown.zombie.game.gfx.animations.AnimationController;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.scene.GamePlayScene;
import jaycodes.topdown.zombie.game.scene.Scene;
import jaycodes.topdown.zombie.game.utilities.Util;

/**
 *
 * @author Jay
 */
public class GreenZombie extends Zombie{
    
//    Steering steer;
    Animation walk , attack;
    
    public GreenZombie (Scene scene,Vector2f position){
        super(scene,position ,120 ,120);
        health = 50;
        speed = 1.6f;
        direction = new Vector2f();
    }
    @Override
    protected void update_zombie() {
    }

    @Override
    public void init() {
        try {
            BufferedImage [] arr = Util.loadAnimationFromFile("resources/animations/zombie a/walk", 17);
            walk = new Animation(arr,0.7f,"walk");
            arr = Util.loadAnimationFromFile("resources/animations/zombie a/attack", 9);
            attack = new  Animation(arr,0.3f,"attack");
            anim_controller = new AnimationController(new Animation[]{walk,attack});
            behaviour = new Seek(this,((GamePlayScene)(scene)).getPlayer());
            behaviour = new Dummy(this,((GamePlayScene)(scene)).getPlayer());
        } catch (IOException ex) {
            Logger.getLogger(GreenZombie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
