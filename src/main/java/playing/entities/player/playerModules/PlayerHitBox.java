package playing.entities.player.playerModules;

import playing.PlayingDrawInterface;
import playing.PlayingUpdateInterface;
import playing.entities.player.PlayerModuleManager;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class PlayerHitBox extends PlayerModule implements PlayingUpdateInterface, PlayingDrawInterface {


    private Rectangle2D.Double hitBox;

    public PlayerHitBox(PlayerModuleManager playerModuleManager,
                        int x, int y,
                        int width, int height) {
        super(playerModuleManager);
        initHitBox(x, y, width, height);
    }

    private void initHitBox(int x, int y, int width, int height) {
        hitBox = new Rectangle2D.Double(x, y, width, height);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        drawHitBox(g, scale, lvlOffsetX, lvlOffsetY);
    }

    private void drawHitBox(Graphics g, float scale, int LvlOffsetX, int LvlOffsetY) {
        g.setColor(Color.PINK);
        g.drawRect((int) ((hitBox.x - LvlOffsetX) * scale),
                (int) ((hitBox.y - LvlOffsetY) * scale),
                (int) (hitBox.width * scale),
                (int) (hitBox.height * scale));
    }

    public Rectangle2D.Double getHitBox() {
        return hitBox;
    }

    public void updateHitBoxX(int xSpeed){
        hitBox.x += xSpeed;
        playerModuleManager.setPlayerX(hitBox.x);
    }

    public void updateHitBoxY(int ySpeed){
        hitBox.y += ySpeed;
        playerModuleManager.setPlayerY(hitBox.y);
    }

}
