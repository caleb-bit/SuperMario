package Frontend;

import Backend.GameObject;
import Backend.Ledge;

import java.awt.*;

public class UILedge extends UIObstacle {
    UILedge(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {

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
