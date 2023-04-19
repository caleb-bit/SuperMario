package Frontend;

import Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;


abstract public class LevelPanel extends JPanel implements KeyListener {
    private ArrayList<UIComponent> components;
    private UIPlayer uiPlayer;
    private GameAPI gameAPI;

    enum Direction {UP, DOWN, RIGHT, LEFT}

    LevelPanel(GameObject[] gameObjects, GameAPI gameAPI) {
        this.gameAPI = gameAPI;
        components = new ArrayList<>();

        // create corresponding components for each game object in the level
        for (GameObject gameObject : gameObjects) {
            UIComponent uiComponent = null;
            if (gameObject instanceof Player) {
                uiComponent = new UIPlayer(gameObject);
                uiPlayer = (UIPlayer) uiComponent;
            } else if (gameObject instanceof Mushroom)
                uiComponent = new UIMushroom(gameObject);
            else if (gameObject instanceof Yoshi)
                uiComponent = new UIYoshi(gameObject);
            else if (gameObject instanceof Flower)
                uiComponent = new UIFlower(gameObject);
            else if (gameObject instanceof Invincibility)
                uiComponent = new UIInvincibility(gameObject);
            else if (gameObject instanceof Cliff)
                uiComponent = new UICliff(gameObject);
            else if (gameObject instanceof Ledge)
                uiComponent = new UILedge(gameObject);
            else if (gameObject instanceof Trap)
                uiComponent = new UITrap(gameObject);
            components.add(uiComponent);
        }
    }

    public void paintComponent(Graphics g) {
        for (UIComponent component : components) {
//            component.setUIPosition(relToPlayer(component));
            component.paint(g);
        }
    }

    public void updateUIPositions() {
        for (UIComponent component : components) {
            if (component instanceof UIPlayer) {
                // TODO: deal with moving player on screen
            } else {
                UIPosition relPos = relToPlayer(component);
                component.setUIPosition(relPos);
            }
        }
    }

    private UIPosition relToPlayer(UIComponent uiComponent) {
        GamePosition playerGamePos = gameAPI.getPlayerGamePos();
        UIPosition playerUIPos = gameAPI.getPlayerUIPos();
        GameObject gameObject = uiComponent.getGameObject();
        return new UIPosition((int) (gameObject.getPosition().getX() - playerGamePos.getX() + playerUIPos.getX()),
                (int) (gameObject.getPosition().getY() - playerGamePos.getY() + playerUIPos.getY()));
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

    public UIPlayer getUiPlayer() {
        return uiPlayer;
    }
}
