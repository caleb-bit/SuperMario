package Frontend;

import javax.swing.*;
import java.awt.*;

public class WinPanel extends JPanel {
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,500,500);
        g.setColor(Color.white);
        g.setFont(new Font("SansSerif", Font.BOLD, 30));
        g.drawString("You win!", 175,200);
    }
}
