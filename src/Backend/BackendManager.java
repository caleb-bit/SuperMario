package Backend;

import java.awt.event.KeyEvent;
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
        for (int i = 0; i < 4; i++) {
            players.add(new Player(0, 0, 0, 0));
        }
        maps = new ArrayList<>();
        maps.add(new Map1());
        maps.add(new Map2());
        maps.add(new Map3());
        maps.add(new Map4());
        levels = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            levels.add(new Level(i, maps.get(0), players.get(0)));
        }
        currLevel = 1;
    }

    public Player getPlayer() {
        return players.get(currLevel - 1);
    }

    public double getTimeLeft() {
        return timeLeft;
    }

    public void onKeyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_RIGHT) {
            getPlayer().setVelX(1);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            getPlayer().setVelX(-1);
        } else if (keyCode == KeyEvent.VK_UP) {
            if (getPlayer().getVelY() == 0 || getPlayer().getPower().getName().equals("Yoshi")) {
                getPlayer().setVelY(1);
            }
        } else if (keyCode == KeyEvent.VK_SPACE && getPlayer().getPower().getName().equals("Flower")) {
            Fireball fire = new Fireball(getPlayer().getPosition());
        }
    }

    public void onKeyReleased(int keyCode) {
        if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT) {
            getPlayer().setVelX(0);
        } else if (keyCode == KeyEvent.VK_UP) {
            getPlayer().setAccelY(0);
        }
    }

    public void updateTime(double increment) throws InterruptedException {
        timeLeft -= increment;
    }

    public Level getLevel(int level) {
        return levels.get(level - 1);
    }

    public int getCurr() {
        return currLevel;
    }

    public void updatePositions() {
        getPlayer().move();
        updateEnemies();
    }

    private void updateEnemies() {
        for (Enemy enem : getLevel(getCurr()).getMap().getEnemies()) {
            for (Obstacle obs : getLevel(getCurr()).getMap().getObstacles()) {
                if (obs instanceof Ledge && enem.getX() >= obs.getX() && enem.getX() <= obs.getX() + obs.getLength()
                        && enem.getY() == obs.getY() + 1) {
                    if (enem.getX() + enem.getVelX() > obs.getX() + obs.getLength() && enem.getVelX() == 0.5) {
                        enem.setVelX(-0.5);
                    }
                    if (enem.getX() + enem.getVelX() < obs.getX() && enem.getVelX() == -0.5) {
                        enem.setVelX(0.5);
                    }
                }
                if (obs instanceof Cliff && (enem.getX() < obs.getX() || enem.getX() > obs.getX() + obs.getLength())) {
                    if (enem.getX() + enem.getVelX() >= obs.getX() && enem.getVelX() == 0.5) {
                        enem.setVelX(-0.5);
                    }
                    if (enem.getX() + enem.getVelX() < obs.getX() + obs.getLength() && enem.getVelX() == -0.5) {
                        enem.setVelX(0.5);
                    }
                }
            }
            enem.move();
        }
    }
}
