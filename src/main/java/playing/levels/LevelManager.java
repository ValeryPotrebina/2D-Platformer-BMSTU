package playing.levels;


import playing.PlayingDrawInterface;
import playing.PlayingUpdateInterface;
import playing.entities.PlayerLevelManager;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LevelManager implements PlayingUpdateInterface, PlayingDrawInterface {

    private PlayerLevelManager playerLevelManager;

    private ArrayList<Level> levels;
    private int lvlIndex = 0;

    public LevelManager(PlayerLevelManager playerLevelManager) {
        this.playerLevelManager = playerLevelManager;
        buildAllLevels();
    }

    private void buildAllLevels() {
        levels = new ArrayList<>();

        BufferedImage[] allLevels = LoadSave.GetAllLevelsAtlas();
        for (BufferedImage img : allLevels)
            levels.add(new Level(img));
    }

    @Override
    public void update() {
        levels.get(lvlIndex).update();
    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        levels.get(lvlIndex).draw(g, scale, lvlOffsetX, lvlOffsetY);
    }

    public int[][] getLvlData() {
        return levels.get(lvlIndex).getLvlData();
    }

    public int getLvlOffsetX() {
        return levels.get(lvlIndex).getMaxLvlOffsetX();
    }
    public int getLvlOffsetY() {
        return levels.get(lvlIndex).getMaxLvlOffsetY();
    }
}
