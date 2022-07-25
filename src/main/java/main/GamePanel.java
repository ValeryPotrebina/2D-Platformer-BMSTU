package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

import static utilz.Constants.GameWindowConstants.GAME_HEIGHT;
import static utilz.Constants.GameWindowConstants.GAME_WIDTH;

public class GamePanel extends JPanel {

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
