package Frontend;

import Backend.GameObject;
import Backend.Mushroom;

import java.awt.*;

public class UIMushroom extends UIPowerup{
    private int width= 30;
    private int height = 30;

    public UIMushroom(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        //body
        g.setColor(new Color(224,201,158));
        g.fillRect(getIntX()+width/4, getIntY()-height*3/4, width/2, height*3/4);
        g.setColor(Color.black);
        g.drawRect(getIntX()+width/4, getIntY()-height*3/4, width/2, height*3/4);

        // head
        g.setColor(new Color(230,10,10));
        g.fillOval(getIntX(), getIntY()-height, width, height/2);
        g.setColor(Color.black);
        g.drawOval(getIntX(),getIntY()-height, width, height/2);
    }


    @Override
    public boolean onComponent(UIPosition pos) {
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Mushroom;
    }
}
