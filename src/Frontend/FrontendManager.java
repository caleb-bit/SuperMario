package Frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrontendManager {
    private JFrame frame;
    private ArrayList<LevelPanel> levelPanels;
    private JPanel currPanel;

    FrontendManager() {
        levelPanels = new ArrayList<>();
        levelPanels.add(new Level1Panel());
        currPanel = levelPanels.get(0);
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
