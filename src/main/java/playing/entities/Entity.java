package playing.entities;

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



    protected void drawHitBox(Graphics g, float scale, int LvlOffsetX, int LvlOffsetY) {
        g.setColor(Color.PINK);
        g.drawRect((int) ((hitBox.x - LvlOffsetX) * scale),
                (int) ((hitBox.y - LvlOffsetY) * scale),
                (int) (hitBox.width * scale),
                (int) (hitBox.height * scale));
    }



    public abstract void update();

    public abstract void draw(Graphics g, float scale, int LvlOffsetX, int LvlOffsetY);



}
