/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaycodes.topdown.zombie.game.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Jay
 */
public class Util {
    
    public static BufferedImage loadImageFromFile(String path) throws IOException{
        BufferedImage img = ImageIO.read(new File (path));
        return img;
    }
    
    public static BufferedImage loadImageFromClass(String path) throws IOException{
        BufferedImage img = ImageIO.read(Util.class.getResourceAsStream("/"+path));
        return img;
    }
    
    public static Clip loadSoundFromFile(String path) throws LineUnavailableException, UnsupportedAudioFileException, IOException{
        Clip c  = AudioSystem.getClip();
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(path));
        c.open(audioInput);
        return c;
    }
    public static Clip loadSoundFromClass(String path) throws LineUnavailableException, UnsupportedAudioFileException, IOException{
        Clip c  = AudioSystem.getClip();
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(Util.class.getResourceAsStream("/"+path));
        c.open(audioInput);
        return c;
    }
}
