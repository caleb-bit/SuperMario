package Backend;

import java.util.ArrayList;
import java.util.Arrays;

public class Map1 extends Map {
    Map1() {
        ArrayList<GameObject> gameObjects = new ArrayList<>();
        ArrayList<GamePosition> gamePositions = new ArrayList<>();
        gameObjects.add(new Goomba(new GamePosition(5, 1)));
        gameObjects.add(new Goomba(new GamePosition(15, 1)));
        gameObjects.add(new Koopa(new GamePosition(30, 1)));
        gameObjects.add(new Goomba(new GamePosition(40, 1)));
        gameObjects.add(new Flower(new GamePosition(10, 1)));
        gameObjects.add(new Mushroom(new GamePosition(25, 1)));
        gameObjects.add(new Invincibility(new GamePosition(35, 1)));
        gameObjects.add(new Yoshi(new GamePosition(45, 1)));
        gameObjects.add(new Ledge(new GamePosition(20, 3), 3));
        gameObjects.add(new Trap(new GamePosition(43, 3), 1));
        gameObjects.add(new Cliff(new GamePosition(50, 0), 4));
        gameObjects.add(new Coin(new GamePosition(6, 1)));
        gameObjects.add(new Coin(new GamePosition(21, 4)));
        gameObjects.add(new Coin(new GamePosition(32, 1)));
        gameObjects.add(new Coin(new GamePosition(47, 1)));
        gamePositions.add(new GamePosition(20, 0));
        gamePositions.add(new GamePosition(40, 0));
        gamePositions.add(new GamePosition(55, 0));
        initObjects(gameObjects, gamePositions);
    }
}
