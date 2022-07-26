package playing.entities.player.playerModules;

import playing.PlayingInterface;
import playing.PlayingListenerInterface;
import playing.entities.player.Player;

import java.awt.*;

public abstract class PlayerModule implements PlayingInterface{

    protected Player player;

    public PlayerModule(Player player) {
        this.player = player;
    }
}
