package Testers;

import Backend.*;
import Frontend.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrontendTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Super Mario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArrayList<UIComponent> components = new ArrayList<>();
        TestPanel currPanel = new TestPanel(components);
        components.add(new UICoin(new Coin(new GamePosition(3, 3))));
        components.add(new UIPlayer(new Player(0, 0, 0, 0)));
        components.add(new UIYoshi(new Yoshi(new GamePosition(6, 0))));
        components.add(new UIFlower(new Flower(new GamePosition(10, 0))));
        components.add(new UILand(new Land(-60, 60, 0, -50)));
        components.add(new UIMushroom(new Mushroom(new GamePosition(-3, 0))));
        components.add(new UIInvincibility(new Invincibility(new GamePosition(-5, 0))));
        components.add(new UIGoomba(new Goomba(new GamePosition(0, 4))));
        components.add(new UIKoopa(new Koopa(new GamePosition(-5,5))));
        for (UIComponent component : components) {
            if (!(component instanceof UIPlayer)) {
                GamePosition pos = component.getGameObject().getPosition();
                GamePosition playerPos = new GamePosition(0, 0);
                component.setUIPosition(LevelPanel.gamePosToUiPos(pos, playerPos, new UIPosition(250, 250)));
            }
        }
        frame.setContentPane(currPanel);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setVisible(true);
        frame.getContentPane().repaint();
    }
}

