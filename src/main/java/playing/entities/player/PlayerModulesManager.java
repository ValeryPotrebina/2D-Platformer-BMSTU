package playing.entities.player;

import playing.PlayingInterface;
import playing.PlayingListenerInterface;
import playing.entities.player.playerModules.PlayerAttack;
import playing.entities.player.playerModules.PlayerMove;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PlayerModulesManager  implements PlayingInterface, PlayingListenerInterface {

    private Player player;

    private PlayerMove playerMove;
    private PlayerAttack playerAttack;

    public PlayerModulesManager(Player player) {
        this.player = player;
        initClasses();
    }

    private void initClasses() {
        playerMove = new PlayerMove(player);
        playerAttack = new PlayerAttack(player);
    }

    @Override
    public void update() {
        playerMove.update();
    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        playerMove.draw(g, scale, lvlOffsetX, lvlOffsetY);
//        drawAttackBox(g, scale, lvlOffsetX, lvlOffsetY);
    }

    public void resetAll() {

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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                playerMove.setLeft(true);
                break;
            case KeyEvent.VK_D:
                playerMove.setRight(true);
                break;
            case KeyEvent.VK_SPACE:
                playerMove.setJump(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e, float scale) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                playerMove.setLeft(false);
                break;
            case KeyEvent.VK_D:
                playerMove.setRight(false);
                break;
            case KeyEvent.VK_SPACE:
                playerMove.setJump(false);
                break;
        }
    }
}
