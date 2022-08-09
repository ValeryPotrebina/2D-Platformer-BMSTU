package inputs;

import gamestates.EnumGameState;
import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    private final GamePanel gamePanel;

    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        gamePanel.getGame().getGameDistribution().mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        gamePanel.getGame().getGameDistribution().mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        gamePanel.getGame().getGameDistribution().mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        gamePanel.getGame().getGameDistribution().mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        gamePanel.getGame().getGameDistribution().mouseExited(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        gamePanel.getGame().getGameDistribution().mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        gamePanel.getGame().getGameDistribution().mouseMoved(e);
    }
}
