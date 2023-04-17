package Frontend;

import Backend.Flower;
import Backend.GameObject;
import Backend.Powerup;

import java.awt.*;

public class UIFlower extends UIPowerup {
    int width = 50;
    int height = 50;

    public UIFlower(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        fillOval(g, getIntX(), getIntY(), width, height / 2);
        g.setColor(Color.yellow);
        fillOval(g, getIntX(), getIntY(), width * 2 / 3, height / 3);
        g.setColor(Color.white);
        fillOval(g, getIntX(), getIntY(), width / 3, height / 6);
        g.setColor(Color.green);
        g.fillRect(getIntX() - width / 10, getIntY() + height / 4, width / 5, height / 2);
        g.fillPolygon(new int[]{getIntX(), getIntX() - width * 2 / 5, getIntX() - width * 3 / 5, getIntX() - width * 2 / 5, getIntX()},
                new int[]{getIntY() + height / 2 + height / 4, getIntY() + height / 2 + height / 8, getIntY() - height / 8 + height / 2, getIntY() - height / 4 + height / 2, getIntY() + height / 4 + height / 2}, 5);
        g.fillPolygon(new int[]{getIntX(), getIntX() + width * 2 / 5, getIntX() + width * 3 / 5, getIntX() + width * 2 / 5, getIntX()},
                new int[]{getIntY() + height / 4 + height / 2, getIntY() + height / 8 + height / 2, getIntY() - height / 8 + height / 2, getIntY() - height / 4 + height / 2, getIntY() + height / 4 + height / 2}, 5);
    }

    public void fillOval(Graphics g, int centerX, int centerY, int width, int height) {
        g.fillOval(centerX - width / 2, centerY - height / 2, width, height);
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return getIntX() - width * 3 / 5 <= (int) pos.getX()
                && (int) pos.getX() <= getIntX() + width * 3 / 5
                && getIntY() - height / 4 <= getIntY()
                && getIntY() <= getIntY() * 3 / 4;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Flower;
    }
}
