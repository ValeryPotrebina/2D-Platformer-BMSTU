package playing;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface PlayingListenerInterface {

    void mouseClicked(MouseEvent e, float scale);

    void mousePressed(MouseEvent e, float scale);

    void mouseReleased(MouseEvent e, float scale);

    void mouseDragged(MouseEvent e, float scale);

    void mouseMoved(MouseEvent e, float scale);

    void keyPressed(KeyEvent e, float scale);

    void keyReleased(KeyEvent e, float scale);

}
