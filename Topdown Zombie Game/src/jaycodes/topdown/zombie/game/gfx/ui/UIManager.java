/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gfx.ui;

import java.awt.Graphics2D;
import java.util.ArrayList;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.scene.Scene;

/**
 *
 * @author Jay
 */
public class UIManager extends GameObject{
    
    ArrayList<UIComponent> uiComponents ;

    public UIManager(Scene scene) {
        super(scene);
        init();
    }
    
    
    @Override
    public void init() {
        uiComponents = new ArrayList<>();
    }

    @Override
    public void update() {
        for (UIComponent uiComponent : uiComponents) {
            uiComponent.updateObject();
        }
    }

    @Override
    public void render(Graphics2D graphics) {
        for (UIComponent uiComponent : uiComponents){
            uiComponent.renderObject(graphics);
        }
    }
    
    public void addUIComponent(UIComponent component){
        component.initObject();
        uiComponents.add(component);
    }
    public void removeUICOmponent(UIComponent component){
        uiComponents.remove(component);
    }
}
