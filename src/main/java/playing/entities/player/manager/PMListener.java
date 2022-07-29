package playing.entities.player.manager;

import playing.PlayingKeyListenerInterface;
import playing.PlayingMouseListenerInterface;
import playing.entities.player.PlayerManager;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PMListener extends PMModule implements PlayingMouseListenerInterface, PlayingKeyListenerInterface {

    public PMListener(PlayerManager playerManager) {
        super(playerManager);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        playerManager.getPlayer().mouseClicked(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        playerManager.getPlayer().keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        playerManager.getPlayer().keyReleased(e);
    }
}
