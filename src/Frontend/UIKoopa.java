package Frontend;

import Backend.GameObject;
import Backend.Koopa;

import java.awt.*;

public class UIKoopa extends UIEnemy {
    private final int width = 39;
    private final int height = 42;
    private boolean isFacingRight;

    public UIKoopa(GameObject gameObject) {
        super(gameObject);
        isFacingRight = true;
    }

    @Override
    public void paint(Graphics g) {
        if ((isFacingRight && getGameObject().getVelX() < 0) || (!isFacingRight && getGameObject().getVelX() > 0)) {
            isFacingRight = !isFacingRight;
        }
        if (isFacingRight)
            facingRight(g);
        else
            facingLeft(g);
    }

    private void facingRight(Graphics g) {
        //shoes
        g.setColor(Color.yellow);
        g.fillRect(getIntX() + 10, getIntY() -6, 15, 6);
        //body
        g.setColor(Color.green);
        g.fillRect(getIntX() +6, getIntY() - 24, 25, 19);
        //tail
        g.fillRect(getIntX(), getIntY() -13, 6, 7);
        //neck
        g.setColor(Color.yellow);
        g.fillRect(getIntX() + 25, getIntY() -42, 6, 19);
        //head
        g.fillRect(getIntX() + 31, getIntY() -42, 8,12);
        //shell
        g.setColor(new Color(253, 97, 52));
        g.fillRect(getIntX() +6, getIntY() - 29, 19, 5);
        //face
        g.setColor(Color.black);
        g.fillRect(getIntX() + 35, getIntY() - 40, 1, 5);
    }

    private void facingLeft(Graphics g) {
        //shoes
        g.setColor(Color.yellow);
        g.fillRect(getIntX() + width-10-15, getIntY() -6, 15, 6);
        //body
        g.setColor(Color.green);
        g.fillRect(getIntX() +width-6-25, getIntY() - 24, 25, 19);
        //tail
        g.fillRect(getIntX()+width-6, getIntY() -13, 6, 7);
        //neck
        g.setColor(Color.yellow);
        g.fillRect(getIntX() + width-25-6, getIntY() -42, 6, 19);
        //head
        g.fillRect(getIntX() + width-31-8, getIntY() -42, 8,12);
        //shell
        g.setColor(new Color(253, 97, 52));
        g.fillRect(getIntX() +width-6-19, getIntY() - 29, 19, 5);
        //face
        g.setColor(Color.black);
        g.fillRect(getIntX() + width-35-1, getIntY() - 40, 1, 5);

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
