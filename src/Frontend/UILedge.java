package Frontend;

import Backend.GameObject;
import Backend.Land;
import Backend.Ledge;

import java.awt.*;

public class UILedge extends UIObstacle {
    UILedge(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(170, 74, 68));
        g.fillRect(getIntX(),getIntY(), (int)FrontendManager.convertGameToUI(((Ledge) getGameObject()).getLength()), (int)FrontendManager.convertGameToUI(((Ledge)getGameObject()).getLength()));
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Ledge;
    }
}
