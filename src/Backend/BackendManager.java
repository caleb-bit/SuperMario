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
            getPlayer().setVelX(3);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            getPlayer().setVelX(-3);
        } else if (keyCode == KeyEvent.VK_UP) {
            if (getPlayer().getVelY() == 0 || getPlayer().getPower().getName().equals("Yoshi")) {
                getPlayer().setVelY(3);
                getPlayer().setAccelY(-0.5);
            }
        } else if (keyCode == KeyEvent.VK_SPACE && getPlayer().getPower().getName().equals("Flower")) {
            Fireball fire = new Fireball(getPlayer().getPosition());
        }
    }

    public void onKeyReleased(int keyCode) {
        if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT) {
            getPlayer().setVelX(0);
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

    public Land getCurrLand() {
        ArrayList<Land> lands = getLevel(currLevel).getMap().getLands();
        Land correctLand = null;
        for (Land land : lands) {
            if (land.getStartX() <= getPlayer().getX()
                    && getPlayer().getX() < land.getEndX()
                    && land.getY() <= getPlayer().getY()) {
                if (correctLand == null)
                    correctLand = land;
                else if (land.getY() > correctLand.getY())
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

    public void play(){
        for (Enemy enem: getLevel(getCurr()).getMap().getEnemies()){
            if (enem.getAlive()) {
                for (Obstacle obs : getLevel(getCurr()).getMap().getObstacles()) {
                    if (obs instanceof Ledge && enem.getX() >= obs.getX() && enem.getX() < obs.getX() + obs.getLength()
                            && enem.getY() == obs.getY() + 1) {
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
        for (GameObject obj: getLevel(getCurr()).getMap().getAllGameObjects()){
            if (obj instanceof Enemy){
                if (getPlayer().getX() == obj.getX() && getPlayer().getY() == obj.getY() && ((Enemy) obj).getAlive()){
                    if (getPlayer().getVelY() < 0 || getPlayer().getPower().getName().equals("Invincibility")){
                        ((Enemy) obj).setAlive(false);
                    }
                    else{
                        getPlayer().die(getLevel(getCurr()).getMap().getPoints());
                    }
                }
            }
            if (obj instanceof Powerup){
                if (getPlayer().getX() == obj.getX() && getPlayer().getY() == obj.getY() && !((Powerup) obj).getTaken()){
                    getPlayer().setPower((Powerup) obj);
                    ((Powerup) obj).setTaken(true);
                }
            }
            if (obj instanceof Cliff){
                if (getPlayer().getX() >= obj.getX() && getPlayer().getX() < obj.getX() + ((Cliff) obj).getLength()){
                    if (getPlayer().getY() == 0){
                        getPlayer().die(getLevel(getCurr()).getMap().getPoints());
                    }
                }
            }
            if (obj instanceof Ledge){
                if (getPlayer().getX() >= obj.getX() && getPlayer().getX() < obj.getX() + ((Ledge) obj).getLength()){
                    if (getPlayer().getY() == obj.getY()){
                        getPlayer().setVelY(-1);
                    }
                    if (getPlayer().getY() == obj.getY() + 1 && getPlayer().getVelY() < 0){
                        getPlayer().setVelY(0);
                    }
                }
            }
            if (obj instanceof Trap){
                if (((getPlayer().getX() >= obj.getX() && getPlayer().getX() < ((Trap) obj).getXMax()) ||
                        (getPlayer().getX() <= obj.getX() && getPlayer().getX() > ((Trap) obj).getXMax())) &&
                        ((getPlayer().getY() >= obj.getY() && getPlayer().getY() < ((Trap) obj).getYMax()) ||
                        (getPlayer().getY() <= obj.getY() && getPlayer().getY() > ((Trap) obj).getYMax()))){
                    getPlayer().die(getLevel(getCurr()).getMap().getPoints());
                }
                ((Trap)obj).setAngle(((Trap) obj).getAngle() + 20);
            }
            if (obj instanceof Coin){
                if (getPlayer().getX() == obj.getX() && getPlayer().getY() == obj.getY() && !((Coin) obj).getTaken()){
                    getPlayer().setCoins(getPlayer().getCoins() + 1);
                    ((Coin) obj).setTaken(true);
                }
            }
        }
    }
}
