package Frontend;

import Backend.GameObject;

import java.awt.*;

abstract public class UIComponent {
    private UIPosition position;

    // backend representation of the UI component, stores gamePosition
    private GameObject gameObject;

    UIComponent(GameObject gameObject) {
        if (correctGameObjectType(gameObject)) {
            this.gameObject = gameObject;
            //TODO: update this to use formula for GamePosition --> UIPosition
            position = new UIPosition(gameObject.getPosition().getX(), gameObject.getPosition().getY());
        } else
            throw new IllegalArgumentException();
    }

    abstract public void paint(Graphics g);

    abstract public boolean onComponent(UIPosition pos);

    abstract boolean correctGameObjectType(GameObject gameObject);

    public void setUIPosition(UIPosition uiPosition) {
        this.position = uiPosition;
    }

    public UIPosition getUIPosition() {
        return position;
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    public int getIntX() {
        return (int) getX();
    }

    public int getIntY() {
        return (int) getY();
    }

    public GameObject getGameObject() {
        return gameObject;
    }
}
