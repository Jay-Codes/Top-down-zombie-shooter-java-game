/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gfx.ui;

import java.awt.Graphics2D;
import jaycodes.topdown.zombie.game.scene.Scene;

/**
 *
 * @author Jay
 */
public class UIButton extends UIComponent{

    public UIButton(Scene scene) {
        super(scene);
        width = 200;
        height =80;
        position.x =50;
        position.y =100;
    }
    
    

    @Override
    protected void mouseHover() {
    }

    @Override
    protected void mousePressed() {
    }

    @Override
    public void render(Graphics2D graphics) {
        graphics.setColor(currentBackgroundColor);
        renderer.fillRectOnScreen(graphics, position,(int) width, (int) height);
    }
    
}
