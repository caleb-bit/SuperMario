package Backend;

import Frontend.FrontendManager;

import java.util.Timer;
import java.util.TimerTask;

public class GameAPI {
    private BackendManager backend;
    private FrontendManager frontend;

    enum GameState {MENU, GAME, DEAD, GAMEOVER}

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

    public GameObject[] getGameObjects(int level) {
        return backend.getLevel(level).getMap().getAllGameObjects();
    }
}