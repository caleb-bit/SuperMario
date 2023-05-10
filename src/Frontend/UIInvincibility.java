package Frontend;

import Backend.GameObject;
import Backend.Invincibility;

import java.awt.*;

public class UIInvincibility extends UIPowerup {
    private int outerR;
    private int innerR;

    public UIInvincibility(GameObject gameObject) {
        super(gameObject);
        outerR = 100;
        innerR = 50;
    }

    @Override
    public void paint(Graphics g) {
//        g.setColor(Color.yellow);
//        int x = getIntX() - (int) (outerR * Math.cos(162.0/180*Math.PI));
//        int y = getIntY() - outerR;
//        int[] xCoords = new int[]{(int) (x + outerR * Math.cos(18.0/180*Math.PI)),
//                (int) (x + innerR * Math.cos(54.0/180*Math.PI)),
//                x,
//                (int) (x + innerR * Math.cos(126.0/180*Math.PI)),
//                (int) (x + outerR * Math.cos(162.0/180*Math.PI)),
//                (int) (x + innerR * Math.cos(198.0/180*Math.PI)),
//                (int) (x + outerR * Math.cos(234.0/180*Math.PI)),
//                x,
//                (int) (x + outerR * Math.cos(306.0/180*Math.PI)),
//                (int) (x + innerR * Math.cos(342.0/180*Math.PI)), (int)(x+outerR*Math.cos(18.0/180*Math.PI))};
//        int[] yCoords = new int[]{(int) (y - outerR * Math.sin(18)),
//                (int) (y - innerR * Math.sin(54.0/180*Math.PI)),
//                y,
//                (int) (y - innerR * Math.sin(126.0/180*Math.PI)),
//                (int) (y - outerR * Math.sin(162.0/180*Math.PI)),
//                (int) (y - innerR * Math.sin(198.0/180*Math.PI)),
//                (int) (y - outerR * Math.sin(234.0/180*Math.PI)),
//                y,
//                (int) (y - outerR * Math.sin(306.0/180*Math.PI)),
//                (int) (y - innerR * Math.sin(342.0/180*Math.PI)), (int)(y-outerR*Math.sin(18.0/180*Math.PI))};
//        System.out.println("center: " + x +" "+y);
//        System.out.println("coordinates: ");
//        for (int i=0; i<11; i++){
//            System.out.println(xCoords[i] + " " + yCoords[i]);
//        }
//        g.fillPolygon(new Polygon(xCoords, yCoords, 11));
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
