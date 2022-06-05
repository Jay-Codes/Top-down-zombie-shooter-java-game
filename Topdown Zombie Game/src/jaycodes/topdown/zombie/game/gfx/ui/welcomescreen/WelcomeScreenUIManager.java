/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaycodes.topdown.zombie.game.gfx.ui.welcomescreen;

import jaycodes.topdown.zombie.game.gfx.ui.UIComponent;
import jaycodes.topdown.zombie.game.gfx.ui.UIManager;
import jaycodes.topdown.zombie.game.scene.Scene;

/**
 *
 * @author Jay
 */
public class WelcomeScreenUIManager extends UIManager{
    
    UIComponent play ,settings ,quit;

    public WelcomeScreenUIManager(Scene scene) {
        super(scene);
        play = new PlayBtn(scene);
        settings = new SettingsBtn(scene);
        quit = new quitBtn(scene);
        addUIComponent(play);
        addUIComponent(settings);
        addUIComponent(quit);
    }
}
