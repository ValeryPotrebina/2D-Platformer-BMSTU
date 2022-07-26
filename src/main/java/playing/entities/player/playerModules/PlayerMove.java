package playing.entities.player.playerModules;

import playing.PlayingListenerInterface;
import playing.entities.player.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PlayerMove extends PlayerModule implements PlayingListenerInterface {

    private boolean moving;
    private boolean left, right, jump;
    protected boolean inAir, inWater;

    protected float speedInWalk = 1.f;
    protected float speedInAir;
    protected float speedInWater;

    public PlayerMove(Player player) {
        super(player);
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
        player.getHitBox().x += xSpeed;
    }

    @Override
    public void draw(Graphics g, float scale, int LvlOffsetX, int LvlOffsetY) {

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

    }

    @Override
    public void keyReleased(KeyEvent e, float scale) {

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

}
