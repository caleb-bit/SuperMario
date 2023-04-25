package Backend;

import java.util.ArrayList;
import java.util.Arrays;

public class Map3 extends Map{
    Map3(){
        ArrayList<GameObject> gameObjects = new ArrayList<>();
        ArrayList<GamePosition> gamePositions = new ArrayList<>();

        gameObjects.add(new Koopa(new GamePosition(13, 11)));
        gameObjects.add(new Goomba(new GamePosition(20, 11)));
        gameObjects.add(new Goomba(new GamePosition(21, 11)));
        gameObjects.add(new Goomba(new GamePosition(35, 11)));
        gameObjects.add(new Koopa(new GamePosition(50, 6)));
        gameObjects.add(new Koopa(new GamePosition(62, 0)));
        gameObjects.add(new Cliff(new GamePosition(5, 0), 33));
        gameObjects.add(new Ledge(new GamePosition(7, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(10, 5), 4));
        gameObjects.add(new Ledge(new GamePosition(11, 10), 3));
        gameObjects.add(new Ledge(new GamePosition(14, 0), 1));
        gameObjects.add(new Ledge(new GamePosition(16, 5), 2));
        gameObjects.add(new Ledge(new GamePosition(18, 10), 4));
        gameObjects.add(new Ledge(new GamePosition(22, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(24, 10), 2));
        gameObjects.add(new Ledge(new GamePosition(25, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(26, 10), 2));
        gameObjects.add(new Ledge(new GamePosition(28, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(30, 5), 1));
        gameObjects.add(new Ledge(new GamePosition(32, 10), 4));
        gameObjects.add(new Ledge(new GamePosition(38, 5), 2));
        gameObjects.add(new Ledge(new GamePosition(41, 5), 2));
        gameObjects.add(new Ledge(new GamePosition(44, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(47, 5), 4));
        gameObjects.add(new Ledge(new GamePosition(51, 0), 2));
        gameObjects.add(new Ledge(new GamePosition(54, 5), 2));
        gameObjects.add(new Ledge(new GamePosition(57, 5), 2));
        gameObjects.add(new Coin(new GamePosition(10, 11)));
        gameObjects.add(new Coin(new GamePosition(11, 11)));
        gameObjects.add(new Coin(new GamePosition(12, 11)));
        gameObjects.add(new Coin(new GamePosition(14, 1)));
        gameObjects.add(new Coin(new GamePosition(16, 11)));
        gameObjects.add(new Coin(new GamePosition(17, 11)));
        gameObjects.add(new Coin(new GamePosition(22, 6)));
        gameObjects.add(new Coin(new GamePosition(23, 6)));
        gameObjects.add(new Coin(new GamePosition(26, 11)));
        gameObjects.add(new Coin(new GamePosition(27, 11)));
        gameObjects.add(new Coin(new GamePosition(38, 6)));
        gameObjects.add(new Coin(new GamePosition(39, 6)));
        gameObjects.add(new Coin(new GamePosition(41, 6)));
        gameObjects.add(new Coin(new GamePosition(42, 6)));
        gameObjects.add(new Coin(new GamePosition(44, 6)));
        gameObjects.add(new Coin(new GamePosition(45, 6)));
        gameObjects.add(new Coin(new GamePosition(51, 1)));
        gameObjects.add(new Coin(new GamePosition(52, 1)));
        gameObjects.add(new Coin(new GamePosition(56, 10)));
        gameObjects.add(new Coin(new GamePosition(57, 10)));
        gamePositions.add(new GamePosition(0, 0));
        gamePositions.add(new GamePosition(30, 0));
        gamePositions.add(new GamePosition(65, 0));

    }
}
