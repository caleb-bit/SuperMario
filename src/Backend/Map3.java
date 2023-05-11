package Backend;

import java.util.ArrayList;
import java.util.Arrays;

public class Map3 extends Map{
    Map3(){
        ArrayList<GameObject> gameObjects = new ArrayList<>();
        ArrayList<GamePosition> gamePositions = new ArrayList<>();
        gameObjects.add(new Land(0,100,0,-5));
        gameObjects.add(new Koopa(new GamePosition(13, 6)));
        gameObjects.add(new Goomba(new GamePosition(20, 6)));
        gameObjects.add(new Goomba(new GamePosition(21, 6)));
        gameObjects.add(new Goomba(new GamePosition(35, 6)));
        gameObjects.add(new Koopa(new GamePosition(50, 3)));
        gameObjects.add(new Koopa(new GamePosition(62, 0)));
        gameObjects.add(new Cliff(new GamePosition(5, 0), 33));
        gameObjects.add(new Ledge(new GamePosition(7, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(10, 3), 4));
        gameObjects.add(new Ledge(new GamePosition(11, 6), 3));
        gameObjects.add(new Ledge(new GamePosition(14, 0), 1));
        gameObjects.add(new Ledge(new GamePosition(16, 3), 2));
        gameObjects.add(new Ledge(new GamePosition(18, 6), 4));
        gameObjects.add(new Ledge(new GamePosition(22, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(24, 6), 2));
        gameObjects.add(new Ledge(new GamePosition(25, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(26, 6), 2));
        gameObjects.add(new Ledge(new GamePosition(28, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(30, 3), 1));
        gameObjects.add(new Ledge(new GamePosition(32, 6), 4));
        gameObjects.add(new Ledge(new GamePosition(38, 3), 2));
        gameObjects.add(new Ledge(new GamePosition(41, 3), 2));
        gameObjects.add(new Ledge(new GamePosition(44, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(47, 3), 4));
        gameObjects.add(new Ledge(new GamePosition(51, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(54, 3), 2));
        gameObjects.add(new Ledge(new GamePosition(57, 3), 2));
        gameObjects.add(new Coin(new GamePosition(10, 6)));
        gameObjects.add(new Coin(new GamePosition(11, 6)));
        gameObjects.add(new Coin(new GamePosition(12, 6)));
        gameObjects.add(new Coin(new GamePosition(14, 0)));
        gameObjects.add(new Coin(new GamePosition(16, 6)));
        gameObjects.add(new Coin(new GamePosition(17, 6)));
        gameObjects.add(new Coin(new GamePosition(22, 3)));
        gameObjects.add(new Coin(new GamePosition(23, 3)));
        gameObjects.add(new Coin(new GamePosition(26, 6)));
        gameObjects.add(new Coin(new GamePosition(27, 6)));
        gameObjects.add(new Coin(new GamePosition(38, 3)));
        gameObjects.add(new Coin(new GamePosition(39, 3)));
        gameObjects.add(new Coin(new GamePosition(41, 3)));
        gameObjects.add(new Coin(new GamePosition(42, 3)));
        gameObjects.add(new Coin(new GamePosition(44, 3)));
        gameObjects.add(new Coin(new GamePosition(45, 3)));
        gameObjects.add(new Coin(new GamePosition(51, 0)));
        gameObjects.add(new Coin(new GamePosition(52, 0)));
        gameObjects.add(new Coin(new GamePosition(56, 6)));
        gameObjects.add(new Coin(new GamePosition(57, 6)));
        gamePositions.add(new GamePosition(30, 0));
        gamePositions.add(new GamePosition(65, 0));
        initObjects(gameObjects, gamePositions);
    }
}
