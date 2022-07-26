package playing.levels;

import playing.PlayingInterface;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.GameWindowConstants.*;
import static utilz.Constants.TextureConstants.Level.LEVEL_LOCATION_TEXTURES;
import static utilz.Constants.TextureConstants.Level.LVL_TEXTURES_PNG;

public class Level implements PlayingInterface {

    private final BufferedImage levelImg;
    private BufferedImage[] levelSprite;
    private int[][] lvlData;

    public Level(BufferedImage levelImg) {
        this.levelImg = levelImg;
        GetLevelData(levelImg);
//        calcLvlOffset();
        importOutsideSprites();
    }

    private void GetLevelData(BufferedImage levelImg) {
        int[][] lvlData = new int[levelImg.getHeight()][levelImg.getWidth()];

        for (int j = 0; j < levelImg.getHeight(); j++)
            for (int i = 0; i < levelImg.getWidth(); i++) {
                Color color = new Color(levelImg.getRGB(i, j));
                int value = color.getRed();
                if (value >= 48)
                    value = 0;
                lvlData[j][i] = value;
            }

        this.lvlData = lvlData;
    }

    private void importOutsideSprites() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LEVEL_LOCATION_TEXTURES, LVL_TEXTURES_PNG);
        levelSprite = new BufferedImage[48];
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 12; i++) {
                int index = j*12 + i;
                levelSprite[index] = img.getSubimage(i*32, j*32, 32, 32);
            }
        }
    }

    @Override
    public void update() {

    }


    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        drawLvlSprite(g, scale, lvlOffsetX, lvlOffsetY);
    }

    private void drawLvlSprite(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        int TILE_SIZE = (int) (TILE_SIZE_DEFAULT * scale);
        for (int j = 0; j < TILES_IN_HEIGHT && j < lvlData.length; j++) {
            for (int i = 0; i < TILES_IN_WIDTH && i < lvlData[0].length; i++) {
                int index = lvlData[j][i];
                g.drawImage(levelSprite[index],
                        TILE_SIZE * i - lvlOffsetX,
                        TILE_SIZE * j - lvlOffsetY,
                        TILE_SIZE, TILE_SIZE, null);
            }
        }
    }
}
