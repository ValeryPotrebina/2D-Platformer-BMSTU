package playing.levels;

import playing.PlayingDrawInterface;
import playing.PlayingUpdateInterface;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.GameWindowConstants.*;
import static utilz.Constants.TextureConstants.Level.LEVEL_LOCATION_TEXTURES;
import static utilz.Constants.TextureConstants.Level.LVL_TEXTURES_PNG;

public class Level implements PlayingUpdateInterface, PlayingDrawInterface {

    private final BufferedImage levelImg;
    private BufferedImage[] levelSprite;
    private int[][] lvlData;

    private int maxLvlOffsetX, maxLvlOffsetY;

    public Level(BufferedImage levelImg) {
        this.levelImg = levelImg;
        GetLevelData(levelImg);
        calcLvlOffset();
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

    private void calcLvlOffset() {
        int lvlTilesWideX = levelImg.getWidth();
        int maxTilesOffsetX = lvlTilesWideX - TILES_IN_WIDTH;
        maxLvlOffsetX = TILE_SIZE_DEFAULT * maxTilesOffsetX;

        int lvlTilesWideY = levelImg.getHeight();
        int maxTilesOffsetY = lvlTilesWideY - TILES_IN_HEIGHT;
        maxLvlOffsetY = TILE_SIZE_DEFAULT * maxTilesOffsetY;
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
        for (int j = 0; j < lvlData.length; j++) {
            for (int i = 0; i < lvlData[0].length; i++) {
                int index = lvlData[j][i];
                g.drawImage(levelSprite[index],
                        (int) ((TILE_SIZE_DEFAULT * i - lvlOffsetX) * scale),
                        (int) ((TILE_SIZE_DEFAULT * j - lvlOffsetY) * scale),
                        (int) (TILE_SIZE_DEFAULT * scale), (int) (TILE_SIZE_DEFAULT * scale), null);
            }
        }
    }

    public int[][] getLvlData() {
        return lvlData;
    }

    public int getMaxLvlOffsetX() {
        return maxLvlOffsetX;
    }

    public int getMaxLvlOffsetY() {
        return maxLvlOffsetY;
    }
}
