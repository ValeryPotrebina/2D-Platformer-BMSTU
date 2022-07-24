package ui;

import java.awt.*;

public abstract class Button {
    protected int x, y , width, height;
    protected Rectangle borders;

    protected int typeButton;
    protected int stateButton;
    protected boolean mouseOver, mousePressed;

    public Button(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        calcBorder();
    }

    private void calcBorder() {
        borders = new Rectangle(x, y, width, height);
    }

    public Rectangle getBorders() {
        return borders;
    }

    protected abstract void loadImages();

    public abstract void update();

    public abstract void draw(Graphics g);

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public void resetBool() {
        mouseOver = false;
        mousePressed = false;
    }

}
