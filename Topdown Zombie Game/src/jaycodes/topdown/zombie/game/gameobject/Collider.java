/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gameobject;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.List;

/**
 *
 * @author jay
 */
public class Collider extends Component{
    CollisionListener listener;
    public Collider(GameObject gameObject, CollisionListener cl) {
        super(gameObject);
        listener = cl;
    }

    
    @Override
    public void update() {
        List <Collider> colliders = gameObject.scene.getColliders();
        for (int i = 0; i < colliders.size(); i++) 
            if( colliders.get(i)!= this && getBounds().intersects(colliders.get(i).getBounds()))
                listener.onCollision(colliders.get(i).gameObject);
    }
    
    

    @Override
    public void render(Graphics2D g) {
        gameObject.renderer.drawRect(g, gameObject.position, (int)gameObject.width/2,(int) gameObject.height/2);
    }
    
    public Rectangle getBounds(){
        return  new Rectangle((int)gameObject.position.x,(int)gameObject.position.y,
                (int)(gameObject.width/2),(int)(gameObject.height/2));
    }
}
