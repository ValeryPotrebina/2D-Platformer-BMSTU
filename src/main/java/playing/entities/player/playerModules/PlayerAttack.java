package playing.entities.player.playerModules;

import playing.PlayingDrawInterface;
import playing.PlayingMouseListenerInterface;
import playing.PlayingUpdateInterface;
import playing.entities.player.PlayerModuleManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class PlayerAttack extends PlayerModule
        implements PlayingMouseListenerInterface, PlayingUpdateInterface, PlayingDrawInterface {

    protected Rectangle2D.Double attackBox;

    public PlayerAttack(PlayerModuleManager playerModuleManager,
                        int x, int y,
                        int width, int height) {
        super(playerModuleManager);
        initAttackBox(x, y, width, height);
    }
    protected void initAttackBox(int x, int y ,int width, int height) {
        attackBox = new Rectangle2D.Double(x, y, width, height);
    }

    @Override
    public void update() {
        updateAttackBox();
    }
    private void updateAttackBox() {
        Rectangle2D.Double hitBox = playerModuleManager.getPlayerHitBox().getHitBox();
        boolean right = playerModuleManager.getPlayerMove().isRight();
        boolean left = playerModuleManager.getPlayerMove().isLeft();

        if (right) {
            attackBox.x = hitBox.x + hitBox.width + 3;
        } else if (left) {
            attackBox.x = hitBox.x - hitBox.width - 3;
        }
        attackBox.y = hitBox.y + 10;
    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        drawAttackBox(g, scale, lvlOffsetX, lvlOffsetY);
    }
    protected void drawAttackBox(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        g.setColor(Color.red);
        g.drawRect((int) (attackBox.x - lvlOffsetX), (int) (attackBox.y - lvlOffsetY),
                (int) attackBox.width, (int) attackBox.height);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

}
