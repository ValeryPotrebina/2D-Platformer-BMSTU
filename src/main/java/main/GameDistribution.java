package main;

import gamestates.EnumGameState;
import gamestates.Menu;
import gamestates.Playing;

import java.awt.*;
import java.awt.event.*;

public class GameDistribution implements MainGameInterface, MouseListener, MouseMotionListener, KeyListener{

    private final Game game;
    private final float scale;

    private Menu menu;
    private Playing playing;

    public GameDistribution(Game game) {
        this.game = game;
        this.scale = game.getScale();
        initClasses();
    }

    private void initClasses() {
        menu = new Menu();
        playing = new Playing();
    }

    @Override
    public void update() {
        switch (EnumGameState.state) {
            case MENU:
                menu.update();
                break;
            case PLAYING:
                playing.update();
                break;
            case QUIT:
                game.setGameExit();
            default:
                System.exit(0);
                break;
        }

    }

    @Override
    public void draw(Graphics g) {

        switch (EnumGameState.state) {
            case PLAYING:
                playing.draw(g, scale);
                break;
            case MENU:
                menu.draw(g, scale);
                break;
            case QUIT:
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (EnumGameState.state) {
            case PLAYING:
                playing.mouseClicked(e, scale);
                break;
            case MENU:
                menu.mouseClicked(e, scale);
            case QUIT:
            default:
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (EnumGameState.state) {
            case PLAYING:
                playing.mousePressed(e, scale);
                break;
            case MENU:
                menu.mousePressed(e, scale);
            case QUIT:
            default:
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (EnumGameState.state) {
            case PLAYING:
                playing.mouseReleased(e, scale);
                break;
            case MENU:
                menu.mouseReleased(e, scale);
            case QUIT:
            default:
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (EnumGameState.state) {
            case PLAYING:
                playing.mouseMoved(e, scale);
                break;
            case MENU:
                menu.mouseMoved(e, scale);
            case QUIT:
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (EnumGameState.state) {
            case PLAYING:
                playing.keyPressed(e, scale);
                break;
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
                playing.keyReleased(e, scale);
                break;
            case MENU:
            case QUIT:
            default:
                break;
        }
    }

}
