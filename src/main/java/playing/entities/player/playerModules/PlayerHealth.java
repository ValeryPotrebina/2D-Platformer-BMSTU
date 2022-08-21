package playing.entities.player.playerModules;
import gamestates.Playing;
import playing.PlayingDrawInterface;
import playing.PlayingUpdateInterface;
import playing.entities.player.PlayerModuleManager;
import utilz.LoadSave;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.TextureConstants.Health.HEALTH_BAR;
import static utilz.Constants.TextureConstants.Health.HEALTH_LOCATION_BAR;
import static utilz.Constants.TextureConstants.Menu.MENU_BUTTONS_PNG;
import static utilz.Constants.TextureConstants.Menu.MENU_LOCATION_TEXTURES;

public class PlayerHealth extends PlayerModule implements PlayingUpdateInterface, PlayingDrawInterface {

    private BufferedImage image;

    private int healthBarWidth = 150;
    private int healthBarHeigth = 4;
    private int healthBarXStart = 34;
    private int healthBarYStart = 14;

    private int statusBarWidth = 192;
    private int statusBarHeight = 58;
    private int statusBarX = 10;
    private int statusBarY = 10;


    private int maxHealth = 100;
    private int currentHealth = 40;
    private int healthWidth = healthBarWidth;


    public PlayerHealth(PlayerModuleManager playerModuleManager) {
        super(playerModuleManager);
        loadImage();
    }


    @Override
    public void update() {
        updateHealthBar();
    }

    private void updateHealthBar() {
        healthWidth = (int)((currentHealth/(float)maxHealth)*healthBarWidth);
    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        drawHealthBox(g, scale, lvlOffsetX, lvlOffsetY);
    }

    private void drawHealthBox(Graphics g, float scale, int LvlOffsetX, int LvlOffsetY){
        //g.fillRect((int) (healthBarX*scale), (int) (healthBarY*scale), (int) (healthBarWidth*scale/2), (int) (healthBarHeigth*scale)/2);
        //g.drawImage(image, (int) (healthBarXStart*scale), (int) (healthBarYStart*scale), (int) (healthBarWidth*scale), (int) (healthBarHeigth*scale), null);
        g.drawImage(image, statusBarX, statusBarY, statusBarWidth, statusBarHeight, null);
        g.setColor(Color.red);
        g.fillRect(healthBarXStart + statusBarX, healthBarYStart + statusBarY, healthWidth, healthBarHeigth);

    }

    private void loadImage(){
         image = LoadSave.GetSpriteAtlas(HEALTH_LOCATION_BAR, HEALTH_BAR);
    }

    public void increaseHealth(int value){
        currentHealth += Math.abs(value);
        if (currentHealth >= maxHealth){
            currentHealth = maxHealth;
        }
    }

    public void decreaseHealth(int value){
        currentHealth -= Math.abs(value);
        if (currentHealth <= 0) {
            currentHealth = 0;
        }
    }


}
