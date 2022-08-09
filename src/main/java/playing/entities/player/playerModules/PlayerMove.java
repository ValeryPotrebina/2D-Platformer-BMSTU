package playing.entities.player.playerModules;

import playing.PlayingDrawInterface;
import playing.PlayingKeyListenerInterface;
import playing.PlayingUpdateInterface;
import playing.entities.player.PlayerModuleManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerMove extends PlayerModule implements PlayingKeyListenerInterface, PlayingUpdateInterface, PlayingDrawInterface {

    private boolean moving;
    private boolean left, right, jump;
    protected boolean inAir, inWater;

    protected float speedInWalk = 1.f;
    protected float speedInAir;
    protected float speedInWater;

    public PlayerMove(PlayerModuleManager playerModuleManager) {
        super(playerModuleManager);
    }

    @Override
    public void update() {
        updatePos();
    }

    private void updatePos() {
        float xSpeed = 0;

        if(left) {
            xSpeed -= speedInWalk;
        }
        if (right) {
            xSpeed += speedInWalk;
        }

        updateXPos(xSpeed);
        moving = true;
    }

    private void updateXPos(float xSpeed) {
        playerModuleManager.getPlayerHitBox().getHitBox().x += xSpeed;
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
