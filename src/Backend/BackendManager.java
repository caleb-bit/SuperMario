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
        levels = new Level[]{new Level(1, new Map1()), new Level(2, new Map2()), new Level(3, new Map3()),
                new Level(4, new Map4())};
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
        if (keyCode == 38 && (player.getVelY() == 0 || player.getPower().getName().equals("Yoshi"))){
            player.setVelY(1);
        }
        if (keyCode == 32 && player.getPower().getName().equals("Flower")){
            Fireball fire = new Fireball(player.getPosition());
        }
    }
    public void updateTime(double increment) throws InterruptedException {
        timeLeft -= increment;
    }

    public Level getLevel(int level) {
        return levels[level-1];
    }
    public void playGame(){
        
    }
}
