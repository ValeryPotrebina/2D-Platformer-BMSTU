package entities;

import entities.playerModules.PlayerAttack;
import entities.playerModules.PlayerMove;
import gamestates.Playing;

import java.awt.*;

public class Player extends Entity {

    private Playing playing;
    private PlayerMove playerMove;
//    private PlayerAttack playerAttack;

    public Player(float x, float y, int width, int height, Playing playing) {
        super(x, y, width, height);
        this.playing = playing;
        initHitBox(20, 27);

        initClasses();
    }

    private void initClasses() {
        playerMove = new PlayerMove(this);
//        playerAttack = new PlayerAttack(this);
    }

    @Override
    public void update() {
        playerMove.update();
    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        drawHitBox(g, scale, lvlOffsetX, lvlOffsetY);
        playerMove.draw(g, scale, lvlOffsetX, lvlOffsetY);
//        drawAttackBox(g, scale, lvlOffsetX, lvlOffsetY);
    }

    public void resetAll() {

    }

    public PlayerMove getPlayerMove() {
        return playerMove;
    }
}
