package Backend;

import java.util.Arrays;

public class Map2 extends Map{
    Map2(){
        GameObject[] objects = new GameObject[42];
        Enemy[] enemies = new Enemy[17];
        Powerup[] powerups = new Powerup[5];
        Obstacle[] obstacles = new Obstacle[13];
        Coin[] coins = new Coin[7];
        GamePosition[] checkPoints = new GamePosition[2];
        enemies[0] = new Goomba(new GamePosition(5, 1));
        enemies[1] = new Goomba(new GamePosition(10, 1));
        enemies[2] = new Goomba(new GamePosition(15, 1));
        enemies[3] = new Goomba(new GamePosition(16, 1));
        enemies[4] = new Goomba(new GamePosition(25, 11));
        enemies[5] = new Goomba(new GamePosition(26, 11));
        enemies[6] = new Goomba(new GamePosition(33, 1));
        enemies[7] = new Goomba(new GamePosition(34, 1));
        enemies[8] = new Koopa(new GamePosition(38, 1));
        enemies[9] = new Goomba(new GamePosition(43, 1));
        enemies[10] = new Goomba(new GamePosition(44, 1));
        enemies[11] = new Goomba(new GamePosition(45, 1));
        enemies[12] = new Goomba(new GamePosition(46, 1));
        enemies[13] = new Goomba(new GamePosition(47, 1));
        enemies[14] = new Goomba(new GamePosition(48, 1));
        enemies[15] = new Goomba(new GamePosition(60, 1));
        enemies[16] = new Goomba(new GamePosition(61, 1));
        powerups[0] = new Flower(new GamePosition(4, 6));
        powerups[1] = new Mushroom(new GamePosition(20, 6));
        powerups[2] = new Mushroom(new GamePosition(24, 6));
        powerups[3] = new Invincibility(new GamePosition(36, 6));
        obstacles[0] = new Ledge(new GamePosition(3, 5), 3);
        obstacles[1] = new Cliff(new GamePosition(21, 0), 1);
        obstacles[2] = new Ledge(new GamePosition(22, 5), 2);
        obstacles[3] = new Ledge(new GamePosition(25, 10), 5);
        obstacles[4] = new Cliff(new GamePosition(30, 0), 2);
        obstacles[5] = new Ledge(new GamePosition(31, 5), 2);
        obstacles[6] = new Ledge(new GamePosition(35, 5), 1);
        obstacles[7] = new Ledge(new GamePosition(42, 5), 1);
        obstacles[8] = new Ledge(new GamePosition(44, 10), 2);
        obstacles[9] = new Ledge(new GamePosition(47, 10), 3);
        obstacles[10] = new Ledge(new GamePosition(48, 5), 1);
        obstacles[11] = new Cliff(new GamePosition(53, 0), 1);
        obstacles[12] = new Ledge(new GamePosition(56, 5), 3);
        coins[0] = new Coin(new GamePosition(3, 5));
        coins[1] = new Coin(new GamePosition(4, 10));
        coins[2] = new Coin(new GamePosition(5, 6));
        coins[3] = new Coin(new GamePosition(32, 5));
        coins[4] = new Coin(new GamePosition(38, 5));
        coins[5] = new Coin(new GamePosition(48, 11));
        coins[6] = new Coin(new GamePosition(57, 6));
        checkPoints[0] = new GamePosition(19, 0);
        checkPoints[1] = new GamePosition(65, 0);
        System.arraycopy(enemies, 0, objects, 0, enemies.length);
        System.arraycopy(powerups, 0, objects, enemies.length, powerups.length);
        System.arraycopy(coins, 0, objects, enemies.length + powerups.length, coins.length);
        Arrays.sort(objects);
        setAllGameObjects(objects);
        setEnemies(enemies);
        setPowerups(powerups);
        setObstacles(obstacles);
        setCoins(coins);
        setPoints(checkPoints);
    }
}
