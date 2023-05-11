package Frontend;
import Backend.Powerup;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Header{
    public static void drawHeader(BufferedImage image, int timeLeft, int coins, Powerup power){
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setBackground(new Color(0,0,0,0));
        graphics.clearRect(0,0,720,30);
        //TODO: Draw the header
        graphics.setColor(new Color(255,255,255,126));
        graphics.fillRect(0,0,720,30);
        graphics.setColor(new Color(0,0,0,255));
        graphics.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
        graphics.drawString("Time Left: " + (timeLeft),10,22);
        graphics.drawString("Coins: " + coins, 300, 22);
        graphics.drawString("Powerup: "+ (power == null ? "None": power.getName()), 570,22);
    }
}