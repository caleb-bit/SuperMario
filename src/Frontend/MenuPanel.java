package Frontend;

import Backend.GameAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Frontend.FrontendManager.BACKGROUND_COLOR;

public class MenuPanel extends JPanel {
    private final GameAPI api;

    MenuPanel(GameAPI api) {
        this.api = api;
        initButtons(api);
    }

    private void initButtons(GameAPI api) {
        JPanel buttonPane = new JPanel();
        this.setLayout(new BorderLayout());
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonPane.add(Box.createHorizontalGlue());
        ArrayList<JButton> buttons = new ArrayList<>();
        JButton tutorialButton = new JButton("Tutorial");
        buttons.add(tutorialButton);
        tutorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                api.goToTutorial();
            }
        });
        for (int i = 1; i <= 4; i++) {
            JButton b = new JButton("Level " + i);
            buttons.add(b);
            int finalI = i;
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    api.startGame(finalI);
                }
            });
        }
        for (JButton b : buttons) {
            b.setAlignmentX(LEFT_ALIGNMENT);
            buttonPane.add(b);
        }
        this.add(buttonPane, BorderLayout.PAGE_END);
    }

    public void paintComponent(Graphics g) {
        int[] windowSize = api.getScreenSize();
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, windowSize[0], windowSize[1]);
        g.setColor(new Color(170, 74, 68));
        g.fillRect(0, 260, windowSize[0], windowSize[1]);
        g.setColor(Color.black);
        g.setFont(new Font("SansSerif", Font.BOLD, 35));
        g.drawString("Super Javario", 45, 100);

        drawMario(g);

    }

    private void drawMario(Graphics g) {
        int x = 300;
        int y = 300;
        //shoes
        g.setColor(new Color(255, 140, 17));
        g.fillOval(x + 2, y - 5, 21, 5);
        //body
        g.setColor(Color.blue);
        g.fillRect(x + 4, y - 29, 15, 25);
        //head
        g.setColor(new Color(255, 189, 93));
        g.fillRect(x + 1, y - 48, 20, 19);
        //hat
        g.setColor(Color.red);
        g.fillRect(x, y - 54, 23, 6);
        //face
        g.setColor(Color.black);
        g.fillRect(x + 13, y - 44, 2, 4);
        g.fillRect(x + 14, y - 38, 7, 3);
    }
}
