package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

abstract public class LevelPanel extends JPanel implements KeyListener {
    private ArrayList<UIComponent> components;
    private Player player;
    private BackendManager backend;
    private EventHandler eventHandler;
    enum Direction {UP, DOWN, RIGHT, LEFT}

    LevelPanel(BackendManager backend) {}

    public void paintComponent(Graphics g) {
        for (UIComponent component : components) {
            component.paint(g);
        }
    }

    public void keyPressed(KeyEvent e) {
        eventHandler.keyPressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e){}

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
