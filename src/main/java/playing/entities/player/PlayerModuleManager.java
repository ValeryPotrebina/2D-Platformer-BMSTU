package playing.entities.player;

import playing.PlayingDrawInterface;
import playing.PlayingKeyListenerInterface;
import playing.PlayingMouseListenerInterface;
import playing.PlayingUpdateInterface;
import playing.entities.player.playerModules.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class PlayerModuleManager implements PlayingUpdateInterface, PlayingDrawInterface,
        PlayingMouseListenerInterface, PlayingKeyListenerInterface {

    private Player player;

    private PlayerInPut playerInPut;
    private PlayerOutPut playerOutPut;
    private PlayerListener playerListener;

    private PlayerHitBox playerHitBox;
    private PlayerMove playerMove;
    private PlayerAttack playerAttack;
    private PlayerHealth playerHealth;

    public PlayerModuleManager(Player player) {
        this.player = player;
        initClasses();
    }

    private void initClasses() {
        playerInPut = new PlayerInPut(this);
        playerOutPut = new PlayerOutPut(this);
        playerListener = new PlayerListener(this);

        playerHitBox = new PlayerHitBox(this,100,250,20,27);
        playerAttack = new PlayerAttack(this,
                (int) (playerHitBox.getHitBox().x + playerHitBox.getHitBox().width) + 3,
                (int) playerHitBox.getHitBox().y, 20 ,20);
        playerMove = new PlayerMove(this);
    }

    @Override
    public void update() {
        playerMove.update();
        playerAttack.update();
    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        playerHitBox.draw(g, scale, lvlOffsetX, lvlOffsetY);
        playerAttack.draw(g, scale, lvlOffsetX, lvlOffsetY);
        playerMove.draw(g, scale, lvlOffsetX, lvlOffsetY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        playerListener.mouseClicked(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        playerListener.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        playerListener.keyReleased(e);
    }

    public PlayerInPut getPlayerInPut() {
        return playerInPut;
    }

    public PlayerOutPut getPlayerOutPut() {
        return playerOutPut;
    }

    public PlayerListener getPlayerListener() {
        return playerListener;
    }

    public PlayerHitBox getPlayerHitBox() {
        return playerHitBox;
    }

    public PlayerMove getPlayerMove() {
        return playerMove;
    }

    public PlayerAttack getPlayerAttack() {
        return playerAttack;
    }

    public void resetAll() {

    }

    public boolean IsPlayerOnFloor() {
        return player.IsPlayerOnFloor(playerHitBox.getHitBox());
    }

    public boolean CanMoveHere(Rectangle2D.Double hitBox) {
        return player.CanMoveHere(hitBox);
    }

}
