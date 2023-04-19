package Frontend;

import Backend.GameObject;
import Backend.Mushroom;

import java.awt.*;

public class UIMushroom extends UIPowerup{
    UIMushroom(GameObject gameObject) {
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
        return gameObject instanceof Mushroom;
    }
}
