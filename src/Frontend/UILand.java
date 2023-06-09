package Frontend;

import Backend.GameObject;
import Backend.Land;

import java.awt.*;

public class UILand extends UIComponent{

    private int width;
    private int height;

    public UILand(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(170, 74, 68));
        g.fillRect(getIntX(),getIntY(), (int) ((Land) getGameObject()).getUIWidth(), (int) ((Land) getGameObject()).getUIHeight());
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
