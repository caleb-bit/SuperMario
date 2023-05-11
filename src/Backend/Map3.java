package Backend;

import java.util.ArrayList;
import java.util.Arrays;

public class Map3 extends Map{
    Map3(){
        ArrayList<GameObject> gameObjects = new ArrayList<>();
        ArrayList<GamePosition> gamePositions = new ArrayList<>();
        gameObjects.add(new Land(0,100,0,-5));
        gameObjects.add(new Koopa(new GamePosition(13, 6.5)));
        gameObjects.add(new Goomba(new GamePosition(20, 6.5)));
        gameObjects.add(new Goomba(new GamePosition(21, 6.5)));
        gameObjects.add(new Goomba(new GamePosition(35, 6.5)));
        gameObjects.add(new Koopa(new GamePosition(50, 3.5)));
        gameObjects.add(new Koopa(new GamePosition(62, 0.5)));
        gameObjects.add(new Cliff(new GamePosition(5, 0), 33));
        gameObjects.add(new Land(7, 9,0.5 ,0));
        gameObjects.add(new Land(10, 14,3.5 ,3));
        gameObjects.add(new Land(11, 14,6.5 ,6));
        gameObjects.add(new Land(14, 16,0.5 ,0));
        gameObjects.add(new Land(16, 18,3.5 ,3));
        gameObjects.add(new Land(18, 22,6.5 ,6));
        gameObjects.add(new Land(22, 24,0.5 ,0));
        gameObjects.add(new Land(24, 26,6.5 ,6));
        gameObjects.add(new Land(25, 27,0 ,-0.5));
        gameObjects.add(new Land(26, 28,6.5 ,6));
        gameObjects.add(new Land(28, 30,0.5 ,0));
        gameObjects.add(new Land(30, 31,3.5 ,3));
        gameObjects.add(new Land(32, 36,6.5 ,6));
        gameObjects.add(new Land(38, 40,3.5 ,3));
        gameObjects.add(new Land(41, 43,3.5 ,3));
        gameObjects.add(new Land(44, 46,0.5 ,0));
        gameObjects.add(new Land(47, 51,3.5 ,3));
        gameObjects.add(new Land(51, 53,0.5 ,0));
        gameObjects.add(new Land(54, 56,3.5 ,3));
        gameObjects.add(new Land(57, 59,3.5 ,3));
        gameObjects.add(new Coin(new GamePosition(11, 6.5)));
        gameObjects.add(new Coin(new GamePosition(12, 6.5)));
        gameObjects.add(new Coin(new GamePosition(13, 6.5)));
        gameObjects.add(new Coin(new GamePosition(14, 0.5)));
        gameObjects.add(new Coin(new GamePosition(16, 6.5)));
        gameObjects.add(new Coin(new GamePosition(17, 6.5)));
        gameObjects.add(new Coin(new GamePosition(22, 3.5)));
        gameObjects.add(new Coin(new GamePosition(23, 3.5)));
        gameObjects.add(new Coin(new GamePosition(26, 6.5)));
        gameObjects.add(new Coin(new GamePosition(27, 6.5)));
        gameObjects.add(new Coin(new GamePosition(38, 3.5)));
        gameObjects.add(new Coin(new GamePosition(39, 3.5)));
        gameObjects.add(new Coin(new GamePosition(41, 3.5)));
        gameObjects.add(new Coin(new GamePosition(42, 3.5)));
        gameObjects.add(new Coin(new GamePosition(44, 3.5)));
        gameObjects.add(new Coin(new GamePosition(45, 3.5)));
        gameObjects.add(new Coin(new GamePosition(51, 0.5)));
        gameObjects.add(new Coin(new GamePosition(52, 0.5)));
        gameObjects.add(new Coin(new GamePosition(56, 6.5)));
        gameObjects.add(new Coin(new GamePosition(57, 6.5)));
        gamePositions.add(new GamePosition(30, 3.5));
        gamePositions.add(new GamePosition(65, 0));
        gameObjects.add(new Flag(new GamePosition(30,3.5), false));
        gameObjects.add(new Flag(new GamePosition(65,0),true));
        initObjects(gameObjects, gamePositions);
    }
}
