package playing.entities.player.playerModules;

import playing.PlayingDrawInterface;
import playing.PlayingKeyListenerInterface;
import playing.PlayingMouseListenerInterface;
import playing.PlayingUpdateInterface;
import playing.entities.player.PlayerModuleManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PlayerListener extends PlayerModule
        implements PlayingUpdateInterface,
        PlayingKeyListenerInterface, PlayingMouseListenerInterface {

    public PlayerListener(PlayerModuleManager playerModuleManager) {
        super(playerModuleManager);
    }

    @Override
    public void update() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        playerModuleManager.getPlayerMove().keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        playerModuleManager.getPlayerMove().keyReleased(e);
    }

}
