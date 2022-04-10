/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gameobject;

import java.awt.Graphics2D;

/**
 *
 * @author jay
 */
public abstract class Component {
    public GameObject gameObject;
    public boolean isActive = true;
    public boolean shouldRender = false;

    public Component(GameObject gameObject) {
        this.gameObject = gameObject;
    }
    
    public void updateComponent(){
       if(!isActive)
           return;
        update();
    }
    
    public void renderComponent(Graphics2D g){
        if(!isActive)
           return;
        if(!shouldRender)return;
        System.out.println(shouldRender);
        render(g);
    }
    
    public abstract void update();
    public abstract void render(Graphics2D g);
}
