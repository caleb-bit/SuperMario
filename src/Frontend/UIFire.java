package Frontend;

import Backend.Fireball;
import Backend.GameObject;

import java.awt.*;

public class UIFire extends UIComponent {
    public UIFire(GameObject gameObject, LevelPanel levelPanel) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        if (getUIPosition() != null) {
            g.setColor(new Color(255, 0, 0));
            g.fillOval(getIntX(), getIntY() - 20, 10, 10);
        }
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Fireball;
    }

}
