package Backend;

import java.util.ArrayList;

public class Map1 extends Map {
    Map1() {
        ArrayList<GameObject> gameObjects = new ArrayList<>();
        ArrayList<GamePosition> gamePositions = new ArrayList<>();
        gameObjects.add(new Land(-30,100,0,-50));
        gameObjects.add(new Goomba(new GamePosition(5, 0)));
        gameObjects.add(new Goomba(new GamePosition(15, 0)));
        gameObjects.add(new Koopa(new GamePosition(30, 0)));
        gameObjects.add(new Goomba(new GamePosition(40, 0)));
        gameObjects.add(new Flower(new GamePosition(10, 0)));
        gameObjects.add(new Mushroom(new GamePosition(25, 0)));
        gameObjects.add(new Invincibility(new GamePosition(35, 0)));
        gameObjects.add(new Yoshi(new GamePosition(50, 0)));
        gameObjects.add(new Land(20, 25,3.5,3));
        gameObjects.add(new Trap(new GamePosition(45, 3), 3));
        gameObjects.add(new Cliff(new GamePosition(55, 0), 4));
        gameObjects.add(new Coin(new GamePosition(8, 0)));
        gameObjects.add(new Coin(new GamePosition(21, 3.5)));
        gameObjects.add(new Coin(new GamePosition(32, 0)));
        gameObjects.add(new Coin(new GamePosition(53, 0)));
        gamePositions.add(new GamePosition(16, 0));
        gamePositions.add(new GamePosition(40, 0));
        gamePositions.add(new GamePosition(65, 0));
        gameObjects.add(new Flag(new GamePosition(16,0), false));
        gameObjects.add(new Flag(new GamePosition(40,0), false));
        gameObjects.add(new Flag(new GamePosition(65,0),true));
        initObjects(gameObjects, gamePositions);
    }
}
