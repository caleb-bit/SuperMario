package Frontend;

import Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.Map;


abstract public class LevelPanel extends JPanel implements KeyListener {
    private ArrayList<UIComponent> components;

    enum Direction {UP, DOWN, RIGHT, LEFT}

    LevelPanel(GameObject[] gameObjects) {
        components = new ArrayList<>();
        for (GameObject gameObject : gameObjects) {
            if(gameObject instanceof Player)
                components.add(new UIPlayer(gameObject));
            //TODO: finish this
        }
    }

    public void paintComponent(Graphics g) {
        for (UIComponent component : components) {
            component.paint(g);
        }
    }

    public void keyPressed(KeyEvent e) {
        eventHandler.keyPressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public ArrayList<UIComponent> getUIComponents() {
        return components;
    }

    public Player getPlayer() {
        return player;
    }

    public BackendManager getBackend() {
        return backend;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }


}
