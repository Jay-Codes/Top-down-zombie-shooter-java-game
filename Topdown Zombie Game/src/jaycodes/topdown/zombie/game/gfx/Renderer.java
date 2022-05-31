/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gfx;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import jaycodes.topdown.zombie.game.math.Vector2f;

/**
 *
 * @author Jay
 */
public class  Renderer {
    
    public Camera camera;
    public AffineTransform transform;
    public float xoffset = 0 , yoffset = 0;

    public Renderer() {
        transform = new AffineTransform();
    }
    
    
    public void drawRect(Graphics2D g,Vector2f position , int width , int height){
        xoffset  = (position.x - camera.position.x+camera.vpWidth/2)   - width/2;
        yoffset  = (position.y - camera.position.y+camera.vpHeight/2)  - height/2;
        transform = AffineTransform.getTranslateInstance(xoffset, yoffset);
        g.setTransform(transform);
        g.drawRect(0,0,width,height);
        g.setTransform(new AffineTransform());
    }
    
    public void fillRect(Graphics2D g,Vector2f position , int width , int height){
        xoffset  = (position.x - camera.position.x+camera.vpWidth/2)   - width/2;
        yoffset  = (position.y - camera.position.y+camera.vpHeight/2)  - height/2;
        transform = AffineTransform.getTranslateInstance(xoffset, yoffset);
        g.setTransform(transform);
        g.fillRect(0,0,width,height);
        g.setTransform(new AffineTransform());
    }
    
    public void fillRectOnScreen(Graphics2D g,Vector2f position , int width , int height){
        xoffset  = (position.x )   ;
        yoffset  = (position.y )  ;
        transform = AffineTransform.getTranslateInstance(xoffset, yoffset);
        g.setTransform(transform);
        g.fillRect(0,0,width,height);
        g.setTransform(new AffineTransform());
    }
    
    public void drawImage(BufferedImage image ,Graphics2D g2d, Vector2f position,float rotation, float width, float height){

        xoffset  = (position.x - camera.position.x+camera.vpWidth/2)   - width/2;
        yoffset  = (position.y - camera.position.y+camera.vpHeight/2)  - height/2;
        
        transform = AffineTransform.getTranslateInstance(xoffset, yoffset);
        
        
        transform .rotate(rotation, width/2, height/2);
        
        g2d.setTransform(transform);
        g2d.drawImage(image, 0, 0,(int) width, (int)height, null);
        g2d.setTransform(new AffineTransform());
    }
    
    public Renderer(Camera camera) {
        this.camera = camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
    
    
    public Camera getCamera() {
        return camera;
    }
    
    
    
}
