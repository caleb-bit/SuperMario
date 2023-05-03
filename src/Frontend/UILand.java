package Frontend;

import Backend.GameObject;
import Backend.Land;

import java.awt.*;

public class UILand extends UIComponent{

    public UILand(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(170, 74, 68));
        g.fillRect(getIntX(),getIntY(), ((Land) getGameObject()).getUIWidth(), ((Land) getGameObject()).getUIHeight());
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        //todo
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Land;
    }
}
