package Backend;

import Frontend.FrontendManager;
import Frontend.UIPosition;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameAPI {
    private BackendManager backend;
    private FrontendManager frontend;

    enum GameState {MENU, GAME, GAMEOVER}

    private GameState gameState;

    public static void main(String[] args) {
        GameAPI gameAPI = new GameAPI();
        gameAPI.openGame();
        gameAPI.startGame();
    }

    public void openGame() {
        backend = new BackendManager();
        frontend = new FrontendManager(this);
        frontend.openGame();
        gameState = GameState.MENU;
    }

    public void startGame() {
        gameState = GameState.GAME;
        Timer timer = new Timer();
        int delay = 1_000;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    backend.updateTime(delay);
                    frontend.updateScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (getPlayer().getLives() == 0){
                    gameState = GameState.GAMEOVER;
                }
                if (getPlayer().getPower() != null){
                    getPlayer().getPower().setDuration(getPlayer().getPower().getDuration() - delay);
                    if (getPlayer().getPower().getDuration() == 0){
                        getPlayer().setPower(null);
                    }
                }
                for (Enemy enem: backend.getLevel(backend.getCurr() - 1).getMap().getEnemies()){
                    if (enem.getAlive()) {
                        for (Obstacle obs : backend.getLevel(backend.getCurr() - 1).getMap().getObstacles()) {
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
                for (GameObject obj: backend.getLevel(backend.getCurr() - 1).getMap().getAllGameObjects()){
                    if (obj instanceof Enemy){
                        if (getPlayer().getX() == obj.getX() && getPlayer().getY() == obj.getY() && ((Enemy) obj).getAlive()){
                            if (getPlayer().getVelY() < 0){
                                ((Enemy) obj).setAlive(false);
                            }
                            else{
                                getPlayer().die(backend.getLevel(backend.getCurr() - 1).getMap().getPoints());
                            }
                        }
                    }
                    if (obj instanceof Powerup){
                        if (getPlayer().getX() == obj.getX() && getPlayer().getY() == obj.getY() && !((Powerup) obj).getTaken()){
                            getPlayer().setPower((Powerup) obj);
                        }
                    }
                    if (obj instanceof Cliff){
                        if (getPlayer().getX() >= obj.getX() && getPlayer().getX() < obj.getX() + ((Cliff) obj).getLength()){
                            if (getPlayer().getY() == 0){
                                getPlayer().die(backend.getLevel(backend.getCurr() - 1).getMap().getPoints());
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
                        obj.setAngle(getAngle() + 20);
                    }
                }
            }
        }, delay, delay);
    }

    public void keyPressed(int keyCode) {
        backend.onKeyPressed(keyCode);
    }

    public void updateScreen(){
        frontend.updateScreen();
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public ArrayList<GameObject> getGameObjects(int level) {
        return backend.getLevel(level).getMap().getAllGameObjects();
    }

    public Player getPlayer() {
        return backend.getPlayer();
    }

    public GamePosition getPlayerGamePos() {
        return backend.getPlayer().getPosition();
    }

    public UIPosition getPlayerUIPos() {
        return frontend.getPlayerUIPos();
    }
}
