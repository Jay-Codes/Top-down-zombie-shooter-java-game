/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gameobject;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import jaycodes.topdown.zombie.game.gfx.Camera;
import jaycodes.topdown.zombie.game.gfx.Renderer;
import jaycodes.topdown.zombie.game.main.TopdownZombieGame;
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
    protected ArrayList<Component> components = new ArrayList<Component>();
    protected boolean disabled = false;
    

    
    
    public GameObject(Scene scene){
        this.scene = scene;
        position = new Vector2f();
        transform = new AffineTransform();
        width = height = 50f;
        renderer = new Renderer();
        renderer.setCamera(scene.getCamera());
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
    public void initObject(){
        init();
        for (Component component: components)
            if(component instanceof Collider)
                scene.addCollider((Collider)component);
    }
    public abstract void update();
    public abstract void render(Graphics2D graphics);
    
    public void updateObject()
    {
        if (disabled)return;
        update();
        for (Component component : components)component.updateComponent();
    }
    public void renderObject(Graphics2D graphics){
        if (disabled) return;
        render(graphics);
        for (Component component : components) component.renderComponent(graphics);
    }
    
    
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
    
    public void addComponent(Component component){
        components.add(component);
    }
    
    public void addCollider(Collider collider){
            scene.addCollider(collider);
    }
    public void removeComponent(Component component){
        components.remove(component);
    }

    public ArrayList<Component> getComponents() {
        return components;
    }
    
    public Vector2f getOnScreenCoordinates(){
        Camera camera = renderer.camera;
        float xoffset  = (position.x - camera.position.x+camera.vpWidth/2)   ;
        float yoffset  = (position.y - camera.position.y+camera.vpHeight/2)  ;
        xoffset = (xoffset/TopdownZombieGame.width)*TopdownZombieGame.display.bufferWidth + TopdownZombieGame.display.xPos;
        yoffset =  (yoffset/TopdownZombieGame.height)*TopdownZombieGame.display.bufferHeight;
        return  new Vector2f(xoffset, yoffset);
    }

    public Vector2f getOnScreenUICoordinates(){
        float xoffset  = (position.x )  ;
        float yoffset  = (position.y )  ;
        xoffset = (xoffset/TopdownZombieGame.width)*TopdownZombieGame.display.bufferWidth + TopdownZombieGame.display.xPos;
        yoffset =  (yoffset/TopdownZombieGame.height)*TopdownZombieGame.display.bufferHeight;
        return  new Vector2f(xoffset, yoffset);
    }
    
    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    
}
