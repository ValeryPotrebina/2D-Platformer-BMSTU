package gamestates;

import ui.menu.MenuButton;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static utilz.Constants.GameWindowConstants.*;
import static utilz.Constants.TextureConstants.Menu.*;
import static utilz.Constants.UI.MenuButtons.COUNT_BUTTONS;
import static utilz.Constants.UI.MenuButtons.PLAY;

public class Menu extends GameState implements GameStateInterface {

    private final MenuButton[] buttons = new MenuButton[COUNT_BUTTONS];
    private BufferedImage menuImg, backgroundImg;
    private int menuX, menuY, menuWidth, menuHeight;

    public Menu() {
        loadBackgroundImg();
        loadButtons();
        calcBorder();
    }

    private void loadBackgroundImg() {
        menuImg = LoadSave.GetSpriteAtlas(MENU_LOCATION_TEXTURES, MENU_ATLAS_PNG);
        backgroundImg = LoadSave.GetSpriteAtlas(MENU_LOCATION_TEXTURES, MENU_BACKGROUND_PNG);
    }


    private void loadButtons() {
        buttons[0] = new MenuButton(
                GAME_WIDTH / 2, (int) (150 * SCALE),
                PLAY, EnumGameState.PLAYING);
    }


    private void calcBorder() {
        menuWidth = (int) (menuImg.getWidth() * SCALE);
        menuHeight = (int) (menuImg.getHeight() * SCALE);
        menuX = GAME_WIDTH / 2 - menuWidth / 2;
        menuY = (int) (45 * SCALE);
    }

    @Override
    public void update() {
        for (MenuButton mb : buttons) {
            mb.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0 , 0, GAME_WIDTH, GAME_HEIGHT, null);
        g.drawImage(menuImg, menuX, menuY,menuWidth, menuHeight, null);

        for (MenuButton mb : buttons) {
            mb.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (MenuButton mb : buttons) {
            if (isIn(e, mb)) {
                mb.setMousePressed(true);
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (MenuButton mb : buttons) {
            if (isIn(e, mb)) {
                if (mb.isMousePressed()) {
                    mb.applyGameState();
                    break;
                }
            }
        }

        resetButtons();
    }
    private void resetButtons() {
        for (MenuButton mb : buttons) {
            mb.resetBool();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (MenuButton mb : buttons) {
            mb.setMouseOver(false);
        }

        for (MenuButton mb : buttons) {
            if (isIn(e, mb)) {
                mb.setMouseOver(true);
                break;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
