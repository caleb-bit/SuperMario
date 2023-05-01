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
                    backend.play();
                    frontend.updateScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (getPlayer().getLives() == 0){
                    gameState = GameState.GAMEOVER;
                }
                if (getPlayer().getX() == backend.getLevel(backend.getCurr()).getMap().getPoints().get(
                        backend.getLevel(backend.getCurr()).getMap().getPoints().size() - 1).getX()){
                    gameState = GameState.MENU;
                }
                if (getPlayer().getPower() != null){
                    getPlayer().getPower().setDuration(getPlayer().getPower().getDuration() - delay);
                    if (getPlayer().getPower().getDuration() == 0){
                        getPlayer().setPower(null);
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
