
package jaycodes.topdown.zombie.game.gameobject.weapons;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
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
   float speed =  5;
   float fireRate = 1;
    Vector2f direction = new Vector2f();
    ActionListener action = new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) { 
           scene.addProjectile(new Bullet(scene,damage ,position, direction , speed));
       }
    };
    Timer shooTimer;

    public Gun(Scene scene) {
        super(scene);
        int delay = (int) (1000/fireRate);
        shooTimer = new Timer(delay, action);
        shooTimer.setRepeats(false);
    }
    
    
    public void shoot(){
       if (shooTimer.isRunning()) return;
       shooTimer.start();
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
