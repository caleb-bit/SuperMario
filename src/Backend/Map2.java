package Backend;

import java.util.ArrayList;
import java.util.Arrays;

public class Map2 extends Map{
    Map2(){
        ArrayList<GameObject> gameObjects = new ArrayList<>();
        ArrayList<GamePosition> gamePositions = new ArrayList<>();
        gameObjects.add(new Land(0,100,0,-5));
        gameObjects.add(new Goomba(new GamePosition(5, 0)));
        gameObjects.add(new Goomba(new GamePosition(10, 0)));
        gameObjects.add(new Goomba(new GamePosition(15, 0)));
        gameObjects.add(new Goomba(new GamePosition(16, 0)));
        gameObjects.add(new Goomba(new GamePosition(25, 6.5)));
        gameObjects.add(new Goomba(new GamePosition(26, 6.5)));
        gameObjects.add(new Goomba(new GamePosition(33, 0)));
        gameObjects.add(new Goomba(new GamePosition(34, 0)));
        gameObjects.add(new Koopa(new GamePosition(38, 0)));
        gameObjects.add(new Goomba(new GamePosition(43, 0)));
        gameObjects.add(new Goomba(new GamePosition(44, 0)));
        gameObjects.add(new Goomba(new GamePosition(45, 0)));
        gameObjects.add(new Goomba(new GamePosition(46, 0)));
        gameObjects.add(new Goomba(new GamePosition(47, 0)));
        gameObjects.add(new Goomba(new GamePosition(48, 0)));
        gameObjects.add(new Goomba(new GamePosition(60, 0)));
        gameObjects.add(new Goomba(new GamePosition(61, 0)));
        gameObjects.add(new Flower(new GamePosition(4, 3.5)));
        gameObjects.add(new Mushroom(new GamePosition(20, 3.5)));
        gameObjects.add(new Mushroom(new GamePosition(24, 3.5)));
        gameObjects.add(new Invincibility(new GamePosition(36, 3.5)));
        gameObjects.add(new Land(3, 8,3.5 ,3));
        gameObjects.add(new Cliff(new GamePosition(21, 0), 1));
        gameObjects.add(new Land(22, 25,3.5 ,3));
        gameObjects.add(new Land(25, 31,6.5 ,6));
        gameObjects.add(new Cliff(new GamePosition(30, 0), 2));
        gameObjects.add(new Land(31, 33,3.5 ,3));
        gameObjects.add(new Land(35, 39,3.5 ,3));
        gameObjects.add(new Land(42, 43,3.5 ,3));
        gameObjects.add(new Land(44, 47,6.5 ,6));
        gameObjects.add(new Land(48, 50,6.5 ,6));
        gameObjects.add(new Land(48, 50,3.5 ,3));
        gameObjects.add(new Cliff(new GamePosition(53, 0), 1));
        gameObjects.add(new Land(56, 59,3.5 ,3));
        gameObjects.add(new Coin(new GamePosition(3, 3.5)));
        gameObjects.add(new Coin(new GamePosition(4, 6.5)));
        gameObjects.add(new Coin(new GamePosition(5, 3.5)));
        gameObjects.add(new Coin(new GamePosition(32, 3.5)));
        gameObjects.add(new Coin(new GamePosition(38, 3.5)));
        gameObjects.add(new Coin(new GamePosition(48, 6.5)));
        gameObjects.add(new Coin(new GamePosition(57, 3.5)));
        gamePositions.add(new GamePosition(19, 0));
        gamePositions.add(new GamePosition(65, 0));
        gameObjects.add(new Flag(new GamePosition(19,0), false));
        gameObjects.add(new Flag(new GamePosition(65,0),true));
        initObjects(gameObjects, gamePositions);
    }
}
