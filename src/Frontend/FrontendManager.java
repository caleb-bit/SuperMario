package Frontend;

import Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class FrontendManager {
    private JFrame frame;
    private ArrayList<LevelPanel> levelPanels;
    private LevelPanel currPanel;
    private GameAPI api;
    // matches key code with pressed status
    private HashMap<Integer, Boolean> keysPressed;

    public FrontendManager(GameAPI api) {
        levelPanels = new ArrayList<>();
        keysPressed = new HashMap<>();
        keysPressed.put(KeyEvent.VK_LEFT, false);
        keysPressed.put(KeyEvent.VK_RIGHT, false);
        keysPressed.put(KeyEvent.VK_UP, false);
        keysPressed.put(KeyEvent.VK_DOWN, false);
        keysPressed.put(KeyEvent.VK_SPACE, false);
        levelPanels.add(new Level1Panel(api.getGameObjects(1), api));
        currPanel = levelPanels.get(0);
        this.api = api;
    }

    public void openGame() {
        frame = new JFrame("SuperMario");
        frame.setContentPane(currPanel);
//        frame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(currPanel);
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

    public HashMap<Integer, Boolean> getKeysPressed(){
        return keysPressed;
    }
}
