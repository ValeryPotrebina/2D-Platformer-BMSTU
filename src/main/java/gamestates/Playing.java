package gamestates;

import gamestates.playingstates.*;
import playing.entities.PlayerManager;
import playing.levels.LevelManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing implements GamePanelInterface, GamePanelListenerInterface {


    private OverlayManager overlayManager;
    private LevelManager levelManager;
    private PlayerManager playerManager;


    private int lvlOffsetX, lvlOffsetY;
    private int maxLvlOffsetX, maxLvlOffsetY;

    public Playing() {
        initClasses();
    }

    private void initClasses() {
        overlayManager = new OverlayManager(this);
        levelManager = new LevelManager();
        playerManager = new PlayerManager(this);
    }

    @Override
    public void update() {
        overlayManager.update();
        levelManager.update();
        playerManager.update();
    }

    @Override
    public void draw(Graphics g, float scale) {
        overlayManager.draw(g, scale);
        levelManager.draw(g, scale, lvlOffsetX, lvlOffsetY);
        playerManager.draw(g, scale, lvlOffsetX, lvlOffsetY);
    }

    @Override
    public void mouseClicked(MouseEvent e, float scale) {
        overlayManager.mouseClicked(e, scale);
        playerManager.mouseClicked(e, scale);
    }

    @Override
    public void mousePressed(MouseEvent e, float scale) {
        overlayManager.mousePressed(e, scale);
        playerManager.mousePressed(e, scale);
    }

    @Override
    public void mouseReleased(MouseEvent e, float scale) {
        overlayManager.mouseReleased(e, scale);
        playerManager.mouseReleased(e, scale);
    }

    @Override
    public void mouseDragged(MouseEvent e, float scale) {
        overlayManager.mouseDragged(e, scale);
        playerManager.mouseDragged(e, scale);
    }

    @Override
    public void mouseMoved(MouseEvent e, float scale) {
        overlayManager.mouseMoved(e, scale);
        playerManager.mouseMoved(e, scale);
    }

    @Override
    public void keyPressed(KeyEvent e, float scale) {
        overlayManager.keyPressed(e, scale);
        playerManager.keyPressed(e, scale);
    }

    @Override
    public void keyReleased(KeyEvent e, float scale) {
        overlayManager.keyReleased(e, scale);
        playerManager.keyReleased(e, scale);
    }

    public void resetAll() {
        overlayManager.resetAll();
        playerManager.resetAll();
    }
}
