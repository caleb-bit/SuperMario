package Backend;

import java.util.ArrayList;
import java.util.Arrays;

public class Map2 extends Map{
    Map2(){
        ArrayList<GameObject> gameObjects = new ArrayList<>();
        ArrayList<GamePosition> gamePositions = new ArrayList<>();

        GamePosition[] checkPoints = new GamePosition[2];
        gameObjects.add(new Goomba(new GamePosition(5, 1)));
        gameObjects.add(new Goomba(new GamePosition(10, 1)));
        gameObjects.add(new Goomba(new GamePosition(15, 1)));
        gameObjects.add(new Goomba(new GamePosition(16, 1)));
        gameObjects.add(new Goomba(new GamePosition(25, 11)));
        gameObjects.add(new Goomba(new GamePosition(26, 11)));
        gameObjects.add(new Goomba(new GamePosition(33, 1)));
        gameObjects.add(new Goomba(new GamePosition(34, 1)));
        gameObjects.add(new Koopa(new GamePosition(38, 1)));
        gameObjects.add(new Goomba(new GamePosition(43, 1)));
        gameObjects.add(new Goomba(new GamePosition(44, 1)));
        gameObjects.add(new Goomba(new GamePosition(45, 1)));
        gameObjects.add(new Goomba(new GamePosition(46, 1)));
        gameObjects.add(new Goomba(new GamePosition(47, 1)));
        gameObjects.add(new Goomba(new GamePosition(48, 1)));
        gameObjects.add(new Goomba(new GamePosition(60, 1)));
        gameObjects.add(new Goomba(new GamePosition(61, 1)));
        gameObjects.add(new Flower(new GamePosition(4, 6)));
        gameObjects.add(new Mushroom(new GamePosition(20, 6)));
        gameObjects.add(new Mushroom(new GamePosition(24, 6)));
        gameObjects.add(new Invincibility(new GamePosition(36, 6)));
        gameObjects.add(new Ledge(new GamePosition(3, 5), 3));
        gameObjects.add(new Cliff(new GamePosition(21, 0), 1));
        gameObjects.add(new Ledge(new GamePosition(22, 5), 2));
        gameObjects.add(new Ledge(new GamePosition(25, 10), 5));
        gameObjects.add(new Cliff(new GamePosition(30, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(31, 5), 2));
        gameObjects.add(new Ledge(new GamePosition(35, 5), 1));
        gameObjects.add(new Ledge(new GamePosition(42, 5), 1));
        gameObjects.add(new Ledge(new GamePosition(44, 10), 2));
        gameObjects.add(new Ledge(new GamePosition(47, 10), 3));
        gameObjects.add(new Ledge(new GamePosition(48, 5), 1));
        gameObjects.add(new Cliff(new GamePosition(53, 0), 1));
        gameObjects.add(new Ledge(new GamePosition(56, 5), 3));
        gameObjects.add(new Coin(new GamePosition(3, 5)));
        gameObjects.add(new Coin(new GamePosition(4, 10)));
        gameObjects.add(new Coin(new GamePosition(5, 6)));
        gameObjects.add(new Coin(new GamePosition(32, 5)));
        gameObjects.add(new Coin(new GamePosition(38, 5)));
        gameObjects.add(new Coin(new GamePosition(48, 11)));
        gameObjects.add(new Coin(new GamePosition(57, 6)));
        gamePositions.add(new GamePosition(0, 0));
        gamePositions.add(new GamePosition(19, 0));
        gamePositions.add(new GamePosition(65, 0));
        initObjects(gameObjects, gamePositions);
    }
}
