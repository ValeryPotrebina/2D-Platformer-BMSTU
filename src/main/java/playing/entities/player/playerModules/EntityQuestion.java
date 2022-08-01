package playing.entities.player.playerModules;

import playing.PlayingUpdateInterface;
import playing.entities.player.PlayerModuleManager;

public class EntityQuestion extends PlayerModule implements PlayingUpdateInterface {

    public EntityQuestion(PlayerModuleManager playerModuleManager) {
        super(playerModuleManager);
    }

    @Override
    public void update() {

    }

    public boolean IsEntityOnFloor() {
        return true;
    }
}
