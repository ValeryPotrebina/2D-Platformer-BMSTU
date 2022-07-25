package entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
    protected float x, y;
    protected int width, height;
    protected Rectangle2D.Double hitBox;

    public Entity(float x, float y,int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    protected void initHitBox(int width, int height) {
        hitBox = new Rectangle2D.Double( x, y, width, height);
    }

//    protected void initAttackBox(int deltaX, int deltaY ,int width, int height) {
//        attackBox = new Rectangle2D.Double(hitBox.x + deltaX, y + deltaY, width, height);
//    }

    protected void drawHitBox(Graphics g, float scale, int LvlOffsetX, int LvlOffsetY) {
        g.setColor(Color.PINK);
        g.drawRect((int) (hitBox.x - LvlOffsetX), (int) (hitBox.y - LvlOffsetY),
                (int) hitBox.width, (int) hitBox.height);
    }

//    protected void drawAttackBox(Graphics g, float scale, int LvlOffsetX, int LvlOffsetY) {
//        g.setColor(Color.red);
//        g.drawRect((int) (attackBox.x - LvlOffsetX), (int) (attackBox.y - LvlOffsetY),
//                (int) attackBox.width, (int) attackBox.height);
//    }

    public abstract void update();

    public abstract void draw(Graphics g, float scale, int LvlOffsetX, int LvlOffsetY);

    public Rectangle2D.Double getHitBox() {
        return hitBox;
    }

}
