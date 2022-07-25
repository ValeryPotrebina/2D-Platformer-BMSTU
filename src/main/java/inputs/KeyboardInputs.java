package inputs;

import gamestates.EnumGameState;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

    private final GamePanel gamePanel;
    private float scale;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.scale = gamePanel.getGame().getScale();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (EnumGameState.state) {
            case PLAYING:
            case MENU:
            case QUIT:
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (EnumGameState.state) {
            case PLAYING:
            case MENU:
            case QUIT:
            default:
                break;
        }
    }
}
