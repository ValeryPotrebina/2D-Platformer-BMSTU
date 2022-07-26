package playing.entities;

import gamestates.Playing;
import playing.PlayingInterface;
import playing.PlayingListenerInterface;
import playing.entities.player.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PlayerManager implements PlayingInterface, PlayingListenerInterface {

    private Playing playing;

    private Player player;

    public PlayerManager(Playing playing) {
        this.playing = playing;
        initClasses();
    }
    private void initClasses() {
        player = new Player(100, 100, 64,40);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        player.draw(g, scale, lvlOffsetX, lvlOffsetY);
    }

    @Override
    public void mouseClicked(MouseEvent e, float scale) {

    }

    @Override
    public void mousePressed(MouseEvent e, float scale) {

    }

    @Override
    public void mouseReleased(MouseEvent e, float scale) {

    }

    @Override
    public void mouseDragged(MouseEvent e, float scale) {

    }

    @Override
    public void mouseMoved(MouseEvent e, float scale) {

    }

    @Override
    public void keyPressed(KeyEvent e, float scale) {
        player.getPlayerModulesManager().keyPressed(e, scale);
    }

    @Override
    public void keyReleased(KeyEvent e, float scale) {
        player.getPlayerModulesManager().keyReleased(e, scale);
    }

    public void resetAll() {
        player.resetAll();
    }
}
