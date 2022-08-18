package playing.entities.player;

import playing.PlayingDrawInterface;
import playing.PlayingKeyListenerInterface;
import playing.PlayingMouseListenerInterface;
import playing.PlayingUpdateInterface;
import playing.entities.PlayerLevelManager;
import playing.entities.player.manager.PMInPut;
import playing.entities.player.manager.PMListener;
import playing.entities.player.manager.PMOutPut;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class PlayerManager implements PlayingUpdateInterface, PlayingDrawInterface,
        PlayingMouseListenerInterface, PlayingKeyListenerInterface {

    private PlayerLevelManager playerLevelManager;

    private Player player;

    private PMInPut pmInPut;
    private PMOutPut pmOutPut;
    private PMListener pmListener;

    public PlayerManager(PlayerLevelManager playerLevelManager) {
        this.playerLevelManager = playerLevelManager;
        initClasses();
    }

    private void initClasses() {
        player = new Player(this, 100, 250);
        pmInPut = new PMInPut(this);
        pmOutPut = new PMOutPut(this);
        pmListener = new PMListener(this);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        player.draw(g, scale, lvlOffsetX, lvlOffsetY);
    }

    public void resetAll() {
        player.resetAll();
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        pmListener.mouseClicked(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pmListener.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pmListener.keyReleased(e);
    }

    public boolean IsPlayerOnFloor(Rectangle2D.Double hitBox) {
        return playerLevelManager.IsPlayerOnFloor(hitBox);
    }

    public boolean CanMoveHere(Rectangle2D.Double hitBox) {
        return playerLevelManager.CanMoveHere(hitBox);
    }

    public int getPlayerX() {
        return (int) player.getX();
    }

    public int getPlayerY() {
        return (int) player.getY();
    }
}
