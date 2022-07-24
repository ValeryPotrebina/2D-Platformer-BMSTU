package gamestates;

import ui.Button;

import java.awt.event.MouseEvent;

public abstract class GameState {

    public boolean isIn(MouseEvent e, Button mb) {
        return mb.getBorders().contains(e.getX(), e.getY());
    }

}
