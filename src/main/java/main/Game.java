package main;

import java.awt.*;

import static utilz.Constants.GameWindowConstants.FPS_SET;
import static utilz.Constants.GameWindowConstants.UPS_SET;

public class Game implements Runnable{

    private final float scale = 1.0f;

    private GamePanel gamePanel;
    private GameDistribution gameDistribution;

    private boolean gameExit;

    public Game() {
        initClasses();
        initPanels();
        startGameLoop();
    }

    private void initClasses() {
        gameDistribution = new GameDistribution(this);
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
        gameDistribution.update();
    }

    public void draw(Graphics g) {
        gameDistribution.draw(g);
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

//        int frames = 0;
//        int updates = 0;

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
//                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
//                frames++;
                deltaF--;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
//                frames = 0;
//                updates = 0;
            }
        }
    }

    public void setGameExit() {
        gameExit = true;
    }

    public float getScale() {
        return scale;
    }

    public GameDistribution getGameDistribution() {
        return gameDistribution;
    }
}
