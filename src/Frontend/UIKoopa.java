package Frontend;

import Backend.GameObject;
import Backend.Koopa;

import java.awt.*;

public class UIKoopa extends UIEnemy {
    private final int width = 25;
    private final int height = 37;

    public UIKoopa(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        //shoes
        g.setColor(Color.yellow);
        g.fillRect(getIntX() - width / 3 + width * 3 / 4, getIntY() + height / 2 - height * 13 / 20, width * 3 / 5, height * 3 / 20);
        //body
        g.setColor(Color.green);
        g.fillRect(getIntX() - width / 2 + width * 3 / 4, getIntY() - height * 13 / 20, width, height / 2);
        //tail
        g.fillRect(getIntX() - width * 3 / 4 + width * 3 / 4, getIntY() + height * 3 / 10 - height * 13 / 20, width / 4, height / 5);
        //neck
        g.setColor(Color.yellow);
        g.fillRect(getIntX() + width, getIntY() - height / 2 - height * 13 / 20, width / 4, height / 2);
        //head
        g.fillRect(getIntX() + width + width / 4, getIntY() - height / 2 - height * 13 / 20, width / 3, height / 3);
        //shell
        g.setColor(new Color(253, 97, 52));
        g.fillRect(getIntX() - width / 2 + width * 3 / 4, getIntY() - height / 7 - height * 13 / 20, width * 3 / 4, height / 7);
        //face
        g.setColor(Color.black);
        g.fillRect(getIntX() + width / 2 + width / 6 + width * 3 / 4, getIntY() - height / 2 + height / 15 - height * 13 / 20, width / 15, height / 8);
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Koopa;
    }
}
