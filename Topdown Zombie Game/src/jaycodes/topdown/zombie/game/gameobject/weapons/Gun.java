
package jaycodes.topdown.zombie.game.gameobject.weapons;
import java.awt.Graphics2D;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gameobject.projectiles.Bullet;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.scene.Scene;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jay
 */
public class Gun extends GameObject{
   float damage=  10;
   float speed =  50;
    Vector2f direction = new Vector2f();

    public Gun(Scene scene) {
        
        super(scene);
        
    }
    
    
    public void shoot(){
        scene.addProjectile(new Bullet(scene,damage ,position, direction , speed));
    }

    @Override
    public void init() {}

    @Override
    public void update() {}

    @Override
    public void render(Graphics2D graphics) {}

    public void setDirection(Vector2f direction) {
        this.direction = direction;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }
    
    
    
}
