/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.scene;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jaycodes.topdown.zombie.game.gfx.Camera;
import jaycodes.topdown.zombie.game.gfx.ui.UIButton;
import jaycodes.topdown.zombie.game.input.InputManager;
import jaycodes.topdown.zombie.game.main.TopdownZombieGame;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.utilities.Util;

/**
 *
 * @author Jay
 */
public class WelcomeScene extends Scene{

    public WelcomeScene() {
        super();
        name = "welcomescreen";
    }
    
    
    @Override
    public void drawScene(Graphics2D graphics) {
        graphics.drawImage(sprite, 0, 0,640,480, null);
    }

    @Override
    public void end() {
    }

    @Override
    public void init() {
        camera = new Camera(new Vector2f(300, 300), TopdownZombieGame.width, TopdownZombieGame.height);
        try {
            sprite = Util.loadImageFromFile("resources/images/loadingscreens/welcomescreen.jpg");
        } catch (IOException ex) {
            Logger.getLogger(WelcomeScene.class.getName()).log(Level.SEVERE, null, ex);
        }
        UIButton  btn =  new UIButton(scene);
         uiManager.addUIComponent(btn);
    }

    @Override
    public void updateScene() {
        
        if(InputManager.getKeyPressed("enter")){
            SceneManager.startScene("Game Play Scene");
        }
    }
    
}
