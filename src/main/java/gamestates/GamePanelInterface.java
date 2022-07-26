package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface GamePanelInterface {

    public abstract void update();

    public abstract void draw(Graphics g, float scale);


}
