package Testers;

import Frontend.FrontendManager;
import Frontend.UIComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TestPanel extends JPanel {
    private final ArrayList<UIComponent> gameObjects;

    public TestPanel(ArrayList<UIComponent> gameObjects) {
        this.gameObjects = gameObjects;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(FrontendManager.BACKGROUND_COLOR);
        g.fillRect(0,0,500,500);
        for (UIComponent go : gameObjects) {
            if (go != null) {
                go.paint(g);
            }
        }
    }

    public ArrayList<UIComponent> getGameObjects() {
        return gameObjects;
    }
}