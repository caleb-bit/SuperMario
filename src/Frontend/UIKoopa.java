package Frontend;

import Backend.GameObject;
import Backend.Koopa;

import java.awt.*;

public class UIKoopa extends UIEnemy{
    UIKoopa(GameObject gameObject) {
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
        return gameObject instanceof Koopa;
    }
}
