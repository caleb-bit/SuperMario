package Frontend;

import Backend.Flag;
import Backend.GameObject;

import java.awt.*;

public class UIFlag extends UIComponent {
    private int width;
    private int height;

    UIFlag(GameObject gameObject) {
        super(gameObject);
        width = 20;
        height = 250;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(131, 39, 0));
        g.fillRect(getIntX(), getIntY() - 30, width, 30);
        g.setColor(Color.white);
        g.fillRect(getIntX() + width / 4, getIntY() - height, width / 4, height - 30);
        g.setColor(Color.black);
        g.fillPolygon(new Polygon(new int[]{getIntX() + width/4, getIntX() + width/4+30, getIntX() + width / 4},
                new int[]{getIntY() - height, getIntY() - height + 15, getIntY() - height + 30}, 3));
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Flag;
    }
}
