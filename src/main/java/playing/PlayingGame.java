package playing;

import gamestates.GamePanelInterface;
import playing.entities.PlayerLevelManager;
import playing.entities.player.PlayerManager;
import playing.levels.LevelManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static utilz.Constants.GameWindowConstants.*;

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
        calcLvlOffset();
    }

    private void calcLvlOffset() {
        maxLvlOffsetX = levelManager.getLvlOffsetX();
        maxLvlOffsetY = levelManager.getLvlOffsetY();
    }

    @Override
    public void update() {
        levelManager.update();
        playerManager.update();
        checkCloseToBorder();
    }

    private void checkCloseToBorder() {
        int playerX = playerManager.getPlayerX();
        int diffX = playerX - lvlOffsetX;

        if (diffX > RIGHT_BORDER) {
            lvlOffsetX += diffX - RIGHT_BORDER;
        } else if (diffX < LEFT_BORDER) {
            lvlOffsetX += diffX - LEFT_BORDER;
        }

        if (lvlOffsetX > maxLvlOffsetX) {
            lvlOffsetX = maxLvlOffsetX;
        } else if( lvlOffsetX < 0) {
            lvlOffsetX = 0;
        }


        int playerY = playerManager.getPlayerY();
        int diffY = playerY - lvlOffsetY;

        if (diffY > DOWN_BORDER) {
            lvlOffsetY += diffY - DOWN_BORDER;
        } else if (diffY < TOP_BORDER) {
            lvlOffsetY += diffY - TOP_BORDER;
        }

        if (lvlOffsetY > maxLvlOffsetY) {
            lvlOffsetY = maxLvlOffsetY;
        } else if( lvlOffsetY < 0) {
            lvlOffsetY = 0;
        }

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
