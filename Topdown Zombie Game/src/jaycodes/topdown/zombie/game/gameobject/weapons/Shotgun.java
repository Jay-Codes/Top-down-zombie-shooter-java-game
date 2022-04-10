/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gameobject.weapons;

import jaycodes.topdown.zombie.game.gameobject.projectiles.Bullet;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.scene.Scene;

/**
 *
 * @author Jay
 */
public class Shotgun extends Gun {
    int bulletAmnt = 10;
    float spreadAngle = 15;

    public Shotgun(Scene scene) {
        super(scene);
    }

    @Override
    protected void shootBullet(Vector2f direction) {
        float individualAngle = spreadAngle / bulletAmnt;
        float startAngle = -(spreadAngle/2);
        
        
        for (int i = 0 ; i < bulletAmnt; i++){
            Vector2f dir =  direction.rotateAngle(startAngle);
            scene.addProjectile(new Bullet(scene,damage ,position,dir , speed));
            startAngle+= individualAngle;
        }
    }
    
    
}
