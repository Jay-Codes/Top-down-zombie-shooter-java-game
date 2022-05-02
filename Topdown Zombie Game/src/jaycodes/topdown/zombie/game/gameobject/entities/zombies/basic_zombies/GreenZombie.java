/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gameobject.entities.zombies.basic_zombies;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import jaycodes.topdown.zombie.game.gameobject.Collider;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gameobject.entities.Entity;
import jaycodes.topdown.zombie.game.gameobject.entities.ai.Steering;
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
public class GreenZombie extends Zombie implements ActionListener{
    
    Steering steer;
    Animation walk , attack;
    Timer attackTimer;
    public GreenZombie (Scene scene,Vector2f position){
        super(scene,position ,120 ,120);
        health = 100;
        speed = 1.2f;
        direction = new Vector2f();
        damage =100f;
        timeToNextAttack=0.5f;
    }

    @Override
    public void init() {
        try {
            BufferedImage [] arr = Util.loadAnimationFromFile("resources/animations/zombie a/walk", 17);
            walk = new Animation(arr,0.7f,"walk") {
                @Override
                public void onAnimationComplete() {}
            };
            arr = Util.loadAnimationFromFile("resources/animations/zombie a/attack", 9);
            attack = new  Animation(arr,timeToNextAttack,"attack") {
                @Override
                public void onAnimationComplete() {attackPlayer();}
            };
            anim_controller = new AnimationController(new Animation[]{walk,attack});
            steer = new Steering(position);
            //behaviour = new Seek(this,((GamePlayScene)scene).GetPlayer());
            behaviour = new Dummy(this,((GamePlayScene)scene).GetPlayer());
            
            behaviour.attackRange = attackRange;
            
            addComponent(new Collider(this,this));
            
            attackTimer = new Timer((int) (timeToNextAttack*1000), this);
            attackTimer.setRepeats(false);
        } catch (IOException ex) {
            Logger.getLogger(GreenZombie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    protected void update_zombie() {
        //Vector2f direction = new Vector2f(1,1).normailize();
        velocity = steer.getVelocity(direction, speed);
        canMove = anim_controller.currenAnimation == attack ? !anim_controller.currenAnimation.isRunning : 
                true;
    }
    @Override
    public void targetHasArrived(GameObject target) {
        anim_controller.setAnimation("attack");
        
        if(target instanceof Entity)
            attackPlayer((Entity)target);
    }

    @Override
    public void targetHasnotArrived() {
        if (anim_controller.currenAnimation==attack && attack.isRunning) return;
        anim_controller.setAnimation("walk");
    }
    
    public void attackPlayer(){
        ((GamePlayScene)scene).GetPlayer().hit(damage);
    }

    @Override
    public void onCollision(GameObject gameObject) {
//        System.out.println("Mr Zombie collided with"+ gameObject.getName());
    }

    @Override
    public void attackPlayer(Entity entity) {
        if(attackTimer.isRunning())return;
        lockedTarget = entity;
        attackTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(lockedTarget==null) return;
        if(behaviour.getDistance()> attackRange) return;
        lockedTarget.hit(damage);
        if (lockedTarget.getHealth() <= 0 )lockedTarget.kill();
    }
    
}
