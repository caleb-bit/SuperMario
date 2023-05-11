package Frontend;

import Backend.GameAPI;
import Backend.Land;
import Backend.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Frontend.LevelPanel.BACKGROUND_COLOR;

public class MenuPanel extends JPanel {
    private GameAPI api;

    MenuPanel(GameAPI api) {
        this.api = api;
        JPanel buttonPane = new JPanel();
        this.setLayout(new BorderLayout());
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));
        buttonPane.add(Box.createHorizontalGlue());
        JButton button1 = new JButton("Level 1");
        JButton button2 = new JButton("Level 2");
        JButton button3 = new JButton("Level 3");
        JButton button4 = new JButton("Level 4");
        buttonPane.add(button1);
        buttonPane.add(button2);
        buttonPane.add(button3);
        buttonPane.add(button4);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                api.startGame(1);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                api.startGame(2);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                api.startGame(3);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                api.startGame(4);
            }
        });
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
