package Frontend;

import Backend.GameObject;
import Backend.Invincibility;

import java.awt.*;

public class UIInvincibility extends UIPowerup{
    UIInvincibility(GameObject gameObject) {
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
        return gameObject instanceof Invincibility;
    }
}
