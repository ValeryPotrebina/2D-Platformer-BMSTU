package gamestates;

import gamestates.playingstates.*;
import playing.PlayingGame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing implements GamePanelInterface, GamePanelListenerInterface {

    private OverlayManager overlayManager;
    private PlayingGame playingGame;

    public Playing() {
        initClasses();
    }

    private void initClasses() {
        overlayManager = new OverlayManager(this);
        playingGame = new PlayingGame();
    }

    @Override
    public void update() {
        overlayManager.update();
        playingGame.update();
    }

    @Override
    public void draw(Graphics g, float scale) {
        overlayManager.draw(g, scale);
        playingGame.draw(g, scale);
    }

    @Override
    public void mouseClicked(MouseEvent e, float scale) {
        overlayManager.mouseClicked(e, scale);
        playingGame.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e, float scale) {
        overlayManager.mousePressed(e, scale);
    }

    @Override
    public void mouseReleased(MouseEvent e, float scale) {
        overlayManager.mouseReleased(e, scale);
    }

    @Override
    public void mouseDragged(MouseEvent e, float scale) {
        overlayManager.mouseDragged(e, scale);
    }

    @Override
    public void mouseMoved(MouseEvent e, float scale) {
        overlayManager.mouseMoved(e, scale);
    }

    @Override
    public void keyPressed(KeyEvent e, float scale) {
        overlayManager.keyPressed(e, scale);
        playingGame.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e, float scale) {
        overlayManager.keyReleased(e, scale);
        playingGame.keyReleased(e);
    }

    public void resetAll() {
        overlayManager.resetAll();
        playingGame.resetAll();
    }
}
