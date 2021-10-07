/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.gfx.animations;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 *
 * @author Jay
 */
public class AnimationController {
    private HashMap<String, Animation> animations;
    public Animation currenAnimation;

    public AnimationController(Animation [] anim_arr) {
        animations = new HashMap<String, Animation>();
        for(Animation anim : anim_arr)
            animations.put(anim.name, anim);
        setAnimation(anim_arr[0].name);
    }
    
    
    
   public Animation getAnimation(String animationName){
       return animations.get(animationName);
   }
   
   public void setAnimation(String animName){
       currenAnimation = animations.get(animName);
       currenAnimation.reset();
   }
   
   public BufferedImage getFrame(){
       return currenAnimation.getCurrentFrame();
   }

    public void update() {
       currenAnimation.update();
    }
}
