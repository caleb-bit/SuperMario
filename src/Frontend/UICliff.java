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
        g.setColor(LevelPanel.BACKGROUND_COLOR);
        g.fillRect(getIntX(),getIntY(), FrontendManager.convertGameToUI(((Cliff) getGameObject()).getLength()), 300);
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
