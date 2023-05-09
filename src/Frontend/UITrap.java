package Frontend;

import Backend.GameObject;
import Backend.Ledge;
import Backend.Trap;

import java.awt.*;

public class UITrap extends UIObstacle{

    UITrap(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(255, 0, 0));
        System.out.println(getIntX() + " " + ((Trap) getGameObject()).getXMax());
        g.drawLine(getIntX(),getIntY(), ((Trap) getGameObject()).getXMax(), ((Trap) getGameObject()).getYMax());
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Trap;
    }
}
