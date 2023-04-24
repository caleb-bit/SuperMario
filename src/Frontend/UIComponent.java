package Frontend;

import Backend.GameObject;
import Backend.Player;

import java.awt.*;

abstract public class UIComponent {
    private UIPosition uiPosition;

    // backend representation of the UI component, stores gamePosition
    private GameObject gameObject;

    UIComponent(GameObject gameObject) {
        if (correctGameObjectType(gameObject)) {
            if (gameObject instanceof Player) {
                this.gameObject = gameObject;
                // default position for player
                uiPosition = new UIPosition(250, 250);
            } else {
                this.gameObject = gameObject;
//                update this to use formula for GamePosition --> UIPosition
//                position = new UIPosition(gameObject.getPosition().getX(), gameObject.getPosition().getY());

            }
        } else
            throw new IllegalArgumentException();
    }

    abstract public void paint(Graphics g);

    abstract public boolean onComponent(UIPosition pos);

    abstract boolean correctGameObjectType(GameObject gameObject);

    public void setUIPosition(UIPosition uiPosition) {
        this.uiPosition = uiPosition;
    }

    public UIPosition getUIPosition() {
        return uiPosition;
    }

    public double getX() {
        return uiPosition.getX();
    }

    public double getY() {
        return uiPosition.getY();
    }

    public int getIntX() {
        return (int) getX();
    }

    public int getIntY() {
        return (int) getY();
    }

    public void setX(double x) {
        uiPosition.setX(x);
    }

    public void setY(double y) {
        uiPosition.setY(y);
    }


    public GameObject getGameObject() {
        return gameObject;
    }
}
