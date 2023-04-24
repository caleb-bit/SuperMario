package Frontend;

import Backend.GameObject;

import java.awt.*;

public class UIPiranha extends UIEnemy{
    UIPiranha(GameObject gameObject) {
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
        return false;
    }
}
