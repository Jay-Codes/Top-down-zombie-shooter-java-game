/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.math;

/**
 *
 * @author Jay
 */
public class Vector2f {
    
    public float x ,y;
    
    public Vector2f(){
        x = 0;
        y = 0;
    }
    
    public Vector2f(float x , float y){
        this.x = x;
        this.y = y;
    }
    
    public Vector2f add(Vector2f a){
        return  new Vector2f(x+a.x,y+a.y);
    }
    
    public Vector2f sub(Vector2f a){
        return  new Vector2f(x-a.x,y-a.y);
    }
    
    public Vector2f scale(float scale){
        return  new Vector2f(x*scale,y*scale);
    }
    
    public Vector2f div(float value){
        return  new Vector2f(x/value,y/value);
    }
    
    public float getLength(){
        return (float) Math.sqrt(x*x +y*y);
    }
    
    public float distance(Vector2f b){
        return sub(b).getLength();
    }
    
    public Vector2f normailize(){
        return div(getLength());
    }
    
    public boolean isZero(){
        return getLength()== 0;
    }
    
    @Override
    public String toString(){
        return " x : "+x +" y :"+y;
    }
    
    public Vector2f clone(){
        return  new Vector2f(x, y);
    }
}

