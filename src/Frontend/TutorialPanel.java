package Frontend;

import Backend.GameAPI;

import javax.swing.*;
import java.awt.*;

public class TutorialPanel extends JPanel {
    private final int[] screenSize;

    public TutorialPanel(int[] screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(FrontendManager.BACKGROUND_COLOR);
        g.fillRect(0, 0, screenSize[0], screenSize[1]);
        g.setColor(Color.black);
        g.setFont(new Font("SansSerif", Font.BOLD, 28));
        g.drawString("Super Javario Tutorial", 60, 30);
        g.setFont(new Font("SansSerif", Font.BOLD, 17));
        g.drawString("Javario needs your help! He must save Princess Python", 20, 60);
        g.drawString("from the evil King ArrayIndexOutofBowser.", 20, 80);
        g.drawString("Using arrow keys, reach the final flag before time is up.", 20, 100);
        drawCoin(g, 30, 130);
        g.setColor(Color.black);
        g.drawString("Coin", 60, 130);
        drawFlag(g, 100, 220);
        g.setColor(Color.black);
        g.drawString("Checkpoint", 140, 160);
        drawFlower(g, 30, 270 - 40);
        g.setColor(Color.black);
        g.drawString("Flower - Lets you throw fireballs (Space key)", 80, 260 - 40);
        drawGoomba(g, 30, 310 - 40);
        g.setColor(Color.black);
//        g.drawString("Goomba - Defeat by jumping on top of them", 80, 310-40);
        drawKoopa(g, 70, 310 - 40);
        g.setColor(Color.black);
        g.drawString("Goomba and Koopa", 130, 310 - 40);
        g.drawString("Defeat by jumping on top of them", 130, 330 - 40);
        drawInvincibility(g, 50, 360 - 40);
        g.setColor(Color.black);
        g.drawString("Invincibility star - enemies cannot hurt you", 100, 370 - 40);
        drawYoshi(g,30,400);
        g.setColor(Color.black);
        g.drawString("Yoshi", 80, 400);
    }

    private void drawCoin(Graphics g, int x, int y) {
        int width = 20;
        int height = 30;
        g.setColor(Color.black);
        fillOval(g, x, y, width, height);
        g.setColor(Color.yellow);
        fillOval(g, x, y, width - 10, height - 10);
        g.setColor(Color.yellow.darker());
        fillOval(g, x, y, (width - 10) / 2, (height - 10) / 2);
    }

    private void fillOval(Graphics g, int centerX, int centerY, int width, int height) {
        g.fillOval(centerX - width / 2, centerY - height / 2, width, height);
    }

    private void drawFlag(Graphics g, int x, int y) {
        int width = 20;
        int height = 100;
        g.setColor(new Color(131, 39, 0));
        g.fillRect(x, y - height * 14 / 25, width, height * 3 / 25);
        g.setColor(Color.white);
        g.fillRect(x + width / 4, y - height, width / 4, height * 11 / 25);
        g.setColor(Color.black);
        g.fillPolygon(new Polygon(new int[]{x + width / 4, x + width / 4 + width * 3 / 2, x + width / 4},
                new int[]{y - height, y - height * 47 / 50, y - height * 22 / 25}, 3));

    }

    private void drawFlower(Graphics g, int x, int y) {
        int width = 30;
        int height = 30;
        //outer circle
        g.setColor(Color.red);
        fillOval(g, x + width * 3 / 5, y - height * 3 / 4, width, height / 2);
        //middle circle
        g.setColor(Color.yellow);
        fillOval(g, x + width * 3 / 5, y - height * 3 / 4, width * 2 / 3, height / 3);
        // inner circle
        g.setColor(Color.white);
        fillOval(g, x + width * 3 / 5, y - height * 3 / 4, width / 3, height / 6);
        g.setColor(Color.green);
        //stem
        g.fillRect(x - width / 10 + width * 3 / 5, y + height / 4 - height * 3 / 4, width / 5, height / 2);
        //leaves
        g.fillPolygon(new int[]{x + width * 3 / 5, x - width * 2 / 5 + width * 3 / 5, x, x - width * 2 / 5 + width * 3 / 5, x + width * 3 / 5},
                new int[]{y, y + height / 2 + height / 8 - height * 3 / 4, y - height / 8 + height / 2 - height * 3 / 4, y - height / 4 + height / 2 - height * 3 / 4, y}, 5);
        g.fillPolygon(new int[]{x + width * 3 / 5, x + width * 2 / 5 + width * 3 / 5, x + width * 3 / 5 + width * 3 / 5, x + width * 2 / 5 + width * 3 / 5, x + width * 3 / 5},
                new int[]{y, y + height / 8 + height / 2 - height * 3 / 4, y - height / 8 + height / 2 - height * 3 / 4, y - height / 4 + height / 2 - height * 3 / 4, y}, 5);
    }

    private void drawGoomba(Graphics g, int x, int y) {
        int width = 30;
        int height = 30;
        //head
        g.setColor(new Color(105, 72, 30));
        g.fillPolygon(new Polygon(new int[]{x, x + width / 2, x + width},
                new int[]{y - height / 3, y - height, y - height / 3}, 3));
        //body
        g.setColor(new Color(248, 204, 150));
        g.fillRect(x + width / 4, y - height / 3, width / 2, height / 3);
        //feet
        g.setColor(new Color(87, 47, 0));
        g.fillOval(x + width / 4 - width / 5, y - height / 5, width * 2 / 5, height / 5);
        g.fillOval(x + width * 3 / 4 - width / 5, y - height / 5, width * 2 / 5, height / 5);
        //eyes
        g.setColor(Color.white);
        g.fillRect(x + width * 3 / 7, y - height * 4 / 5, width / 11, height / 6);
        g.fillRect(x + width * 4 / 7, y - height * 4 / 5, width / 11, height / 6);
    }

    private void drawKoopa(Graphics g, int x, int y) {
        int width = 25;
        int height = 37;
        //shoes
        g.setColor(Color.yellow);
        g.fillRect(x - width / 3 + width * 3 / 4, y + height / 2 - height * 13 / 20, width * 3 / 5, height * 3 / 20);
        //body
        g.setColor(Color.green);
        g.fillRect(x - width / 2 + width * 3 / 4, y - height * 13 / 20, width, height / 2);
        //tail
        g.fillRect(x - width * 3 / 4 + width * 3 / 4, y + height * 3 / 10 - height * 13 / 20, width / 4, height / 5);
        //neck
        g.setColor(Color.yellow);
        g.fillRect(x + width, y - height / 2 - height * 13 / 20, width / 4, height / 2);
        //head
        g.fillRect(x + width + width / 4, y - height / 2 - height * 13 / 20, width / 3, height / 3);
        //shell
        g.setColor(new Color(253, 97, 52));
        g.fillRect(x - width / 2 + width * 3 / 4, y - height / 7 - height * 13 / 20, width * 3 / 4, height / 7);
        //face
        g.setColor(Color.black);
        g.fillRect(x + width / 2 + width / 6 + width * 3 / 4, y - height / 2 + height / 15 - height * 13 / 20, width / 15, height / 8);
    }

    private void drawInvincibility(Graphics g, int x, int y) {
        double outerR = 20;
        double innerR = 10;
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
//        g.setColor(Color.black);
//        g.drawPolygon(p);
        g.setColor(Color.yellow);
        g.fillPolygon(p);
    }

    private double degToRad(double deg) {
        return deg * Math.PI / 180;
    }

    private void drawYoshi(Graphics g, int x, int y) {
        int width=25;
        int height=37;
        //shoes
        g.setColor(new Color(173, 95, 0));
        g.fillRect(x - width / 3 + width * 3 / 4, y + height / 2 - height * 13 / 20, width * 3 / 5, height * 3 / 20);
        g.setColor(Color.green);
        //body
        g.fillRect(x - width / 2 + width * 3 / 4, y - height * 13 / 20, width, height / 2);
        //tail
        g.fillRect(x - width * 3 / 4 + width * 3 / 4, y + height * 3 / 10 - height * 13 / 20, width / 4, height / 5);
        //neck
        g.fillRect(x + width, y - height / 2 - height * 13 / 20, width / 4, height / 2);
        //head
        g.fillRect(x + width * 5 / 4, y - height / 2 - height * 13 / 20, width / 3, height / 3);
        //shell
        g.setColor(new Color(253, 97, 52));
        g.fillRect(x - width / 2 + width * 3 / 4, y - height / 7 - height * 13 / 20, width * 3 / 4, height / 7);
        //face
        g.setColor(Color.black);
        g.fillRect(x + width / 2 + width / 6 + width * 3 / 4, y - height / 2 + height / 15 - height * 13 / 20, width / 15, height / 8);

    }
}
