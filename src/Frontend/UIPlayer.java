package Frontend;

import Backend.GameObject;
import Backend.Player;

import java.awt.*;

public class UIPlayer extends UIComponent {

    UIPlayer(GameObject backendObject) {
        super(backendObject);
    }

    @Override
    public void paint(Graphics graphics) {

    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Player;
    }
}
