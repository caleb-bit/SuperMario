package Frontend;

import Backend.GameObject;
import Backend.Player;

import java.awt.*;

public class UIPlayer extends UIComponent {

    private int width = 20;
    private int height = 35;

    // determines if the UIPlayer itself can move in these directions
    // if true, then the UIposition changes when player moves
    // if false, then background changes while player stays at same UIposition
    private boolean isMovableX;
    private boolean isMovableY;

    public UIPlayer(GameObject backendObject) {
        super(backendObject);
        isMovableX = false;
        isMovableY = true;
    }

    @Override
    public void paint(Graphics g) {
        //shoes
        g.setColor(new Color(255, 140, 17));
        g.fillOval(getIntX() - width * 3 / 5, getIntY() + height * 4 / 9, width * 7 / 5, height / 5);
        //body
        g.setColor(Color.blue);
        g.fillRect(getIntX() - width / 2, getIntY() - height / 2, width, height);
        //head
        g.setColor(new Color(255, 189, 93));
        g.fillRect(getIntX() - width * 2 / 3, getIntY() - height / 2 - width * 5 / 4, width * 4 / 3, width * 5 / 4);
        //hat
        g.setColor(Color.red);
        g.fillRect(getIntX() - width * 3 / 4, getIntY() - height / 2 - width * 5 / 4 - width * 3 / 7, width * 3 / 2, width * 3 / 7);
        //face
        g.setColor(Color.black);
        g.fillRect(getIntX() + width / 8, getIntY() - height * 9 / 8, width / 8, height / 6);
        g.fillRect(getIntX() + width / 5, getIntY() - height * 7 / 8, width * 3 / 10 + width / 6, height / 10);
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

    public boolean isMovableX(){
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
