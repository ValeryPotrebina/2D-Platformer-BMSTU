package playing.entities.player;

import playing.entities.Entity;
import playing.entities.player.playerModules.PlayerAttack;
import playing.entities.player.playerModules.PlayerMove;

import java.awt.*;

public class Player extends Entity {

    private PlayerModulesManager playerModulesManager;

    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        initHitBox(20, 27);
        initClasses();
    }

    private void initClasses() {
        playerModulesManager = new PlayerModulesManager(this);
    }

    @Override
    public void update() {
        playerModulesManager.update();
    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        drawHitBox(g, scale, lvlOffsetX, lvlOffsetY);
        playerModulesManager.draw(g, scale, lvlOffsetX, lvlOffsetY);
    }

    public void resetAll() {
        playerModulesManager.resetAll();
    }

    public PlayerModulesManager getPlayerModulesManager() {
        return playerModulesManager;
    }
}
