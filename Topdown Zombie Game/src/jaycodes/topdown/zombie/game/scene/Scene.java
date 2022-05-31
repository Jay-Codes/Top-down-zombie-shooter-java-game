/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.scene;

import java.awt.Graphics2D;
import java.util.ArrayList;
import jaycodes.topdown.zombie.game.gameobject.Collider;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gameobject.projectiles.Projectile;
import jaycodes.topdown.zombie.game.gfx.Camera;
import jaycodes.topdown.zombie.game.gfx.Renderer;
import jaycodes.topdown.zombie.game.gfx.ui.UIButton;
import jaycodes.topdown.zombie.game.gfx.ui.UIManager;
import jaycodes.topdown.zombie.game.main.TopdownZombieGame;
import jaycodes.topdown.zombie.game.math.Vector2f;

/**
 *
 * @author Jay
 */
public abstract class Scene extends GameObject{

    protected ArrayList<GameObject> gameObjects ;
    protected  ArrayList<Collider> colliders ;
    protected  ArrayList<Projectile> projectiles ;
    protected UIManager uiManager;
    
    protected boolean hasBeenStarted = false;
    Camera camera;

    public Scene() {
        super();
        scene = this;
        gameObjects = new ArrayList<>();
        colliders =  new ArrayList<Collider>();
        projectiles = new ArrayList<Projectile>();
    }
    
    
    public void startScene(){
        if(hasBeenStarted)
            return;
        camera = new Camera(new Vector2f(0, 0), TopdownZombieGame.width, TopdownZombieGame.height);
        renderer = new Renderer();
        renderer.setCamera(camera);
        uiManager = new UIManager(this);
        init();
        camera.width=width;
        camera.height=height;
        hasBeenStarted=true;
    }
    
    public abstract void updateScene();

    @Override
    public void update() {
        uiManager.updateObject();
        updateScene();
        camera.update();
        for (int i = 0; i< gameObjects.size();i++){
            gameObjects.get(i).updateObject();
        }
        for (int i = 0; i< projectiles.size();i++){
            projectiles.get(i).updateObject();
        }
            
    }

    public abstract  void drawScene(Graphics2D graphics);
    @Override
    public void render(Graphics2D graphics) {
        drawScene(graphics);
        for (int i = 0; i< gameObjects.size();i++){
            gameObjects.get(i).renderObject(graphics);
        }
        for (int i = 0; i< projectiles.size();i++){
            projectiles.get(i).renderObject(graphics);
        }
        uiManager.renderObject(graphics);
    }
    
    protected abstract  void end();
    
    public void endScene(){
        end();
        gameObjects.clear();
        hasBeenStarted = false;
    }
    
    public void addObject(GameObject gameobject){
        gameobject.initObject();
        gameObjects.add(gameobject);
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
        camera.width=width;
        camera.height=height;
    }
    
    public GameObject getGameObjectByName(String name){
        GameObject temp=null;
        for (GameObject gameObject : gameObjects) {
            if(gameObject.getName().equals(name))
                temp = gameObject;
        }
        return temp;
    }

    public ArrayList<Collider> getColliders() {
        return colliders;
    }
    
    public void addCollider(Collider collider){
        colliders.add(collider);
    }
    
    public void  removeCollider(Collider collider){
        colliders.remove(collider);
    }
    
    public void addProjectile(Projectile projectile){
        projectiles.add(projectile);
    }
    
    public void  removeProjectile(Projectile projectile){
        projectiles.remove(projectile);
    }
}
