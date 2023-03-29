<<<<<<< Updated upstream:src/Backend/BackendManager.java
package Backend;

=======
import java.util.*;
>>>>>>> Stashed changes:src/BackendManager.java
public class BackendManager {
    private Player player;
    private Level[] levels;
    private Level currLevel;
    private int timeLeft;
    BackendManager(){
        player = new Player(new GamePosition(0, 0), 0, 0);
        timer = new Timer();
    }
    public Player getPlayer(){
        return player;
    }
    public int getTimeLeft(){
        return timeLeft;
    }
    public void onKeyPressed(int codeKey){

    }
    public void updateTime() throws InterruptedException {
        while (timeLeft > 0){
            Thread.sleep(1000);
            timeLeft -= 1;
        }
    }
}
