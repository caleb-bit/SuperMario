package Testers;

import Backend.Coin;
import Backend.GamePosition;
import Backend.Player;
import Frontend.UICoin;
import Frontend.UIComponent;
import Frontend.UIPlayer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrontendTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Super Mario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArrayList<UIComponent> components = new ArrayList<>();
        TestPanel currPanel = new TestPanel(components);
        frame.setContentPane(currPanel);
        frame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        frame.pack();
        frame.setVisible(true);

        components.add(new UICoin(new Coin(new GamePosition(100,100))));
        components.add(new UIPlayer(new Player(200,300, 0,0)));

        frame.getContentPane().repaint();
    }
}

