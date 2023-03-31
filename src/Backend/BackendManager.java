package Backend;

import java.util.*;

public class BackendManager {
    private Player player;
    private Level[] levels;
    private Level currLevel;
    private double timeLeft;

    BackendManager() {
        player = new Player(new GamePosition(0, 0), 0, 0);
        timer = new Timer();
    }

    public Player getPlayer() {
        return player;
    }

    public double getTimeLeft() {
        return timeLeft;
    }

    public void onKeyPressed(int codeKey) {

    }

    public void updateTime(int increment) throws InterruptedException {
        while (timeLeft > 0) {
            Thread.sleep(1000);
            timeLeft -= 1;
        }
    }
}
