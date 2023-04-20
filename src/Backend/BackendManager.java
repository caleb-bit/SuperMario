package Backend;

import java.util.*;

public class BackendManager {
    private Player player;
    private Level[] levels;
    private Level currLevel;
    private double timeLeft;

    BackendManager() {
        player = new Player(new GamePosition(0, 0), 0, 0);
        timeLeft = 300;
        levels = new Level[]{new Level1(), new Level2(), new Level3(), new Level4()};
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }

    public double getTimeLeft() {
        return timeLeft;
    }

    public void onKeyPressed(int keyCode) {
        if (keyCode == 39){
            player.setVelX(1);
        }
        if (keyCode == 37){
            player.setVelX(-1);
        }
        if (keyCode == 38){
            player.setVelY(1);
        }
        if (keyCode == 32 && player.getPower().getName().equals("Flower")){

        }
    }
    public void updateTime(double increment) throws InterruptedException {
        timeLeft -= increment;
    }

    public Level getLevel(int level) {
        return levels[level-1];
    }
}
