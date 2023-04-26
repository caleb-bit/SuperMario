package Frontend;

import Backend.Flower;
import Backend.GameObject;
import Backend.Powerup;

import java.awt.*;

public class UIFlower extends UIPowerup {
    int width = 30;
    int height = 30;

    public UIFlower(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        //outer circle
        g.setColor(Color.red);
        fillOval(g, getIntX() + width * 3 / 5, getIntY()-height*3/4, width, height / 2);
        //middle circle
        g.setColor(Color.yellow);
        fillOval(g, getIntX() + width * 3 / 5, getIntY()-height*3/4, width * 2 / 3, height / 3 );
        // inner circle
        g.setColor(Color.white);
        fillOval(g, getIntX() + width * 3 / 5, getIntY()-height*3/4, width / 3, height / 6);
        g.setColor(Color.green);
        //stem
        g.fillRect(getIntX() - width / 10 + width * 3 / 5, getIntY() + height / 4 - height * 3 / 4, width / 5, height / 2);
        //leaves
        g.fillPolygon(new int[]{getIntX() + width * 3 / 5, getIntX() - width * 2 / 5 + width * 3 / 5, getIntX(), getIntX() - width * 2 / 5 + width * 3 / 5, getIntX() + width * 3 / 5},
                new int[]{getIntY(), getIntY() + height / 2 + height / 8 - height * 3 / 4, getIntY() - height / 8 + height / 2 - height * 3 / 4, getIntY() - height / 4 + height / 2 - height * 3 / 4, getIntY()}, 5);
        g.fillPolygon(new int[]{getIntX() + width * 3 / 5, getIntX() + width * 2 / 5 + width * 3 / 5, getIntX() + width * 3 / 5 + width * 3 / 5, getIntX() + width * 2 / 5 + width * 3 / 5, getIntX() + width * 3 / 5},
                new int[]{getIntY(), getIntY() + height / 8 + height / 2 - height * 3 / 4, getIntY() - height / 8 + height / 2 - height * 3 / 4, getIntY() - height / 4 + height / 2 - height * 3 / 4, getIntY()}, 5);
    }

    public void fillOval(Graphics g, int centerX, int centerY, int width, int height) {
        g.fillOval(centerX - width / 2, centerY - height / 2, width, height);
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return getIntX() <= (int) pos.getX()
                && (int) pos.getX() <= getIntX() + width*6/5
                && getIntY() - height <= (int) pos.getY()
                && (int) pos.getY() <= getIntY();
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Flower;
    }
}
