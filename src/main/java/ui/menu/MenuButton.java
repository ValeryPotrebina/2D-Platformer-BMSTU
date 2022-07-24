package ui.menu;

import gamestates.EnumGameState;
import ui.Button;

import java.awt.*;
import java.awt.image.BufferedImage;


public class MenuButton extends Button {

    private static final int ON = 0;
    private static final int OVER = 1;
    private static final int PRESSED = 2;

    private final EnumGameState state;

    public MenuButton(int x, int y, int width, int height, int typeButton, EnumGameState state) {
        super(x, y, width, height);
        this.typeButton = typeButton;
        this.state = state;
        loadImages();
    }

    protected void loadImages() {

    }

    public void update() {
        stateButton = ON;
        if (mouseOver) {
            stateButton = OVER;
        }
        if (mousePressed) {
            stateButton = PRESSED;
        }
    }

    public void draw(Graphics g) {
        g.drawRect(x, y,
                width, height);
    }

    public void applyGameState() {
        EnumGameState.state = state;
    }

}
