package Frontend;

import Backend.GameObject;
import Backend.Goomba;

import java.awt.*;

public class UIGoomba extends UIEnemy {

    private int width;
    private int height;

    public UIGoomba(GameObject gameObject) {
        super(gameObject);
        width = 30;
        height = 30;
    }

    @Override
    public void paint(Graphics g) {
        //head
        g.setColor(new Color(105, 72, 30));
        g.fillPolygon(new Polygon(new int[]{getIntX(), getIntX() + width / 2, getIntX() + width},
                new int[]{getIntY() - height / 3, getIntY()-height, getIntY() - height / 3}, 3));
        //body
        g.setColor(new Color(248, 204, 150));
        g.fillRect(getIntX()+width/4, getIntY()-height/3, width/2, height/3);
        //feet
        g.setColor(new Color(87, 47, 0));
        g.fillOval(getIntX()+width/4-width/5, getIntY()-height/5,width*2/5, height/5);
        g.fillOval(getIntX()+width*3/4-width/5, getIntY()-height/5,width*2/5, height/5);
        //eyes
        g.setColor(Color.white);
        g.fillRect(getIntX()+width*3/7, getIntY()-height*4/5, width/11, height/6);
        g.fillRect(getIntX()+width*4/7, getIntY()-height*4/5, width/11, height/6);
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Goomba;
    }
}
