package gamestates;

import gamestates.playingstates.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing extends GameState implements GameStateInterface {

    private PauseOverlay pauseOverlay;
    private GameOverOverlay gameOverOverlay;
    private LevelCompleteOverlay levelCompletedOverlay;

    public Playing() {
        initClasses();
        calcLvlOffset();
    }

    private void initClasses() {

        pauseOverlay = new PauseOverlay(this);
        gameOverOverlay = new GameOverOverlay(this);
        levelCompletedOverlay = new LevelCompleteOverlay(this);
    }

    private void calcLvlOffset() {

    }

    @Override
    public void update() {
        switch (EnumPlayState.state) {
            case PLAYING:
//                levelManager.update();
//                player.update();
//                checkCloseToBorder();
                break;
            case PAUSED:
                pauseOverlay.update();
                break;
            case GAME_OVER:
                gameOverOverlay.update();
                break;
            case LVL_COMPLETED:
                levelCompletedOverlay.update();
                break;
            default:
                break;
        }
    }

    @Override
    public void draw(Graphics g, float scale) {
        g.drawRect(100, 200, 400, 500);

        switch (EnumPlayState.state) {
            case PLAYING:
                break;
            case PAUSED:
                pauseOverlay.draw(g, scale);
                break;
            case GAME_OVER:
                gameOverOverlay.draw(g, scale);
                break;
            case LVL_COMPLETED:
                levelCompletedOverlay.draw(g, scale);
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e, float scale) {
        switch (EnumPlayState.state) {
            case PLAYING:
                if (e.getButton() == MouseEvent.BUTTON1) {
//                    player.setAttacking(true);
                }
                break;
            case PAUSED:
                break;
            case GAME_OVER:
                break;
            case LVL_COMPLETED:
                break;
            default:
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e, float scale) {
        switch (EnumPlayState.state) {
            case PLAYING:
                break;
            case PAUSED:
                pauseOverlay.mousePressed(e, scale);
                break;
            case GAME_OVER:
                gameOverOverlay.mousePressed(e, scale);
                break;
            case LVL_COMPLETED:
                levelCompletedOverlay.mousePressed(e, scale);
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e, float scale) {
        switch (EnumPlayState.state) {
            case PLAYING:
                break;
            case PAUSED:
                pauseOverlay.mouseReleased(e, scale);
                break;
            case GAME_OVER:
                gameOverOverlay.mouseReleased(e, scale);
                break;
            case LVL_COMPLETED:
                levelCompletedOverlay.mouseReleased(e, scale);
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e, float scale) {
        switch (EnumPlayState.state) {
            case PLAYING:
                break;
            case PAUSED:
                pauseOverlay.mouseDragged(e, scale);
                break;
            case GAME_OVER:
                break;
            case LVL_COMPLETED:
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e, float scale) {
        switch (EnumPlayState.state) {
            case PLAYING:
                break;
            case PAUSED:
                pauseOverlay.mouseMoved(e, scale);
                break;
            case GAME_OVER:
                gameOverOverlay.mouseMoved(e, scale);
                break;
            case LVL_COMPLETED:
                levelCompletedOverlay.mouseMoved(e, scale);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e, float scale) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
//                player.setLeft(true);
                break;
            case KeyEvent.VK_D:
//                player.setRight(true);
                break;
            case KeyEvent.VK_SPACE:
//                player.setJump(true);
                break;
            case KeyEvent.VK_ESCAPE:
                if (EnumPlayState.state == EnumPlayState.PAUSED) {
                    EnumPlayState.state = EnumPlayState.PLAYING;
                } else {
                    EnumPlayState.state = EnumPlayState.PAUSED;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e, float scale) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
//                player.setLeft(false);
                break;
            case KeyEvent.VK_D:
//                player.setRight(false);
                break;
            case KeyEvent.VK_SPACE:
//                player.setJump(false);
                break;
        }
    }

    public void resetAll() {
        EnumPlayState.state = EnumPlayState.PLAYING;
//        player.resetAll();
    }

    public void setPaused() {
        EnumPlayState.state = EnumPlayState.PAUSED;
    }

    public void setPlaying() {
        EnumPlayState.state = EnumPlayState.PLAYING;
    }

}
