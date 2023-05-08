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
        components.add(new UICoin(new Coin(new GamePosition(5, 5))));
        components.add(new UIPlayer(new Player(0, 0, 0, 0)));
        components.add(new UIYoshi(new Yoshi(new GamePosition(15, 0))));
        components.add(new UIFlower(new Flower(new GamePosition(30, 0))));
        components.add(new UILand(new Land(-60, 60, 0, -5)));
        components.add(new UIMushroom(new Mushroom(new GamePosition(-10, 0))));
        for (UIComponent component : components) {
            if (!(component instanceof UIPlayer)) {
                GamePosition pos = component.getGameObject().getPosition();
                GamePosition playerPos = new GamePosition(0, 0);
                component.setUIPosition(LevelPanel.gamePosToUiPos(pos, playerPos, new UIPosition(250, 250)));
            }
        }
        frame.setContentPane(currPanel);
//        frame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();

        frame.setVisible(true);

        frame.getContentPane().repaint();
    }
}

