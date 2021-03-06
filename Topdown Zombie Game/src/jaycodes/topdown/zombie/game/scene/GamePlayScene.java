/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.scene;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gameobject.entities.Player;
import jaycodes.topdown.zombie.game.gameobject.entities.zombies.SimpleZombieSpawner;
import jaycodes.topdown.zombie.game.gameobject.projectiles.Projectile;
import jaycodes.topdown.zombie.game.gfx.Sound;
import jaycodes.topdown.zombie.game.gfx.ui.UIButton;
import jaycodes.topdown.zombie.game.input.InputManager;
import jaycodes.topdown.zombie.game.main.GameManager;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.utilities.Util;

/**
 *
 * @author Jay
 */
public class GamePlayScene extends Scene{
    
    BufferedImage map ;
    Sound main;
    GameObject cameraTarget;
    ArrayList<Projectile> projectiles ;
    
    public GamePlayScene() {
        super();
        name = "Game Play Scene";
        projectiles = new ArrayList<Projectile>();
    }

    @Override
    public void startScene(){
        super.startScene();
        main.playSound();
    }
    

    @Override
    public void init() {
        
        
        
        try {
            
            map = Util.loadImageFromFile("resources/images/maps/test2.jpg");
            width = map .getWidth();
            height = map.getHeight();
        } catch (IOException ex) {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //Initiialze sounds

            main = new Sound(Util.loadSoundFromFile("resources/sounds/mainmenusound/ambientsound.wav"));
            main.setRepeat(true);
        } catch (Exception ex) {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
         addObject(new Player(this,new Vector2f(0,0)));
//         addObject(new GreenZombie(this,new Vector2f(80,80)));
         addObject(new SimpleZombieSpawner(this));
         
         cameraTarget = getGameObjectByName("player");
         
    }
    @Override
    public void updateScene() {
        
        camera.centerOnGameObject(cameraTarget);
        if(InputManager.getKeyPressed("escape")){
            SceneManager.startScene("welcomescreen");
        }
        for (int i =0 ; i < projectiles.size() ; i++)
            projectiles.get(i).updateObject();
    }
    
    @Override
    public void end() {
//        init();
    }

    @Override
    public void drawScene(Graphics2D graphics) {
        renderer.drawImage(map, graphics, position,0,width,height);
        for (int i =0 ; i < projectiles.size() ; i++)
            projectiles.get(i).renderObject(graphics);
    }

    public Player GetPlayer(){
        for (GameObject gobj :gameObjects)
            if(gobj instanceof Player) return  (Player) gobj;
        
        return null;
    }
    public void  addProjectile(Projectile projectile){
        projectiles.add(projectile);
    }
    public void  removeProjectile(Projectile projectile){
        projectiles.remove(projectile);
    }
}
