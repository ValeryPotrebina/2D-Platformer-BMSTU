package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface GameStateInterface {

    public abstract void update();

    public abstract void draw(Graphics g, float scale);

    public abstract void mouseClicked(MouseEvent e, float scale);

    public abstract void mousePressed(MouseEvent e, float scale);

    public abstract void mouseReleased(MouseEvent e, float scale);

    public abstract void mouseDragged(MouseEvent e, float scale);

    public abstract void mouseMoved(MouseEvent e, float scale);

    public abstract void keyPressed(KeyEvent e, float scale);

    public abstract void keyReleased(KeyEvent e, float scale);
}
