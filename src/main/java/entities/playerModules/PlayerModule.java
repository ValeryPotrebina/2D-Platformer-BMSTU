package entities.playerModules;

import entities.Player;

import java.awt.*;

public abstract class PlayerModule {

    protected Player player;

    public PlayerModule(Player player) {
        this.player = player;
    }

    public abstract void update();

    public abstract void draw(Graphics g, float scale, int LvlOffsetX, int LvlOffsetY);
}
