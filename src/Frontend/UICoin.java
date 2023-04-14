package Frontend;

import Backend.Coin;
import Backend.GameObject;

import java.awt.*;

public class UICoin extends UIComponent {
    private final int width = 20;
    private final int height = 40;

    public UICoin(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        fillOval(g, getIntX(), getIntY(), width + 10, height + 10);
        g.setColor(Color.yellow);
        fillOval(g, getIntX(), getIntY(), width, height);
        g.setColor(Color.yellow.darker());
        fillOval(g, getIntX(), getIntY(), width / 2, height / 2);
    }

    // more convenient fillOval (takes in center pos, not top left)
    public void fillOval(Graphics g, int centerX, int centerY, int width, int height) {
        g.fillOval(centerX - width / 2, centerY - height / 2, width, height);
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        double x1 = getUIPosition().getX();
        double y1 = getUIPosition().getY();
        double x2 = pos.getX();
        double y2 = pos.getY();
        return squared((x1 - x2) / width) + squared((y1 - y2) / height) <= 1;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Coin;
    }

    private double squared(double x) {
        return x * x;
    }
}
