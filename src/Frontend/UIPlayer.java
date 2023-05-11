package Frontend;

import Backend.GameObject;
import Backend.Player;

import java.awt.*;

public class UIPlayer extends UIComponent {

    private final int width = 23;
    private final int height = 54;

    // determines if the UIPlayer itself can move in these directions
    // if true, then the UIposition changes when player moves
    // if false, then background changes while player stays at same UIposition
    private boolean isMovableX;
    private boolean isMovableY;
    private boolean facingRight;

    public UIPlayer(GameObject backendObject) {
        super(backendObject);
        isMovableX = false;
        isMovableY = true;
        facingRight = true;
        setUIPosition(new UIPosition(250, 300));
    }

    @Override
    public void paint(Graphics g) {
        if ((facingRight && getGameObject().getVelX() < 0) || (!facingRight && getGameObject().getVelX() > 0)) {
            facingRight = !facingRight;
        }
        if (facingRight)
            facingRight(g);
        else
            facingLeft(g);
    }

    private void facingRight(Graphics g) {
        //shoes
        g.setColor(new Color(255, 140, 17));
        g.fillOval(getIntX() + 2, getIntY() - 5, 21, 5);
        //body
        g.setColor(Color.blue);
        g.fillRect(getIntX() + 4, getIntY() - 29, 15, 25);
        //head
        g.setColor(new Color(255, 189, 93));
        g.fillRect(getIntX() + 1, getIntY() - 48, 20, 19);
        //hat
        g.setColor(Color.red);
        g.fillRect(getIntX(), getIntY() - 54, 23, 6);
        //face
        g.setColor(Color.black);
        g.fillRect(getIntX() + 13, getIntY() - 44, 2, 4);
        g.fillRect(getIntX() + 14, getIntY() - 38, 7, 3);
    }

    private void facingLeft(Graphics g) {
        //shoes
        g.setColor(new Color(255, 140, 17));
        g.fillOval(getIntX() + 23 - 2 - 21, getIntY() - 5, 21, 5);
        //body
        g.setColor(Color.blue);
        g.fillRect(getIntX() + 23 - 4 - 15, getIntY() - 29, 15, 25);
        //head
        g.setColor(new Color(255, 189, 93));
        g.fillRect(getIntX() + 23 - 1 - 20, getIntY() - 48, 20, 19);
        //hat
        g.setColor(Color.red);
        g.fillRect(getIntX(), getIntY() - 54, 23, 6);
        //face
        g.setColor(Color.black);
        g.fillRect(getIntX() + 23 - 13 - 2, getIntY() - 44, 2, 4);
        g.fillRect(getIntX() + 23 - 14 - 7, getIntY() - 38, 7, 3);
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        int x = (int) pos.getX();
        int y = (int) pos.getY();
        return getIntY() - height / 2 - width * 5 / 4 < y
                && y < getIntY() + height * 4 / 9 + height / 5
                && getIntX() - width / 2 < x
                && x < getIntX() + width / 2;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Player;
    }

    public boolean isMovableX() {
        return isMovableX;
    }

    public boolean isMovableY() {
        return isMovableY;
    }

    public void setMovableX(boolean isMovableX) {
        this.isMovableX = isMovableX;
    }

    public void setMovableY(boolean isMovableY) {
        this.isMovableY = isMovableY;
    }
}
