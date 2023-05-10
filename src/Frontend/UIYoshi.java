package Frontend;

import Backend.GameObject;
import Backend.Yoshi;

import java.awt.*;

public class UIYoshi extends UIPowerup {
    private final int width = 25;
    private final int height = 37;

    public UIYoshi(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        //shoes
        g.setColor(new Color(173, 95, 0));
        g.fillRect(getIntX() - width / 3 + width * 3 / 4, getIntY() + height / 2 - height * 13 / 20, width * 3 / 5, height * 3 / 20);
        g.setColor(Color.green);
        //body
        g.fillRect(getIntX() - width / 2 + width * 3 / 4, getIntY() - height * 13 / 20, width, height / 2);
        //tail
        g.fillRect(getIntX() - width * 3 / 4 + width * 3 / 4, getIntY() + height * 3 / 10 - height * 13 / 20, width / 4, height / 5);
        //neck
        g.fillRect(getIntX() + width, getIntY() - height / 2 - height * 13 / 20, width / 4, height / 2);
        //head
        g.fillRect(getIntX() + width * 5 / 4, getIntY() - height / 2 - height * 13 / 20, width / 3, height / 3);
        //shell
        g.setColor(new Color(253, 97, 52));
        g.fillRect(getIntX() - width / 2 + width * 3 / 4, getIntY() - height / 7 - height * 13 / 20, width * 3 / 4, height / 7);
        //face
        g.setColor(Color.black);
        g.fillRect(getIntX() + width / 2 + width / 6 + width * 3 / 4, getIntY() - height / 2 + height / 15 - height * 13 / 20, width / 15, height / 8);
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        int x = (int) pos.getX();
        int y = (int) pos.getY();
        return getIntX() < x
                && x < getIntX() + width / 2 + width / 6 + width * 3 / 4
                && getIntY() - height / 2 - height * 13 / 20 < y
                && y < getIntY();
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Yoshi;
    }
}
