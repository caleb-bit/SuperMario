package Testers;

import Frontend.TutorialPanel;

import javax.swing.*;
import java.awt.*;

public class PanelTester {
    public static void main(String[] args) {
        JPanel panel = new TutorialPanel(new int[]{500,500});
        JFrame frame = new JFrame("Panel Tester");
        frame.setContentPane(panel);
        frame.setPreferredSize(new Dimension(500,500));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
