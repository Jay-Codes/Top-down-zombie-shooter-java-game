/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gfx;

import jaycodes.topdown.zombie.game.gameobject.GameObject;
import jaycodes.topdown.zombie.game.math.Vector2f;



/**
 *
 * @author Jay
 */
public class Camera {
    public Vector2f position;
    public float vpWidth,vpHeight;
    public float width ,height;

    public Camera(Vector2f position, float vpWidth, float vpHeight) {
        this.position = position;
        this.vpWidth = vpWidth;
        this.vpHeight = vpHeight;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public void setVpWidth(float vpWidth) {
        this.vpWidth = vpWidth;
    }

    public void setVpHeight(float vpHeight) {
        this.vpHeight = vpHeight;
    }

    public Vector2f getPosition() {
        return position;
    }
    
    public void update(){
//        if(InputManager.getKeyPressed("w"))
//            position.y--;
//        if(InputManager.getKeyPressed("s"))
//            position.y++;
//        if(InputManager.getKeyPressed("a"))
//            position.x--;
//        if(InputManager.getKeyPressed("d"))
//            position.x++;
    }
    
    public void centerOnGameObject(GameObject object){
        position = object.getPosition().clone();
        removeBlackSpaces();
    }
    
    private void removeBlackSpaces(){
        float halfWidth = width/2 ,halfHeight = height /2;
        //left side
        if(position.x < -halfWidth + vpWidth/2)
            position.x = -halfWidth + vpWidth/2;
        
        //top side
        if(position.y < -halfHeight + vpHeight/2)
            position.y = -halfHeight + vpHeight/2;
        
        //right side
        if(position.x > halfWidth - vpWidth/2)
            position.x = halfWidth - vpWidth/2;
        
        //bottom side
        if(position.y > halfHeight - vpHeight/2)
            position.y = halfHeight - vpHeight/2;
    }
}
