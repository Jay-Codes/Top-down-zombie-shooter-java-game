/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.scene;

import java.awt.Graphics2D;
import java.util.ArrayList;
import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.gfx.Camera;
import jaycodes.topdown.zombie.game.gfx.Renderer;
import jaycodes.topdown.zombie.game.main.TopdownZombieGame;
import jaycodes.topdown.zombie.game.math.Vector2f;

/**
 *
 * @author Jay
 */
public abstract class Scene extends GameObject{

    protected ArrayList<GameObject> gameObjects ;
    protected boolean hasBeenStarted = false;
    Camera camera;

    public Scene() {
        super();
        scene = this;
        gameObjects = new ArrayList<>();
        
    }
    
    
    public void startScene(){
        if(hasBeenStarted)
            return;
        camera = new Camera(new Vector2f(0, 0), TopdownZombieGame.width, TopdownZombieGame.height);
        renderer = new Renderer();
        renderer.setCamera(camera);
        
        init();
        camera.width=width;
        camera.height=height;
        for (int i = 0; i< gameObjects.size();i++){
            gameObjects.get(i).init();
        }
        hasBeenStarted=true;
    }
    
    public abstract void updateScene();

    @Override
    public void update() {
        updateScene();
        camera.update();
        for (int i = 0; i< gameObjects.size();i++){
            gameObjects.get(i).updateObject();
        }
            
    }

    public abstract  void drawScene(Graphics2D graphics);
    @Override
    public void render(Graphics2D graphics) {
        drawScene(graphics);
        for (int i = 0; i< gameObjects.size();i++){
            gameObjects.get(i).renderObject(graphics);
        }
    }
    
    protected abstract  void end();
    
    public void endScene(){
        end();
        gameObjects.clear();
        hasBeenStarted = false;
    }
    
    public void addObject(GameObject gameobject){
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
}
