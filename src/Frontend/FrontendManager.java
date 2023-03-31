package Frontend;

import Backend.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrontendManager {
    private JFrame frame;
    private ArrayList<LevelPanel> levelPanels;
    private JPanel currPanel;
    private GameAPI api;

    public FrontendManager(GameAPI api) {
        levelPanels = new ArrayList<>();
        levelPanels.add(new Level1Panel(api.getGameObjects(1), api));
        currPanel = levelPanels.get(0);
        this.api = api;
    }

    public void openGame() {
        frame = new JFrame("SuperMario");
        frame.setContentPane(currPanel);
        frame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        frame.pack();
        frame.setVisible(true);
    }

    public void updateScreen() {
        frame.repaint();
    }
}
