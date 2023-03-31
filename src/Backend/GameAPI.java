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
    }

    public void openGame() {
        backend = new BackendManager();
        frontend = new FrontendManager(this);
        frontend.openGame();
    }

    public void startGame() {
        gameState = GameState.GAME;
        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            int delay = 1_000;
//            @Override
//            public void run() {
//                try {
//                    backend.updateTime(delay);
//                    frontend.updateScreen();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, delay, );

    }

    public GameState getGameState() {
        return gameState;
    }
}
