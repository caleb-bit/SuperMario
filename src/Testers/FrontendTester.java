package Testers;

import Backend.Coin;
import Backend.GamePosition;
import Frontend.UICoin;
import Frontend.UIComponent;

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

        Coin coin = new Coin(new GamePosition(100,100));
        UICoin uiCoin = new UICoin(coin, 100);
        components.add(uiCoin);
        frame.getContentPane().repaint();

    }
}

