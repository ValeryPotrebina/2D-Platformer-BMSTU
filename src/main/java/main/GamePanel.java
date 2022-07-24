package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public float SCALE = 1.f;

    public int TILE_DEFAULT_SIZE = 64;
    public int TILE_SIZE = (int) (TILE_DEFAULT_SIZE * SCALE);
    public int TILES_IN_WIDTH = 16;
    public int TILES_IN_HEIGHT = 8;
    public int GAME_WIDTH = TILE_SIZE * TILES_IN_WIDTH;
    public int GAME_HEIGHT = TILE_SIZE * TILES_IN_HEIGHT;

    private final Game game;

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;

    public GamePanel(Game game) {
        this.game = game;
        setPanelSize();
        initInputs();
        addInputsToPanel();
    }

    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
    }

    private void initInputs() {
        mouseInputs = new MouseInputs(this);
        keyboardInputs = new KeyboardInputs(this);
    }

    private void addInputsToPanel() {
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.draw(g);
    }

    public Game getGame() {
        return game;
    }

}
