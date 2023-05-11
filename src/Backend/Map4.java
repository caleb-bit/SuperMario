package Backend;

import java.util.ArrayList;
import java.util.Arrays;

public class Map4 extends Map{
    Map4(){
        ArrayList<GameObject> gameObjects = new ArrayList<>();
        ArrayList<GamePosition> gamePositions = new ArrayList<>();
        gameObjects.add(new Land(0,120,0,-5));
        gameObjects.add(new Yoshi(new GamePosition(19, 0)));
        gameObjects.add(new Cliff(new GamePosition(5, 0), 2));
        gameObjects.add(new Cliff(new GamePosition(16, 0), 2));
        gameObjects.add(new Trap(new GamePosition(19, 3), 3));
        gameObjects.add(new Cliff(new GamePosition(21, 0), 2));
        gameObjects.add(new Trap(new GamePosition(32, 3), 3));
        gameObjects.add(new Trap(new GamePosition(38, 3), 3));
        gameObjects.add(new Trap(new GamePosition(42, 3), 3));
        gameObjects.add(new Trap(new GamePosition(55, 0), 3));
        gameObjects.add(new Trap(new GamePosition(58, 0), 3));
        gameObjects.add(new Trap(new GamePosition(63, 3), 3));
        gameObjects.add(new Cliff(new GamePosition(65, 0), 10));
        gameObjects.add(new Land(68, 70,3.5 ,3));
        gameObjects.add(new Land(72, 74,3.5 ,3));
        gameObjects.add(new Land(76, 78,3.5 ,3));
        gameObjects.add(new Cliff(new GamePosition(80, 0), 3));
        gameObjects.add(new Coin(new GamePosition(68, 3.5)));
        gameObjects.add(new Coin(new GamePosition(72, 3.5)));
        gameObjects.add(new Coin(new GamePosition(76, 3.5)));
        gamePositions.add(new GamePosition(23, 0));
        gamePositions.add(new GamePosition(85, 0));
        gameObjects.add(new Flag(new GamePosition(23,0), false));
        gameObjects.add(new Flag(new GamePosition(85,0),true));
        initObjects(gameObjects, gamePositions);
    }
}
