package gamestates;

import ui.Button;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class GameState {

    public boolean isIn(MouseEvent e, Button mb, float scale) {
        Rectangle border = mb.getBorders();
        Rectangle borderWindow = new Rectangle(
                (int) (border.x * scale),
                (int) (border.y * scale),
                (int) (border.width * scale),
                (int) (border.height * scale));
        return borderWindow.contains(e.getX(), e.getY());
    }

}
