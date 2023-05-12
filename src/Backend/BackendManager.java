package Backend;

import java.util.*;

public class BackendManager {
    private ArrayList<Level> levels;
    private ArrayList<Map> maps;
    private Player player;

    // 1-indexed
    private int currLevel;

    private double timeLeft;
    private GameAPI gameAPI;

    BackendManager(GameAPI gameAPI) {
        this.gameAPI = gameAPI;
        timeLeft = 180 * 1000;
        player = new Player(new GamePosition(0, 0), 0, 0, gameAPI);
        maps = new ArrayList<>();
        maps.add(new Map1());
        maps.add(new Map2());
        maps.add(new Map3());
        maps.add(new Map4());
        levels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            levels.add(new Level(i, maps.get(i), player));
        }
        currLevel = 1;
    }

    public Player getPlayer() {
        return player;
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

    public int getLevel() {
        return currLevel;
    }

    public Land getCurrLand(double x1,double x2) {
        ArrayList<Land> lands = getLevel(currLevel).getMap().getLands();
        Land correctLand = null;
        for (Land land : lands) {
            double land_x1 = land.getStartX();
            double land_x2 = land.getEndX();
//            double x1 = getPlayer().getX();
//            double x2 = getPlayer().getX() + getPlayer().getWidth();
            if (((land_x1 <= x1 && x1 <= land_x1 + 1) || (land_x1 <= x2 && x2 <= land_x2 + 1))
                    && land.getBottomY() <= getPlayer().getY()) {
                if (correctLand == null)
                    correctLand = land;
                else if (land.getTopY() > correctLand.getTopY())
                    correctLand = land;
            }
        }
        return correctLand;
    }

    public Land getLandAbove() {
        ArrayList<Land> lands = getLevel(currLevel).getMap().getLands();
        Land correctLand = null;
        for (Land land : lands) {
            double land_x1 = land.getStartX();
            double land_x2 = land.getEndX();
            double player_x1 = getPlayer().getX();
            double player_x2 = getPlayer().getX() + getPlayer().getWidth();
            if (((land_x1 <= player_x1 && player_x1 <= land_x2) || (land_x1 <= player_x2 && player_x2 <= land_x2))
                    && land.getBottomY() >= getPlayer().getY() + getPlayer().getHeight()) {
                if (correctLand == null)
                    correctLand = land;
                else if (land.getBottomY() < correctLand.getBottomY())
                    correctLand = land;
            }
        }
        return correctLand;
    }

    public void updatePlayerPos(HashMap<Integer, Boolean> keysPressed) {
        getPlayer().move(keysPressed, getCurrLand(getPlayer().getX(),getPlayer().getX() + getPlayer().getWidth()), getLandAbove());
    }

    public void play() {
        moveBalls();
        moveEnemies();
        for (GameObject obj : getLevel(getLevel()).getMap().getAllGameObjects()) {
            if (obj instanceof Enemy) {
                updateEnemy((Enemy) obj);
            } else if (obj instanceof Powerup) {
                updatePowerup((Powerup) obj);
            } else if (obj instanceof Ledge) {
                updateLedge((Ledge) obj);
            } else if (obj instanceof Trap trap) {
                updateTrap(trap);
            } else if (obj instanceof Coin) {
                updateCoin((Coin) obj);
            }
        }
    }

    private void updateCoin(Coin obj) {
        if (getPlayer().getX() >= obj.getX() && getPlayer().getX() <= obj.getX() + 1
                && getPlayer().getY() == obj.getY() && !obj.getTaken()) {
            getPlayer().setCoins(getPlayer().getCoins() + 1);
            obj.setTaken(true);
        }
    }

    private void updateTrap(Trap trap) {
        if ((trap.leftX() <= getPlayer().getX() + getPlayer().getWidth() && getPlayer().getX() <= trap.rightX())
                && (trap.bottomY() <= getPlayer().getY() + getPlayer().getHeight() && getPlayer().getY() <= trap.topY())
                && (getPlayer().getPower() == null || !(getPlayer().getPower() instanceof Invincibility))) {
            die();
        }
        trap.setAngle(trap.getAngle() + 2 * Math.PI / 180);
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

    private void updatePowerup(Powerup powerup) {
        if (getPlayer().getX() >= powerup.getX() && getPlayer().getX() <= powerup.getX() + 1
                && getPlayer().getY() == powerup.getY() && !powerup.getTaken()) {
            getPlayer().setPower(powerup);
            powerup.setTaken(true);
        }
    }

    public void die() {
        getPlayer().die(getLevel(getLevel()).getMap().getPoints());
    }

    private void updateEnemy(Enemy enemy) {
        if (getPlayer().getX() >= enemy.getX() && getPlayer().getX() <= enemy.getX() + 2
                && getPlayer().getY() <= enemy.getY() + enemy.getHeight() && enemy.getAlive()) {
            if (getPlayer().getVelY() < 0 || (getPlayer().getPower() != null && getPlayer().getPower().getName().equals("Invincibility"))) {
                enemy.setAlive(false);
            } else {
                if (getPlayer().getPower() != null && getPlayer().getPower().getName().equals("Mushroom")) {
                    enemy.setAlive(false);
                }
                die();
            }
        }
    }

    private void moveEnemies() {
        for (Enemy enem : getLevel(getLevel()).getMap().getEnemies()) {
            if (enem.getAlive()) {
                for (Obstacle obs : getLevel(getLevel()).getMap().getObstacles()) {
                    if (obs instanceof Ledge && enem.getX() >= obs.getX() && enem.getX() < obs.getX() + obs.getLength()
                            && enem.getY() == obs.getY()) {
                        if (enem.getX() + enem.getVelX() > obs.getX() + obs.getLength() && enem.getVelX() == 0.1) {
                            enem.setVelX(-0.1);
                        }
                        if (enem.getX() + enem.getVelX() < obs.getX() && enem.getVelX() == -0.1) {
                            enem.setVelX(0.1);
                        }
                    }
                    if (obs instanceof Cliff) {
                        if (enem.getX() < obs.getX() && enem.getX() + enem.getVelX() >= obs.getX() && enem.getVelX() == 0.1) {
                            enem.setVelX(-0.1);
                        }
                        if (enem.getX() >= obs.getX() + obs.getLength() &&
                                enem.getX() + enem.getVelX() < obs.getX() + obs.getLength() && enem.getVelX() == -0.1) {
                            enem.setVelX(0.1);
                        }
                    }
                }
                if (enem.getX() + enem.getVelX() >= enem.getInitial().getX() + 3 && enem.getVelX() == 0.1) {
                    enem.setVelX(-0.1);
                }
                if (enem.getX() + enem.getVelX() <= enem.getInitial().getX() - 3 && enem.getVelX() == -0.1) {
                    enem.setVelX(0.1);
                }
                enem.move();
            }
        }
    }

    private void moveBalls() {
        for (int i = 0; i < getPlayer().getBalls().size(); i++) {
            Fireball ball = getPlayer().getBalls().get(i);
            ball.move();
            for (GameObject obj : getLevel(getLevel()).getMap().getAllGameObjects()) {
                if (ball.getX() >= obj.getX() && ball.getX() <= obj.getX() + 1
                        && ball.getY() <= obj.getY()) {
                    if (obj instanceof Enemy && ((Enemy) obj).getAlive()) {
                        ((Enemy) obj).setAlive(false);
                        getPlayer().getBalls().remove(i);
                        gameAPI.removeBall(ball);
                        i--;
                        break;
                    } else if (obj instanceof Obstacle && !(obj instanceof Cliff)) {
                        getPlayer().getBalls().remove(i);
                        i--;
                        break;
                    }
                }
            }
        }
    }
    

    public void setLevel(int level) {
        this.currLevel = level;
    }

    public int lowestY() {
        return maps.get(currLevel - 1).lowestLandY();
    }
}
