package Backend;

import java.util.ArrayList;
import java.util.Arrays;

public class Map4 extends Map{
    Map4(){
        ArrayList<GameObject> gameObjects = new ArrayList<>();
        ArrayList<GamePosition> gamePositions = new ArrayList<>();
        gameObjects.add(new Goomba(new GamePosition(90, 0)));
        gameObjects.add(new Goomba(new GamePosition(91, 0)));
        gameObjects.add(new Goomba(new GamePosition(92, 0)));
        gameObjects.add(new Koopa(new GamePosition(97, 0)));
        gameObjects.add(new Koopa(new GamePosition(98, 0)));
        gameObjects.add(new Koopa(new GamePosition(99, 0)));
        gameObjects.add(new Koopa(new GamePosition(105, 0)));
        gameObjects.add(new Land(0,5,0,-5));
        gameObjects.add(new Land(7,16,0,-5));
        gameObjects.add(new Land(18,21,0,-5));
        gameObjects.add(new Land(23,65,0,-5));
        gameObjects.add(new Land(75,80,0,-5));
        gameObjects.add(new Land(83,150,0,-5));
        gameObjects.add(new Yoshi(new GamePosition(19, 0)));
        gameObjects.add(new Cliff(new GamePosition(5, 0), 2));
        gameObjects.add(new Cliff(new GamePosition(16, 0), 2));
        gameObjects.add(new Trap(new GamePosition(20, 3.5), 3));
        gameObjects.add(new Cliff(new GamePosition(21, 0), 2));
        gameObjects.add(new Cliff(new GamePosition(110, 0), 3));
        gameObjects.add(new Trap(new GamePosition(32, 3), 3));
        gameObjects.add(new Trap(new GamePosition(38, 3), 3));
        gameObjects.add(new Trap(new GamePosition(42, 3), 3));
        gameObjects.add(new Trap(new GamePosition(55, 0), 3));
        gameObjects.add(new Trap(new GamePosition(58, 0), 3));
        gameObjects.add(new Trap(new GamePosition(63, 5), 3));
        gameObjects.add(new Trap(new GamePosition(80, 4), 3));
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
        gamePositions.add(new GamePosition(120, 0));
        gameObjects.add(new Flag(new GamePosition(23,0), false));
        gameObjects.add(new Flag(new GamePosition(85,0),false));
        gameObjects.add(new Flag(new GamePosition(120, 0), true));
        initObjects(gameObjects, gamePositions);
    }
}
