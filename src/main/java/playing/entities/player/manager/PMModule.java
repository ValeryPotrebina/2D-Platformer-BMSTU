package playing.entities.player.manager;

import playing.entities.player.PlayerManager;

public abstract class PMModule {
    protected PlayerManager playerManager;

    public PMModule(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }
}
