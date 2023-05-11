package Frontend;

import Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

public class FrontendManager {
    private JFrame frame;
    private ArrayList<LevelPanel> levelPanels;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private LevelPanel currPanel;
    private GameAPI api;
    // matches key code with pressed status
    private HashMap<Integer, Boolean> keysPressed;
    public static final int SCALE = 20;
    private int[] screenSize;
    private MenuPanel menuPanel;
    private GameOverPanel overPanel;
    private WinPanel winPanel;

    public FrontendManager(GameAPI api) {
        overPanel = new GameOverPanel();
        winPanel = new WinPanel();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        menuPanel = new MenuPanel(api);
        levelPanels = new ArrayList<>();
        levelPanels.add(new LevelPanel(api.getGameObjects(1), api, api.getBackend()));
        levelPanels.add(new LevelPanel(api.getGameObjects(2), api, api.getBackend()));
        levelPanels.add(new LevelPanel(api.getGameObjects(3), api, api.getBackend()));
        levelPanels.add(new LevelPanel(api.getGameObjects(4), api, api.getBackend()));
        overPanel = new GameOverPanel();
        currPanel = levelPanels.get(0);
        mainPanel.add(menuPanel, "menu");
        for (int i=1; i<=4; i++) {
            mainPanel.add(levelPanels.get(i-1), "level"+i);
        }
        cardLayout.show(mainPanel, "menu");
        screenSize = new int[]{500, 500};
        keysPressed = new HashMap<>();
        keysPressed.put(KeyEvent.VK_LEFT, false);
        keysPressed.put(KeyEvent.VK_RIGHT, false);
        keysPressed.put(KeyEvent.VK_UP, false);
        keysPressed.put(KeyEvent.VK_DOWN, false);
        keysPressed.put(KeyEvent.VK_SPACE, false);
        this.api = api;
    }

    public void openGame() {
        frame = new JFrame("Super Javario");
//        frame.setContentPane(currPanel);
        frame.setContentPane(mainPanel);
        frame.setPreferredSize(new Dimension(screenSize[0], screenSize[1]));
        frame.pack();
        frame.setVisible(true);
//        frame.addKeyListener(currPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void updateScreen() {
        currPanel.updateUIPositions();
        frame.repaint();
    }

    public UIPosition getPlayerUIPos() {
        return currPanel.getUiPlayer().getUIPosition();
    }

    public void keyPressed(int keyCode) {
        if (keyCodeValid(keyCode))
            keysPressed.replace(keyCode, true);
    }

    public void keyReleased(int keyCode) {
        if (keyCodeValid(keyCode))
            keysPressed.replace(keyCode, false);
    }

    private boolean keyCodeValid(int keyCode) {
        return keyCode == KeyEvent.VK_LEFT
                || keyCode == KeyEvent.VK_RIGHT
                || keyCode == KeyEvent.VK_UP
                || keyCode == KeyEvent.VK_DOWN
                || keyCode == KeyEvent.VK_SPACE;
    }

    public HashMap<Integer, Boolean> getKeysPressed() {
        return keysPressed;
    }

    public int[] getScreenSize() {
        return screenSize;
    }

    public static int convertGameToUI(int x) {
        return x * SCALE;
    }

    public void fireballFired(Fireball fireball) {
        currPanel.getBallsToBeFired().add(new UIFire(fireball));
    }

    public void changeScreen(int level) {
        currPanel = levelPanels.get(level - 1);
        cardLayout.show(mainPanel, "level"+level);
//        frame.setContentPane(currPanel);
        for (KeyListener k : frame.getKeyListeners()) {
            frame.removeKeyListener(k);
        }
        frame.addKeyListener(currPanel);
        frame.repaint();
        frame.setVisible(true);
        frame.requestFocus();
    }
    public void gameOver(){
        for (KeyListener k : frame.getKeyListeners()) {
            frame.removeKeyListener(k);
        }
        frame.setContentPane(overPanel);
        frame.repaint();
        frame.setVisible(true);
        frame.requestFocusInWindow();
    }
    public void win(){
        for (KeyListener k : frame.getKeyListeners()) {
            frame.removeKeyListener(k);
        }
        frame.setContentPane(winPanel);
        frame.repaint();
        frame.setVisible(true);
        frame.requestFocusInWindow();
    }
}
