package inputs;

import gamestates.EnumGameState;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

    private final GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        gamePanel.getGame().getGameDistribution().keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gamePanel.getGame().getGameDistribution().keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gamePanel.getGame().getGameDistribution().keyReleased(e);
    }
}
