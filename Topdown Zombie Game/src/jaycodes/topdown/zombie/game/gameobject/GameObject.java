/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gameobject;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import jaycodes.topdown.zombie.game.gfx.Renderer;
import jaycodes.topdown.zombie.game.math.Vector2f;
import jaycodes.topdown.zombie.game.scene.Scene;

/**
 *
 * @author Jay
 */
public abstract class GameObject {
    protected Vector2f position;
    protected AffineTransform transform;
    protected float width , height;
    protected float rotationAngle;
    protected BufferedImage sprite ;
    protected String name = "";
    protected Renderer renderer;
    protected Scene scene;

    
    
    public GameObject(Scene scene){
        this.scene = scene;
        position = new Vector2f();
        transform = new AffineTransform();
        width = height = 50f;
    }
    
    public GameObject(){
        position = new Vector2f();
        transform = new AffineTransform();
        width = height = 50f;
    }
    
    public GameObject(Scene scene,Vector2f  position ,float width ,float height){
        this.scene = scene;
        this.position = position;
        transform = new AffineTransform();
        this.width = width;
        this.height = height;
        renderer = new Renderer();
        renderer.setCamera(scene.getCamera());
    }

    public abstract void init();
    public abstract void update();
    public abstract void render(Graphics2D graphics);
    
    public Vector2f getPosition() {
        return position;
    }

    public AffineTransform getTransform() {
        return transform;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRotationAngle() {
        return rotationAngle;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public String getName() {
        return name;
    }

    public Scene getScene() {
        return scene;
    }
    
    
}
