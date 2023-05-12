package Frontend;

import Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.*;
import Backend.BackendManager;

public class LevelPanel extends JPanel implements KeyListener {
    private BackendManager backendManager;
    private ArrayList<UIComponent> components;
    private BufferedImage headerImage = new BufferedImage(720,30,BufferedImage.TYPE_INT_ARGB);
    private UIPlayer uiPlayer;
    private GameAPI gameAPI;
    private ArrayList<UIFire> ballsToBeFired;

    enum Direction {UP, DOWN, RIGHT, LEFT}

    LevelPanel(ArrayList<GameObject> gameObjects, GameAPI gameAPI, BackendManager backend) {
        this.backendManager = backend;
        this.gameAPI = gameAPI;
        components = new ArrayList<>();
        uiPlayer = new UIPlayer(gameAPI.getPlayer());
        ballsToBeFired = new ArrayList<>();

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
            else if (gameObject instanceof Flag)
                uiComponent = new UIFlag(gameObject);
            else {
                if (gameObject == null) {
                    throw new NullPointerException("GameObject null");
                } else {
                    throw new IllegalArgumentException("gameObject wrong type");
                }
            }
            components.add(uiComponent);
        }
        updateUIPositions();
    }

    public void paintComponent(Graphics g) {
        drawBackground(g);
        Header.drawHeader(headerImage, (int)(backendManager.getTimeLeft() / 1000), backendManager.getPlayer().getCoins(),
                backendManager.getPlayer().getPower());
        components.addAll(ballsToBeFired);
        for (UIFire fire : ballsToBeFired) {
            fire.setUIPosition(relToPlayer(fire));
        }
        ballsToBeFired = new ArrayList<>();
        for (UIComponent component : components) {
            if (component instanceof UIPowerup) {
                if (((Powerup) component.getGameObject()).getTaken()) {
                    continue;
                }
            } else if (component instanceof UIEnemy) {
                if (!((Enemy) component.getGameObject()).getAlive()) {
                    continue;
                }
            } else if (component instanceof UICoin) {
                if (((Coin) component.getGameObject()).getTaken()) {
                    continue;
                }
            }
            component.paint(g);
        }
        g.drawImage(headerImage, 0, 0, null);
        uiPlayer.paint(g);
    }

    private void drawBackground(Graphics g) {
        g.setColor(FrontendManager.BACKGROUND_COLOR);
        int[] screenSize = gameAPI.getScreenSize();
        g.fillRect(0, 0, screenSize[0], screenSize[1]);
    }

    // updates UI positions of components
    public void updateUIPositions() {
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i) instanceof UIPlayer) {
                // TODO: deal with moving player on screen
            } else {
                if (components.get(i) == null) {
                    throw new NullPointerException("component is null");
                }
                UIPosition relPos = relToPlayer(components.get(i));
                components.get(i).setUIPosition(relPos);
            }
        }
    }

    private UIPosition relToPlayer(UIComponent uiComponent) {
        GamePosition playerGamePos = gameAPI.getPlayerGamePos();
        UIPosition playerUIPos = uiPlayer.getUIPosition();
        GameObject gameObject = uiComponent.getGameObject();
        return new UIPosition((int) (gameObject.getPosition().getX() - playerGamePos.getX()) * FrontendManager.SCALE + playerUIPos.getX(),
                -1 * (gameObject.getPosition().getY() - playerGamePos.getY()) * FrontendManager.SCALE + playerUIPos.getY());
    }

    public static UIPosition gamePosToUiPos(GamePosition objectPos, GamePosition playerPos, UIPosition playerUIPos) {
        return new UIPosition((int) (objectPos.getX() - playerPos.getX()) * FrontendManager.SCALE + playerUIPos.getX(),
                -FrontendManager.SCALE * (objectPos.getY() - playerPos.getY()) + playerUIPos.getY());
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

    public ArrayList<UIFire> getBallsToBeFired() {
        return ballsToBeFired;
    }
}
