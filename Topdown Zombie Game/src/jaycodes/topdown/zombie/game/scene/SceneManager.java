/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.scene;

import java.util.ArrayList;

/**
 *
 * @author Jay
 */
public class SceneManager {
    public static Scene currentScene;
    public static ArrayList<Scene> allScenes = new ArrayList<>();
    
    public static void initialize(){
        allScenes.add(new WelcomeScene());
        allScenes.add(new GamePlayScene());
    }
    
    public static void addScene(Scene scene){
        allScenes.add(scene);
    }
    
    public static void startScene(String scenename){
        for(int i =0 ; i < allScenes.size();i++){
            Scene temp = allScenes.get(i);
            if(temp.getName().equals(scenename)){
                if(currentScene!= null)
                    currentScene.endScene();
                
                currentScene = temp;
                
                if(currentScene.getName().equals("Game Play Scene"))
                    currentScene = new GamePlayScene();
                else if (currentScene.getName().equals("welcomescreen"))
                    currentScene = new WelcomeScene();
                currentScene.startScene();
                
            }
        }
    }

    public static Scene getCurrentScene() {
        return currentScene;
    }
}
