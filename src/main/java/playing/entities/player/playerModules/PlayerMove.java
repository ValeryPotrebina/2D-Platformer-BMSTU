package playing.entities.player.playerModules;

import playing.PlayingDrawInterface;
import playing.PlayingKeyListenerInterface;
import playing.PlayingUpdateInterface;
import playing.entities.player.PlayerModuleManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import static utilz.Constants.GameConstants.GRAVITY;

public class PlayerMove extends PlayerModule implements PlayingKeyListenerInterface, PlayingUpdateInterface, PlayingDrawInterface {

    private boolean moving;
    private boolean left, right, jump;
    private boolean inAir, inWater;
    private boolean onFloor;

    private float speedInWalk = 1.f;
    private float speedInAir;
    private float speedInWater;

    public PlayerMove(PlayerModuleManager playerModuleManager) {
        super(playerModuleManager);
    }

    @Override
    public void update() {
        updatePos();
    }

    private void updatePos() {
        float xSpeed = 0;

        if (left) {
            xSpeed -= speedInWalk;
        }
        if (right) {
            xSpeed += speedInWalk;
        }

        if (onFloor) {
            if (!playerModuleManager.IsPlayerOnFloor())
                onFloor = false;
        }

        if (!onFloor) {
            Rectangle2D.Double oldHitBox = playerModuleManager.getPlayerHitBox().getHitBox();
            Rectangle2D.Double newHitBox = new Rectangle2D.Double(
                    oldHitBox.x, oldHitBox.y + speedInAir,
                    oldHitBox.width, oldHitBox.height);
            if (playerModuleManager.CanMoveHere(newHitBox)) {
                updateYPos(speedInAir);
                speedInAir += GRAVITY;
            } else {
                onFloor = true;
                speedInAir = 0;
            }
        }

        updateXPos(xSpeed);
        moving = true;
    }

    private void updateXPos(double xSpeed) {
        playerModuleManager.getPlayerHitBox().updateHitBoxX((int) xSpeed);
    }

    private void updateYPos(double ySpeed) {
        playerModuleManager.getPlayerHitBox().updateHitBoxY((int) ySpeed);
    }

    @Override
    public void draw(Graphics g, float scale, int LvlOffsetX, int LvlOffsetY) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                setLeft(true);
                break;
            case KeyEvent.VK_D:
                setRight(true);
                break;
            case KeyEvent.VK_SPACE:
                setJump(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                setLeft(false);
                break;
            case KeyEvent.VK_D:
                setRight(false);
                break;
            case KeyEvent.VK_SPACE:
                setJump(true);
                break;
        }
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isJump() {
        return jump;
    }

}
