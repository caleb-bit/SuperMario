package Frontend;

import Backend.GameObject;
import Backend.Player;

import java.awt.*;

public class UIPlayer extends UIComponent {

    private int width = 40;
    private int height = 70;

    public UIPlayer(GameObject backendObject) {
        super(backendObject);
    }

    @Override
    public void paint(Graphics g) {
        //shoes
        g.setColor(new Color(255, 140, 17));
        g.fillOval(getIntX()-width*3/5, getIntY()+height*4/9, width*7/5, height/5);
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
        g.fillRect(getIntX()+width/8, getIntY()-height*9/8, width/8, height/6);
    }

//    public void fillRect(Graphics g, int centerX, int centerY, int width, int height) {
//        g.fillRect(centerX-width/2, centerY-height/2, width, height);
//    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Player;
    }
}
