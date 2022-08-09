package playing.entities.player.playerModules;

import playing.PlayingDrawInterface;
import playing.PlayingUpdateInterface;
import playing.entities.player.PlayerModuleManager;

import java.awt.*;

public class PlayerHealth extends PlayerModule implements PlayingUpdateInterface, PlayingDrawInterface {

    public PlayerHealth(PlayerModuleManager playerModuleManager) {
        super(playerModuleManager);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {

    }
}
