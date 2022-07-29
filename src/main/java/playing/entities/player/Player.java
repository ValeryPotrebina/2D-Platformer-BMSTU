package playing.entities.player;

import playing.PlayingDrawInterface;
import playing.PlayingKeyListenerInterface;
import playing.PlayingMouseListenerInterface;
import playing.PlayingUpdateInterface;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Player implements PlayingUpdateInterface, PlayingDrawInterface,
        PlayingMouseListenerInterface, PlayingKeyListenerInterface {


    private PlayerModuleManager playerModuleManager;

    public Player() {
        initClasses();
    }

    private void initClasses() {
        playerModuleManager = new PlayerModuleManager(this);
    }

    @Override
    public void update() {
        playerModuleManager.update();
    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        playerModuleManager.draw(g, scale, lvlOffsetX, lvlOffsetY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        playerModuleManager.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        playerModuleManager.keyReleased(e);
    }

    public void resetAll() {
        playerModuleManager.resetAll();
    }

    public PlayerModuleManager getPlayerModulesManager() {
        return playerModuleManager;
    }


}
