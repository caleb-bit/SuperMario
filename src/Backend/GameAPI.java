package Backend;

import Frontend.FrontendManager;
import Frontend.UIPosition;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameAPI {
    private BackendManager backend;
    private FrontendManager frontend;

    public int[] getScreenSize() {
        return frontend.getScreenSize();
    }

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
        int delay = 60;
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
                if (backend.getPlayer().getLives() == 0) {
                    gameState = GameState.GAMEOVER;
                }
                if (getPlayer().getX() >= backend.getLevel(backend.getLevel()).getMap().getPoints().get(
                        backend.getLevel(backend.getLevel()).getMap().getPoints().size() - 1).getX()) {
                    backend.getLevel(backend.getLevel()).setComplete(true);
                    gameState = GameState.MENU;
                }
                if (getPlayer().getPower() != null) {
                    getPlayer().getPower().setDuration(getPlayer().getPower().getDuration() - delay);
                    if (getPlayer().getPower().getDuration() <= 0) {
                        getPlayer().setPower(null);
                    }
                }
                backend.updatePlayerPos(frontend.getKeysPressed());
            }
        }, delay, delay);
    }

    public void keyPressed(int keyCode) {
        frontend.keyPressed(keyCode);
    }

    public void keyReleased(int keyCode) {
        frontend.keyReleased(keyCode);
    }


    public void updateScreen() {
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
