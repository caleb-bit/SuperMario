package Frontend;

import Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

public class FrontendManager {
    public static Color BACKGROUND_COLOR = new Color(48, 220, 255);
    private JFrame frame;
    private ArrayList<LevelPanel> levelPanels;
    private CardLayout cardLayout;

    // contains all panels
    private JPanel mainPanel;

    private LevelPanel currPanel;
    private GameAPI api;

    // matches key code with pressed status
    private HashMap<Integer, Boolean> keysPressed;

    public static final double SCALE = 20.0;
    private final int[] screenSize;
    private MenuPanel menuPanel;
    private GameOverPanel overPanel;
    private WinPanel winPanel;
    private TutorialPanel tutorialPanel;

    public FrontendManager(GameAPI api) {
        this.api = api;
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        screenSize = new int[]{500, 500};
        keysPressed = new HashMap<>();
        initPanels();
        resetKeysPressed();
    }

    private void resetKeysPressed() {
        keysPressed.put(KeyEvent.VK_LEFT, false);
        keysPressed.put(KeyEvent.VK_RIGHT, false);
        keysPressed.put(KeyEvent.VK_UP, false);
        keysPressed.put(KeyEvent.VK_DOWN, false);
        keysPressed.put(KeyEvent.VK_SPACE, false);
    }

    public void initPanels() {
        overPanel = new GameOverPanel();
        winPanel = new WinPanel();
        menuPanel = new MenuPanel(api);
        tutorialPanel = new TutorialPanel(api);
        levelPanels = new ArrayList<>();
        mainPanel.add(menuPanel, "menu");
        for (int i = 1; i <= 4; i++) {
            LevelPanel lp = new LevelPanel(api.getGameObjects(i), api, api.getBackend());
            levelPanels.add(lp);
            mainPanel.add(lp, "level" + i);
        }
        currPanel = levelPanels.get(0);
        mainPanel.add(overPanel, "over");
        mainPanel.add(winPanel, "win");
        mainPanel.add(tutorialPanel, "tutorial");
        cardLayout.show(mainPanel, "menu");
    }

    public void openGame() {
        frame = new JFrame("Super Javario");
        frame.setContentPane(mainPanel);
        frame.setPreferredSize(new Dimension(screenSize[0], screenSize[1]));
        frame.pack();
        frame.setVisible(true);
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

    public static double convertGameToUI(double x) {
        return x * SCALE;
    }

    public void fireballFired(Fireball fireball) {
        currPanel.getBallsToBeFired().add(new UIFire(fireball, currPanel));
    }

    public void changeScreen(int level) {
        currPanel = levelPanels.get(level - 1);
        cardLayout.show(mainPanel, "level" + level);
        resetFrame();
        frame.addKeyListener(currPanel);
    }

    public void gameOver() {
        cardLayout.show(mainPanel, "over");
        resetFrame();
    }

    private void resetFrame() {
        for (KeyListener k : frame.getKeyListeners()) {
            frame.removeKeyListener(k);
        }
        frame.repaint();
        frame.setVisible(true);
        frame.requestFocusInWindow();
    }

    public void win() {
        cardLayout.show(mainPanel, "win");
        resetFrame();
    }


    public void reset() {
        initPanels();
        resetKeysPressed();
        resetFrame();
    }

    public void openTutorial() {
        cardLayout.show(mainPanel, "tutorial");
        resetFrame();
    }

    public void goToMenu() {
        cardLayout.show(mainPanel, "menu");
        resetFrame();
    }

    public void removeBall(Fireball fireball) {
        currPanel.removeBall(fireball);
    }
}
