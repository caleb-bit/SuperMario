package Backend;

public class Map4 extends Map{
    Map4(){
        Enemy[] enemies = new Enemy[0];
        Powerup[] powerups = new Powerup[1];
        Obstacle[] obstacles = new Obstacle[15];
        Coin[] coins = new Coin[3];
        GamePosition[] checkPoints = new GamePosition[2];
        powerups[0] = new Yoshi(new GamePosition(19, 5));
        obstacles[0] = new Cliff(new GamePosition(5, 0), 2);
        obstacles[1] = new Cliff(new GamePosition(16, 0), 2);
        obstacles[2] = new Trap(new GamePosition(19, 0), 3);
        obstacles[3] = new Cliff(new GamePosition(21, 0), 2);
        obstacles[4] = new Trap(new GamePosition(32, 5), 3);
        obstacles[5] = new Trap(new GamePosition(38, 5), 3);
        obstacles[6] = new Trap(new GamePosition(42, 5), 3);
        obstacles[7] = new Trap(new GamePosition(47, 0), 3);
        obstacles[8] = new Trap(new GamePosition(53, 0), 3);
        obstacles[9] = new Trap(new GamePosition(56, 5), 3);
        obstacles[10] = new Cliff(new GamePosition(65, 0), 10);
        obstacles[11] = new Ledge(new GamePosition(68, 3), 1);
        obstacles[12] = new Ledge(new GamePosition(71, 3), 1);
        obstacles[13] = new Ledge(new GamePosition(74, 3), 1);
        obstacles[14] = new Cliff(new GamePosition(80, 0), 3);
        coins[0] = new Coin(new GamePosition(68, 4));
        coins[1] = new Coin(new GamePosition(71, 4));
        coins[2] = new Coin(new GamePosition(74, 4));
        checkPoints[0] = new GamePosition(23, 0);
        checkPoints[1] = new GamePosition(85, 0);
        setEnemies(enemies);
        setPowerups(powerups);
        setObstacles(obstacles);
        setCoins(coins);
        setPoints(checkPoints);
    }
}
