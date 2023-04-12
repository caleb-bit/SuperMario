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
    private GameAPI gameAPI;

    enum Direction {UP, DOWN, RIGHT, LEFT}

    LevelPanel(GameObject[] gameObjects, GameAPI gameAPI) {
        this.gameAPI = gameAPI;
        components = new ArrayList<>();

        // create corresponding components for each game object in the level
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Player)
                components.add(new UIPlayer(gameObject));
//            else if (gameObject instanceof Mushroom)
//                components.add(new UIMushroom(gameObject));
//            else if (gameObject instanceof Yoshi)
//                components.add(new UIYoshi(gameObject));
//            else if (gameObject instanceof Flower)
//                components.add(new UIFlower(gameObject));
//            else if (gameObject instanceof Invincibility)
//                components.add(new UIInvincibility(gameObject));
//            else if (gameObject instanceof Cliff)
//                components.add(new UICliff(gameObject));
//            else if (gameObject instanceof Ledge)
//                components.add(new UILedge(gameObject));
//            else if (gameObject instanceof Trap)
//                components.add(new UITrap(gameObject));
        }
    }

    public void paintComponent(Graphics g) {
        for (UIComponent component : components) {
            component.paint(g);
        }
    }

    public void keyPressed(KeyEvent e) {
        gameAPI.keyPressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public ArrayList<UIComponent> getUIComponents() {
        return components;
    }
}
