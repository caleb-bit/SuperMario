package Frontend;

import Backend.Coin;
import Backend.GameObject;

import java.awt.*;

public class UICoin extends UIComponent {
    private int radius;

    public UICoin(GameObject gameObject, int radius) {
        super(gameObject);
        this.radius = radius;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(new Color(248, 234, 107));
        graphics.fillOval((int) getUIPosition().getX(), (int) getUIPosition().getY(), radius, radius);
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        double x1 = getUIPosition().getX();
        double y1 = getUIPosition().getY();
        double x2 = pos.getX();
        double y2 = pos.getY();
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) <= radius;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Coin;
    }
}
