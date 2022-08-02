package playing;

import gamestates.GamePanelInterface;
import playing.entities.PlayerLevelManager;
import playing.entities.player.PlayerManager;
import playing.levels.LevelManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static utilz.Constants.GameWindowConstants.GAME_HEIGHT_DEFAULT;
import static utilz.Constants.GameWindowConstants.GAME_WIDTH_DEFAULT;

public class PlayingGame implements GamePanelInterface,
        PlayingMouseListenerInterface, PlayingKeyListenerInterface{

    private LevelManager levelManager;
    private PlayerManager playerManager;
    private PlayerLevelManager playerLevelManager;

    private int lvlOffsetX, lvlOffsetY;
    private int maxLvlOffsetX, maxLvlOffsetY;
    private final int leftBorder = (int) (0.2 * GAME_WIDTH_DEFAULT);
    private final int rightBorder = (int) (0.8 * GAME_WIDTH_DEFAULT);
    private final int topBorder = (int) (0.2 * GAME_HEIGHT_DEFAULT);
    private final int downBorder = (int) (0.8 * GAME_HEIGHT_DEFAULT);

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

        if (diffX > rightBorder) {
            lvlOffsetX += diffX - rightBorder;
        } else if (diffX < leftBorder) {
            lvlOffsetX += diffX - leftBorder;
        }

        if (lvlOffsetX > maxLvlOffsetX) {
            lvlOffsetX = maxLvlOffsetX;
        } else if( lvlOffsetX < 0) {
            lvlOffsetX = 0;
        }


        int playerY = playerManager.getPlayerY();
        int diffY = playerY - lvlOffsetY;

        if (diffY > downBorder) {
            lvlOffsetY += diffY - downBorder;
        } else if (diffY < topBorder) {
            lvlOffsetY += diffY - topBorder;
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
