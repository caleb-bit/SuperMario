package Backend;

import java.util.*;

public class BackendManager {
    private ArrayList<Player> players;
    private ArrayList<Level> levels;
    private ArrayList<Map> maps;
    private int currLevel;
    private double timeLeft;

    BackendManager() {
        timeLeft = 300;
        players = new ArrayList<>();
        for (int i=0; i<4; i++) {
            players.add(new Player(0,0,0,0));
        }
        maps = new ArrayList<>();
        maps.add(new Map1());
        maps.add(new Map2());
        maps.add(new Map3());
        maps.add(new Map4());
        levels = new ArrayList<>();
        for (int i=1; i<=4; i++) {
            levels.add(new Level(i,maps.get(0),players.get(0)));
        }
        currLevel = 1;
    }
    public Player getPlayer(){
        return players.get(currLevel-1);
    }

    public double getTimeLeft() {
        return timeLeft;
    }

    public void onKeyPressed(int keyCode) {
        if (keyCode == 39){
            getPlayer().setVelX(1);
        }
        if (keyCode == 37){
            getPlayer().setVelX(-1);
        }
        if (keyCode == 38){
            if (getPlayer().getVelY() == 0 || getPlayer().getPower().getName().equals("Yoshi")) {
                getPlayer().setVelY(1);
            }
        }
        if (keyCode == 32 && getPlayer().getPower().getName().equals("Flower")){
            Fireball fire = new Fireball(getPlayer().getPosition());
        }
    }
    public void updateTime(double increment) throws InterruptedException {
        timeLeft -= increment;
    }

    public Level getLevel(int level) {
        return levels.get(level-1);
    }
}
