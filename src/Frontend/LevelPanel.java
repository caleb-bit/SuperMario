package Frontend;

import Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;


public class LevelPanel extends JPanel implements KeyListener {
    private ArrayList<UIComponent> components;
    private UIPlayer uiPlayer;
    private GameAPI gameAPI;

    enum Direction {UP, DOWN, RIGHT, LEFT}

    LevelPanel(ArrayList<GameObject> gameObjects, GameAPI gameAPI) {
        this.gameAPI = gameAPI;
        components = new ArrayList<>();
        uiPlayer = new UIPlayer(gameAPI.getPlayer());

        // create corresponding components for each game object in the level
        for (GameObject gameObject : gameObjects) {
            UIComponent uiComponent;
            if (gameObject instanceof Mushroom)
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
            else if (gameObject instanceof Goomba)
                uiComponent = new UIGoomba(gameObject);
            else if (gameObject instanceof Koopa)
                uiComponent = new UIKoopa(gameObject);
            else if (gameObject instanceof Coin)
                uiComponent = new UICoin(gameObject);
            else if (gameObject instanceof Land)
                uiComponent = new UILand(gameObject);
            else {
                if (gameObject == null) {
                    throw new NullPointerException("GameObject null");
                } else {
                    throw new IllegalArgumentException("gameObject wrong type");
                }
            }
            components.add(uiComponent);
        }
//        components.add(new )
        updateUIPositions();
    }

    public void paintComponent(Graphics g) {
        for (UIComponent component : components) {
            component.paint(g);
        }
        uiPlayer.paint(g);
    }

    // updates UI positions of components
    public void updateUIPositions() {
        for (UIComponent component : components) {
            if (component instanceof UIPlayer) {
                // TODO: deal with moving player on screen
            } else {
                if (component == null) {
                    throw new NullPointerException("component is null");
                }
                UIPosition relPos = relToPlayer(component);
                component.setUIPosition(relPos);
            }
        }
    }

    private UIPosition relToPlayer(UIComponent uiComponent) {
        GamePosition playerGamePos = gameAPI.getPlayerGamePos();
        UIPosition playerUIPos = uiPlayer.getUIPosition();
        GameObject gameObject = uiComponent.getGameObject();
        return new UIPosition((int) (gameObject.getPosition().getX() - playerGamePos.getX()) * 5 + playerUIPos.getX(),
                (int) -1 * (gameObject.getPosition().getY() - playerGamePos.getY()) * 5 + playerUIPos.getY());
    }

    public static UIPosition gamePosToUiPos(GamePosition objectPos, GamePosition playerPos) {
        return new UIPosition((int) (objectPos.getX() - playerPos.getX()) * 5 + playerPos.getX(),
                -5 * (objectPos.getY() - playerPos.getY()) + playerPos.getY());
    }

    public void keyPressed(KeyEvent e) {
        gameAPI.keyPressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        gameAPI.keyReleased(e.getKeyCode());
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
