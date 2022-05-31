/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gfx.ui;

import java.awt.Color;
import java.awt.Rectangle;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.input.InputManager;
import jaycodes.topdown.zombie.game.input.MouseInput;
import jaycodes.topdown.zombie.game.main.TopdownZombieGame;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.scene.Scene;

/**
 *
 * @author Jay
 */
public abstract class UIComponent extends GameObject{
    protected Color backGroundColor , textColor ,mouseHoverColor ,disabledColor ,currentBackgroundColor;
    protected Rectangle bounds;
    public UIComponent(Scene scene) {
        super(scene);
        backGroundColor = Color.GRAY;
        mouseHoverColor = backGroundColor.darker();
        disabledColor = new Color(223,223,223);
        currentBackgroundColor = backGroundColor;
    }
    

    @Override
    public void init() {
    }

    @Override
    public void update() {
        float xFactor = TopdownZombieGame.display.bufferWidth/(float)TopdownZombieGame.width ,yFactor = TopdownZombieGame.display.bufferHeight/TopdownZombieGame.height;
        currentBackgroundColor = backGroundColor;
        if (disabled) currentBackgroundColor = disabledColor;
        float mX = InputManager.getMouseX() , mY = InputManager.getMouseY();
        Vector2f pos = getOnScreenUICoordinates();
        bounds =  new Rectangle((int)( pos.x),(int)(pos.y ),(int)(width * xFactor),(int)(height*yFactor));
        if (bounds.contains(mX, mY)){
            currentBackgroundColor = mouseHoverColor;
            mouseHover();
            if(MouseInput.isPressed)
                mousePressed();
        }
    }
    
    protected abstract void mouseHover();
    protected abstract void mousePressed();
}
