package playing;

import gamestates.GamePanelInterface;
import playing.entities.PlayerLevelManager;
import playing.entities.player.PlayerManager;
import playing.levels.LevelManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PlayingGame implements GamePanelInterface,
        PlayingMouseListenerInterface, PlayingKeyListenerInterface{

    private LevelManager levelManager;
    private PlayerManager playerManager;
    private PlayerLevelManager playerLevelManager;

    private int lvlOffsetX, lvlOffsetY;
    private int maxLvlOffsetX, maxLvlOffsetY;

    public PlayingGame() {
        initClasses();
    }

    private void initClasses() {
        playerLevelManager = new PlayerLevelManager(this);
        levelManager = new LevelManager(playerLevelManager);
        playerManager = new PlayerManager(playerLevelManager);
    }

    @Override
    public void update() {
        levelManager.update();
        playerManager.update();
    }

    @Override
    public void draw(Graphics g, float scale) {
        levelManager.draw(g, scale, lvlOffsetX, lvlOffsetY);
        playerManager.draw(g, scale, lvlOffsetX, lvlOffsetY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        playerManager.mouseClicked(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        playerManager.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        playerManager.keyReleased(e);
    }

    public void resetAll() {
        playerManager.resetAll();
    }

    public LevelManager getLevelManager() {
        return levelManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
