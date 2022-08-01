package playing.entities.player;

import playing.PlayingDrawInterface;
import playing.PlayingKeyListenerInterface;
import playing.PlayingMouseListenerInterface;
import playing.PlayingUpdateInterface;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Player implements PlayingUpdateInterface, PlayingDrawInterface,
        PlayingMouseListenerInterface, PlayingKeyListenerInterface {

    private PlayerManager playerManager;

    private PlayerModuleManager playerModuleManager;

    public Player(PlayerManager playerManager) {
        this.playerManager = playerManager;
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

    public boolean IsPlayerOnFloor(Rectangle2D.Double hitBox) {
        return playerManager.IsPlayerOnFloor(hitBox);
    }
    public boolean CanMoveHere(Rectangle2D.Double hitBox) {
        return playerManager.CanMoveHere(hitBox);
    }
}
