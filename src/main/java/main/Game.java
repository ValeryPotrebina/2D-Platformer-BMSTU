package main;

import gamestates.EnumGameState;
import gamestates.Menu;
import gamestates.Playing;
import utilz.Debug;

import java.awt.*;

import static utilz.Constants.GameWindowConstants.FPS_SET;
import static utilz.Constants.GameWindowConstants.UPS_SET;

public class Game implements Runnable{

    private final float scale = 1.0f;

    private GamePanel gamePanel;
    private Debug debug;

    private Menu menu;
    private Playing playing;

    private boolean gameExit;

    public Game() {
        initClasses();
        initPanels();
        startGameLoop();
    }

    private void initClasses() {
        debug = new Debug();
        menu = new Menu();
        playing = new Playing();
    }

    private void initPanels() {
        gamePanel = new GamePanel(this);

        gamePanel.setFocusable(true);
        gamePanel.requestFocus();

        new GameWindow(gamePanel);
    }

    private void startGameLoop() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        switch (EnumGameState.state) {
            case MENU:
                menu.update();
                break;
            case PLAYING:
                playing.update();
                break;
            case QUIT:
                gameExit = true;
            default:
                System.exit(0);
                break;
        }

    }

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
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (!gameExit) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000) {
                updateDebug(frames, updates);

                lastCheck = System.currentTimeMillis();
                frames = 0;
                updates = 0;
            }
        }
    }

    private void updateDebug(int FPS_SET, int UPS_SET) {
        debug.setFPS(FPS_SET);
        debug.setUPS(UPS_SET);
        debug.say();
    }


    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public float getScale() {
        return scale;
    }


}
