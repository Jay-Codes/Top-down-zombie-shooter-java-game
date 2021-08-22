/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gfx.animations;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jay
 */
public class Animation {
    public String name;
    BufferedImage [] frames;
    float duration; // in seconds
    float index = 0;
    float sleeptime =0;
    
    long now =0 , passed =0;

    public Animation(BufferedImage[] frames, float duration) {
        this.frames = frames;
        this.duration = duration*1000;
        sleeptime = this.duration/frames.length;
        passed = System.currentTimeMillis();
    }
    public Animation(BufferedImage[] frames, float duration,String name) {
        this.frames = frames;
        this.duration = duration*1000;
        sleeptime = this.duration/frames.length;
        passed = System.currentTimeMillis();
        this.name=name;
    }
    
    public void setFPS(int fps){
        sleeptime = 1000/fps;
    }
    public void update(){
        now = System.currentTimeMillis();
        if(!(now-passed>= sleeptime))
                return;
        
        
        if(index >=frames.length-1)
            index=0;
        
        index ++;
        passed = now;
        
    }
    
    public BufferedImage getCurrentFrame(){
        return  frames[(int)index];
    }
    
    public void reset(){
        index=0;
    }
}
