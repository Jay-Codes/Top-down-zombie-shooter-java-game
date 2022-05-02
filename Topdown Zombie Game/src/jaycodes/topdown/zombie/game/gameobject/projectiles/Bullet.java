/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gameobject.projectiles;

import java.awt.Color;
import java.awt.Graphics2D;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gameobject.entities.Player;
import jaycodes.topdown.zombie.game.gameobject.entities.zombies.Zombie;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.scene.GamePlayScene;
import jaycodes.topdown.zombie.game.scene.Scene;

/**
 *
 * @author Jay
 */
public class Bullet extends  Projectile{
    float damage;
    public Bullet() {
        super();
    }

    public Bullet(Scene scene,float damage,Vector2f startPosition, Vector2f direction, float speed) {
        super(scene,startPosition,direction, speed,5,5);
        this.damage = damage;
    }
    
    
    @Override
    public void init() {
    }

    @Override
    public void update() {
        position = position.add(direction.normailize().scale(speed));
    }

    @Override
    public void render(Graphics2D graphics) {
        Color c = graphics.getColor();
        graphics.setColor(new Color(249,207,87));
        renderer.fillRect(graphics, position, 5, 5);
        graphics.setColor(c);
    }

    @Override
    public void onCollision(GameObject gameObject) {
        if (gameObject instanceof Zombie)
        {
            Zombie  z = (Zombie)gameObject;
            z.hit(damage);
            
            
            if (z.getHealth() <= 0){
                z.kill();
            }
        }
        if( !(gameObject instanceof Player))
            ((GamePlayScene)scene).removeProjectile(this);
    }
    
}
