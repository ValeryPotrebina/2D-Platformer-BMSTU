package ui.menu;

import gamestates.EnumGameState;
import ui.Button;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.TextureConstants.Menu.*;
import static utilz.Constants.UI.Button.*;
import static utilz.Constants.UI.MenuButtons.*;
import static utilz.Constants.UI.MenuButtons.BUTTON_HEIGHT_DEFAULT;


public class MenuButton extends Button {

    private final EnumGameState state;
    private BufferedImage[] images;

    public MenuButton(int x, int y, int typeButton, EnumGameState state) {
        super(x - BUTTON_WIDTH_DEFAULT / 2, y, BUTTON_WIDTH_DEFAULT, BUTTON_HEIGHT_DEFAULT);
        this.typeButton = typeButton;
        this.state = state;
        loadImages();
    }

    protected void loadImages() {
        images = new BufferedImage[3];
        BufferedImage temp = LoadSave.GetSpriteAtlas(MENU_LOCATION_TEXTURES, MENU_BUTTONS_PNG);
        for (int i = 0; i < images.length; i++) {
            images[i] = temp.getSubimage(
                    i * BUTTON_WIDTH_DEFAULT, typeButton * BUTTON_HEIGHT_DEFAULT,
                    BUTTON_WIDTH_DEFAULT, BUTTON_HEIGHT_DEFAULT);
        }
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

    public void draw(Graphics g, float scale) {
        int BUTTON_WIDTH = (int) (BUTTON_WIDTH_DEFAULT * scale);
        int BUTTON_HEIGHT = (int) (BUTTON_HEIGHT_DEFAULT * scale);
        g.drawImage(images[stateButton], x, y,
                BUTTON_WIDTH, BUTTON_HEIGHT, null);
    }

    public void applyGameState() {
        EnumGameState.state = state;
    }

}
