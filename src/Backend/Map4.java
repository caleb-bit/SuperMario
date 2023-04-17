package Backend;

public class Map4 extends Map{
    Map4(){
        Enemy[] enemies = new Enemy[0];
        Powerup[] powerups = new Powerup[1];
        Obstacle[] obstacles = new Obstacle[13];
        Coin[] coins = new Coin[3];
        GamePosition[] checkPoints = new GamePosition[2];
        obstacles[0] = new Cliff(new GamePosition(5, 0), 33);
        obstacles[1] = new Ledge(new GamePosition(7, 0), 2);
        obstacles[2] = new Ledge(new GamePosition(10, 5), 4);
        obstacles[3] = new Ledge(new GamePosition(11, 10), 3);
        obstacles[4] = new Ledge(new GamePosition(14, 0), 1);
        obstacles[5] = new Ledge(new GamePosition(16, 5), 2);
        obstacles[6] = new Ledge(new GamePosition(18, 10), 4);
        obstacles[7] = new Ledge(new GamePosition(22, 0), 2);
        obstacles[8] = new Ledge(new GamePosition(24, 10), 2);
        obstacles[9] = new Ledge(new GamePosition(25, 0), 2);
        obstacles[10] = new Ledge(new GamePosition(26, 10), 2);
        obstacles[11] = new Ledge(new GamePosition(28, 0), 2);
        obstacles[12] = new Ledge(new GamePosition(30, 5), 1);
        coins[0] = new Coin(new GamePosition(10, 11));
        coins[1] = new Coin(new GamePosition(11, 11));
        coins[2] = new Coin(new GamePosition(12, 11));
        checkPoints[0] = new GamePosition(30, 0);
        checkPoints[1] = new GamePosition(65, 0);
        setEnemies(enemies);
        setPowerups(powerups);
        setObstacles(obstacles);
        setCoins(coins);
        setPoints(checkPoints);
    }
}
