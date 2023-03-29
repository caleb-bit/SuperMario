package Frontend;

import Backend.GameObject;
import Backend.Player;

import java.awt.*;

public class UIPlayer extends UIComponent {
    private Player player;

    UIPlayer(GameObject backendObject) {
        super(backendObject);
        if (!(backendObject instanceof Player))
            System.out.println("wrong instance");
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
