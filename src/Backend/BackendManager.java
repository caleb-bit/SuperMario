package Backend;

import java.util.*;

public class BackendManager {
    private ArrayList<Player> players;
    private ArrayList<Level> levels;
    private ArrayList<Map> maps;
    private int currLevel;
    private double timeLeft;

    BackendManager() {
        timeLeft = 180 * 1000;
        players = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            players.add(new Player(new GamePosition(0,0), 0, 0));
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

    public void updateTime(double increment) throws InterruptedException {
        timeLeft -= increment;
    }

    public Level getLevel(int level) {
        return levels.get(level - 1);
    }

    public int getCurr() {
        return currLevel;
    }

    public Land getCurrLand() {
        ArrayList<Land> lands = getLevel(currLevel).getMap().getLands();
        Land correctLand = null;
        for (Land land : lands) {
            if (land.getStartX() <= getPlayer().getX()
                    && getPlayer().getX() < land.getEndX()
                    && land.getEndY() <= getPlayer().getY()) {
                if (correctLand == null)
                    correctLand = land;
                else if (land.getStartY() > correctLand.getStartY())
                    correctLand = land;
            }
        }
        return correctLand;
    }

    public boolean playerOnGround() {
        return getPlayer().getY() == getCurrLand().getY();
    }

    public void updatePlayerPos(HashMap<Integer, Boolean> keysPressed) {
        getPlayer().move(keysPressed, getCurrLand());
    }

    public void play() {
        moveBalls();
        moveEnemies();
        for (GameObject obj : getLevel(getCurr()).getMap().getAllGameObjects()) {
            if (obj instanceof Enemy) {
                updateEnemy((Enemy)obj);
            } else if (obj instanceof Powerup){
                updatePowerup((Powerup) obj);
            } else if (obj instanceof Cliff) {
                updateCliff((Cliff) obj);
            } else if (obj instanceof Ledge) {
                updateLedge((Ledge)obj);
            } else if (obj instanceof Trap trap) {
                updateTrap(trap);
            }
            else if (obj instanceof Coin){
                updateCoin((Coin)obj);
            }
        }
    }

    private void updateCoin(Coin obj) {
        if (getPlayer().getX() >= obj.getX() && getPlayer().getX() <= obj.getX() + 1
                && getPlayer().getY() == obj.getY() && !obj.getTaken()){
            getPlayer().setCoins(getPlayer().getCoins() + 1);
            obj.setTaken(true);
        }
    }

    private void updateTrap(Trap trap) {
        if ((trap.leftX() <= getPlayer().getX()+getPlayer().getWidth()&& getPlayer().getX() <= trap.rightX())
                && (trap.bottomY() <= getPlayer().getY()+getPlayer().getHeight() && getPlayer().getY() <= trap.topY())
                && (getPlayer().getPower() == null || !(getPlayer().getPower().getName().equals("Invincibility")))) {
            getPlayer().die(getLevel(getCurr()).getMap().getPoints());
        }
        trap.setAngle(trap.getAngle() + 5 * Math.PI / 180);
    }

    private void updateLedge(Ledge ledge) {
        if (getPlayer().getX() >= ledge.getX() && getPlayer().getX() < ledge.getX() + ledge.getLength()) {
            if (getPlayer().getY() == ledge.getY() - 1 && getPlayer().getVelY() >= 0) {
                getPlayer().setVelY(-1);
            }
            if (getPlayer().getY() == ledge.getY() && getPlayer().getVelY() < 0) {
                getPlayer().setVelY(0);
            }
        }
    }

    private void updateCliff(Cliff cliff) {
        if (getPlayer().getX() >= cliff.getX() && getPlayer().getX() < cliff.getX() + cliff.getLength()) {
            if (getPlayer().getY() == 0) {
                getPlayer().die(getLevel(getCurr()).getMap().getPoints());
            }
        }
    }

    private void updatePowerup(Powerup powerup) {
        if (getPlayer().getX() >= powerup.getX() && getPlayer().getX() <= powerup.getX() + 1
                && getPlayer().getY() == powerup.getY() && !powerup.getTaken()){
            getPlayer().setPower(powerup);
            powerup.setTaken(true);
            System.out.println(getPlayer().getPower().getName());
        }
    }

    private void updateEnemy(Enemy enemy) {
        if (getPlayer().getX() >= enemy.getX() && getPlayer().getX() <= enemy.getX() + 1
                && getPlayer().getY() <= enemy.getY()+enemy.getHeight() && enemy.getAlive()) {
            if (getPlayer().getVelY() < 0 || (getPlayer().getPower() != null && getPlayer().getPower().getName().equals("Invincibility"))) {
                enemy.setAlive(false);
            } else {
                getPlayer().die(getLevel(getCurr()).getMap().getPoints());
            }
        }
    }

    private void moveEnemies() {
        for (Enemy enem : getLevel(getCurr()).getMap().getEnemies()) {
            if (enem.getAlive()) {
                for (Obstacle obs : getLevel(getCurr()).getMap().getObstacles()) {
                    if (obs instanceof Ledge && enem.getX() >= obs.getX() && enem.getX() < obs.getX() + obs.getLength()
                            && enem.getY() == obs.getY()) {
                        if (enem.getX() + enem.getVelX() > obs.getX() + obs.getLength() && enem.getVelX() == 0.5) {
                            enem.setVelX(-0.5);
                        }
                        if (enem.getX() + enem.getVelX() < obs.getX() && enem.getVelX() == -0.5) {
                            enem.setVelX(0.5);
                        }
                    }
                    if (obs instanceof Cliff && (enem.getX() < obs.getX() || enem.getX() >= obs.getX() + obs.getLength())) {
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

    private void moveBalls() {
        for (int i = 0; i < getPlayer().getBalls().size(); i++) {
            getPlayer().getBalls().get(i).move();
            for (GameObject obj : getLevel(getCurr()).getMap().getAllGameObjects()) {
                if (obj.getX() == getPlayer().getBalls().get(i).getX() && obj.getY() == getPlayer().getBalls().get(i).getY()) {
                    if (obj instanceof Enemy && ((Enemy) obj).getAlive()) {
                        ((Enemy) obj).setAlive(false);
                        getPlayer().getBalls().remove(i);
                        i--;
                        break;
                    }
                    else if (obj instanceof Obstacle) {
                        getPlayer().getBalls().remove(i);
                        i--;
                        break;
                    }
                }
            }
        }
    }
}
