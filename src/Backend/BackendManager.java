package Backend;

import java.util.*;

public class BackendManager {
    private final Player player;
    private Level[] levels;
    private Level currLevel;
    private double timeLeft;

    BackendManager() {
        player = new Player(new GamePosition(0, 0), 0, 0);
        timeLeft = 300;
    }

    public Player getPlayer() {
        return player;
    }

    public double getTimeLeft() {
        return timeLeft;
    }

    public void onKeyPressed(int codeKey) {

    }

    public void updateTime(double increment) throws InterruptedException {
        timeLeft -= increment;
    }

    public Level getLevel(int level) {
        return levels[level-1];
    }
}
