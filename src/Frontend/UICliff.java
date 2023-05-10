package Frontend;

import Backend.Cliff;
import Backend.GameObject;
import Backend.Land;

import java.awt.*;

public class UICliff extends UIObstacle{
    UICliff(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(getIntX(),getIntY(), ((Cliff) getGameObject()).getLength() * 5, -25);
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Cliff;
    }
}
