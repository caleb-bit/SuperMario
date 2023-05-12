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
        g.fillRect(getIntX(), getIntY() - height*3/25, width, 30);
        g.setColor(Color.white);
        g.fillRect(getIntX() + width / 4, getIntY() - height, width / 4, height *22/25);
        g.setColor(Color.black);
        g.fillPolygon(new Polygon(new int[]{getIntX() + width/4, getIntX() + width/4+width*3/2, getIntX() + width / 4},
                new int[]{getIntY() - height, getIntY() - height *47/50, getIntY() - height *22/25}, 3));
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
