package Backend;

public class Map1 extends Map{
    Map1(){
        Enemy[] enemies = new Enemy[4];
        Powerup[] powerups = new Powerup[4];
        Obstacle[] obstacles = new Obstacle[3];
        Coin[] coins = new Coin[5];
        Block[] blocks = new Block[1];
        GamePosition[] checkPoints = new GamePosition[3];
        enemies[0] = new Goomba(new GamePosition(5, 0));
        enemies[1] = new Goomba(new GamePosition(15, 0));
        enemies[2] = new Koopa(new GamePosition(30, 0));
        enemies[3] = new Goomba(new GamePosition(40, 0));
        powerups[0] = new Flower(new GamePosition(10, 0));
        powerups[1] = new Mushroom(new GamePosition(25, 0));
        powerups[2] = new Invincibility(new GamePosition(35, 0));
        powerups[3] = new Yoshi(new GamePosition(45, 0));
        obstacles[0] = new Ledge(new GamePosition(20, 3), 3);
        obstacles[1] = new Trap(new GamePosition(43, 3), 1);
        obstacles[2] = new Cliff(new GamePosition(50, 0), 4);
        coins[0] = new Coin(new GamePosition(6, 0));
        coins[1] = new Coin(new GamePosition(21, 4));
        coins[2] = new Coin(new GamePosition(32, 0));
        coins[3] = new Coin(new GamePosition(47, 0));
        blocks[0] = new PropellerBlock(new GamePosition(9, 4));
        checkPoints[0] = new GamePosition(20, 0);
        checkPoints[1] = new GamePosition(40, 0);
        checkPoints[2] = new GamePosition(55, 0);
        setEnemies(enemies);
        setPowerups(powerups);
        setObstacles(obstacles);
        setCoins(coins);
        setBlocks(blocks);
        setPoints(checkPoints);
    }
}
