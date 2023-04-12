package Frontend;

import Backend.BackendManager;
import Backend.GameAPI;
import Backend.GameObject;

import java.awt.*;

public class Level1Panel extends LevelPanel{
    public Level1Panel(GameObject[] gameObjects, GameAPI gameAPI) {
        super(gameObjects, gameAPI);
    }

    public void paintComponent(Graphics g){
        // draw background here
        super.paintComponent(g);
    }
}
