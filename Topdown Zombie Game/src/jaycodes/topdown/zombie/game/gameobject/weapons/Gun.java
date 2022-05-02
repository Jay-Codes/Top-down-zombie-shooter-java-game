
package jaycodes.topdown.zombie.game.gameobject.weapons;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gameobject.projectiles.Bullet;
import jaycodes.topdown.zombie.game.input.InputManager;
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
   public float damage=  5;
   public float speed =  600;
   public float fireRate = 8;
   public boolean isAuto = false;
   public int bursts = 0;
   Timer burstTimer ;
   private int remainingBursts=1;
   public float accuracy = 70;
   
   
    Vector2f direction = new Vector2f();
    

    public Gun(Scene scene) {
        super(scene);
        int delay = (int) (1000/fireRate);
        shooTimer = new Timer(delay, doShoot);
        shooTimer.setRepeats(false);
        isAuto = true;
        bursts = 2;
    }
    
    private void releaseBullet(){
        float baseAngle = 45;
        float spread = baseAngle - baseAngle * (accuracy /100);
        double value  = Math.random() -0.5;
        double angle  = (value *2  ) * spread;
        Vector2f dir = direction.rotateAngle(angle);
        shootBullet(dir);
    }
    protected void shootBullet(Vector2f direction){
        scene.addProjectile(new Bullet(scene,damage ,position,direction , speed));
    }
    public void shoot(){
     if (shooTimer.isRunning()) return;
     if(!isAuto){
        if ( InputManager.isMouseFirstPressed("left mouse"))
            shooTimer.start();
     }else {
         if (InputManager.getMouseKeyPressed("left mouse"))
             shooTimer.start();
     }
     
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
    
    ActionListener doShoot = (e)-> { 
        releaseBullet();
        
        if (bursts > 1){
            
            remainingBursts = bursts -1;
            
            ActionListener  doBurst = (event) -> {
                
                remainingBursts --;
                releaseBullet();
                if (remainingBursts <=0)
                    burstTimer.stop();
            };
            
            burstTimer = new Timer(50, doBurst);
            burstTimer.start();
               
        }
    };
    
    Timer shooTimer;
    
    
}
