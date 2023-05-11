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
    }

    public void openGame() {
        backend = new BackendManager(this);
        frontend = new FrontendManager(this);
        frontend.openGame();
        gameState = GameState.MENU;
    }

    public void startGame(int level) {
        gameState = GameState.GAME;
        backend.setLevel(level);
        frontend.changeScreen(level);
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
                if (backend.getTimeLeft() <= 0) {
                    frontend.gameOver();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    openGame();
                }
                if (getPlayer().getX() >= backend.getLevel(backend.getLevel()).getMap().getPoints().get(
                        backend.getLevel(backend.getLevel()).getMap().getPoints().size() - 1).getX()) {
                    backend.getLevel(backend.getLevel()).setComplete(true);
                    frontend.win();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    openGame();
                    return;
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

    public void fireballFired(Fireball fireball) {
        frontend.fireballFired(fireball);
    }
    public BackendManager getBackend(){
        return backend;
    }
}
