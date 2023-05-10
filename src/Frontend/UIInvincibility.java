package Frontend;

import Backend.GameObject;
import Backend.Invincibility;

import java.awt.*;

public class UIInvincibility extends UIPowerup {
    private double outerR;
    private double innerR;

    public UIInvincibility(GameObject gameObject) {
        super(gameObject);
        outerR = 25;
        innerR = 12;
    }

    @Override
    public void paint(Graphics g) {
        double x = getIntX() - (int) (outerR * Math.cos(162.0 / 180 * Math.PI));
        double y = getIntY() - outerR;
        int[] xCoords = new int[]{
                (int) (x + outerR * Math.cos(degToRad(18.0))),
                (int) (x + innerR * Math.cos(degToRad(54.0))),
                (int) (x + outerR * Math.cos(degToRad(90.0))),
                (int) (x + innerR * Math.cos(degToRad(126.0))),
                (int) (x + outerR * Math.cos(degToRad(162.0))),
                (int) (x + innerR * Math.cos(degToRad(198.0))),
                (int) (x + outerR * Math.cos(degToRad(234.0))),
                (int) (x + innerR * Math.cos(degToRad(270.0))),
                (int) (x + outerR * Math.cos(degToRad(306.0))),
                (int) (x + innerR * Math.cos(degToRad(342.0)))};
        int[] yCoords = new int[]{
                (int) (y - outerR * Math.sin(degToRad(18.0))),
                (int) (y - innerR * Math.sin(degToRad(54.0))),
                (int) (y - outerR * Math.sin(degToRad(90.0))),
                (int) (y - innerR * Math.sin(degToRad(126.0))),
                (int) (y - outerR * Math.sin(degToRad(162.0))),
                (int) (y - innerR * Math.sin(degToRad(198.0))),
                (int) (y - outerR * Math.sin(degToRad(234.0))),
                (int) (y - innerR * Math.sin(degToRad(270.0))),
                (int) (y - outerR * Math.sin(degToRad(306.0))),
                (int) (y - innerR * Math.sin(degToRad(342.0)))};
        Polygon p = new Polygon(xCoords, yCoords, 10);
        g.setColor(Color.black);
        g.drawPolygon(p);
        g.setColor(Color.yellow);
        g.fillPolygon(p);
    }

    private double degToRad(double deg) {
        return deg * Math.PI / 180;
    }

    @Override
    public boolean onComponent(UIPosition pos) {
        return false;
    }

    @Override
    boolean correctGameObjectType(GameObject gameObject) {
        return gameObject instanceof Invincibility;
    }
}
