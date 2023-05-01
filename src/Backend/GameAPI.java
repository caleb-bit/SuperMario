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
                if (backend.getPlayer().getLives() == 0){
                    gameState = GameState.GAMEOVER;
                }
                for (Enemy enem: backend.getLevel(backend.getCurr()).getMap().getEnemies()){
                    for (Obstacle obs: backend.getLevel(backend.getCurr()).getMap().getObstacles()){
                        if (obs instanceof Ledge && enem.getX() >= obs.getX() && enem.getX() <= obs.getX() + obs.getLength()
                         && enem.getY() == obs.getY() + 1){
                            if (enem.getX() + enem.getVelX() > obs.getX() + obs.getLength() && enem.getVelX() == 0.5){
                                enem.setVelX(-0.5);
                            }
                            if (enem.getX() + enem.getVelX() < obs.getX() && enem.getVelX() == -0.5){
                                enem.setVelX(0.5);
                            }
                        }
                        if (obs instanceof Cliff && (enem.getX() < obs.getX() || enem.getX() > obs.getX() + obs.getLength())){
                            if (enem.getX() + enem.getVelX() >= obs.getX() && enem.getVelX() == 0.5){
                                enem.setVelX(-0.5);
                            }
                            if (enem.getX() + enem.getVelX() < obs.getX() + obs.getLength() && enem.getVelX() == -0.5){
                                enem.setVelX(0.5);
                            }
                        }
                    }
                    enem.move();
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
