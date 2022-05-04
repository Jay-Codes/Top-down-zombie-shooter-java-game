/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gameobject.entities.zombies;

import java.awt.Graphics2D;
import javax.swing.Timer;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gameobject.entities.zombies.basic_zombies.GreenZombie;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.scene.Scene;

/**
 *
 * @author Jay
 */
public class SimpleZombieSpawner extends GameObject{
    public int spawnLimit = 200 , zombiesPerMinute = 10 ;
    private int currentSpawnedUnits;

    Timer zombieSpawner;
    public SimpleZombieSpawner(Scene scene) {
        super(scene);
    }

    
    @Override
    public void init() {
        zombieSpawner = new Timer((int)60000/zombiesPerMinute, e->{
            scene.addObject(new GreenZombie(scene,new Vector2f(80,80)));
            currentSpawnedUnits++;
            
        });
        zombieSpawner.setRepeats(true);
        zombieSpawner.start();
    }

    @Override
    public void update() {
        if ( currentSpawnedUnits >= spawnLimit && spawnLimit !=0 )
            stop();
    }
    
    public void stop(){
        zombieSpawner.stop();
    }
    @Override
    public void render(Graphics2D graphics) {}
    
}
