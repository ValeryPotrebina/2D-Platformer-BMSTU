package entities.playerModules;

import entities.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.GameConstants.GRAVITY;

public class PlayerMove extends PlayerModule{

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
