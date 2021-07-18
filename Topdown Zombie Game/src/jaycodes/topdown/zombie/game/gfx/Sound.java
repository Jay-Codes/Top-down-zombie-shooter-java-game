/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gfx;

import javax.sound.sampled.Clip;

/**
 *
 * @author Jay
 */
public class Sound {
    
    Clip clip ;
    
    public Sound(Clip clip){
        this.clip = clip;
    }
    
    public void playSound(){
        clip.start();
    }
    public void stopSound(){
        clip.stop();
    }
    
    public void setRepeat(boolean shouldRepeat){
        if(shouldRepeat){
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }else
            clip.loop(0);
    }
}
