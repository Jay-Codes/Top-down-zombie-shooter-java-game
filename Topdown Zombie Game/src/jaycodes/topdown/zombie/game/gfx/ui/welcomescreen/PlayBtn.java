/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gfx.ui.welcomescreen;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jaycodes.topdown.zombie.game.gfx.ui.UIComponent;
import jaycodes.topdown.zombie.game.scene.Scene;
import jaycodes.topdown.zombie.game.scene.SceneManager;
import jaycodes.topdown.zombie.game.scene.WelcomeScene;
import jaycodes.topdown.zombie.game.utilities.Util;

/**
 *
 * @author Jay
 */
public class PlayBtn extends  UIComponent{
    
    BufferedImage currImage , bgImage , hvrImage;

    public PlayBtn(Scene scene) {
        super(scene);
        width = 156;
        height = 66;
        position.x = 352;
        position.y = 189;
    }
    
    @Override
    public void init(){
        super.init();
        try {
            bgImage = Util.loadImageFromFile("resources/images/ui/Home/playbtn.png");
            hvrImage = Util.loadImageFromFile("resources/images/ui/Home/playbtnhvr.png");
            currImage = bgImage;
        } catch (IOException ex) {
            Logger.getLogger(WelcomeScene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    protected void mouseHover() {
        currImage = hvrImage;
    }
    
    @Override
    public void update(){
        currImage = bgImage;
        super.update();
    }

    @Override
    protected void mousePressed() {
        SceneManager.startScene("Game Play Scene");
    }

    @Override
    public void render(Graphics2D graphics) {
        renderer.drawImageOnScreen(graphics, position, width, height, currImage);
    }
    
}
