package Backend;

public class Map2 extends Map{
    Map2(){
        Enemy[] enemies = new Enemy[17];
        Powerup[] powerups = new Powerup[5];
        Obstacle[] obstacles = new Obstacle[13];
        Coin[] coins = new Coin[5];
        Block[] blocks = new Block[1];
        GamePosition[] checkPoints = new GamePosition[2];
        enemies[0] = new Goomba(new GamePosition(5, 0));
        enemies[1] = new Goomba(new GamePosition(10, 0));
        enemies[2] = new Goomba(new GamePosition(15, 0));
        enemies[3] = new Goomba(new GamePosition(16, 0));
        enemies[4] = new Goomba(new GamePosition(25, 10));
        enemies[5] = new Goomba(new GamePosition(26, 10));
        enemies[6] = new Goomba(new GamePosition(33, 0));
        enemies[7] = new Goomba(new GamePosition(34, 0));
        enemies[8] = new Koopa(new GamePosition(38, 0));
        enemies[9] = new Goomba(new GamePosition(43, 0));
        enemies[10] = new Goomba(new GamePosition(44, 0));
        enemies[11] = new Goomba(new GamePosition(45, 0));
        enemies[12] = new Goomba(new GamePosition(46, 0));
        enemies[13] = new Goomba(new GamePosition(47, 0));
        enemies[14] = new Goomba(new GamePosition(48, 0));
        enemies[15] = new Goomba(new GamePosition(60, 0));
        enemies[16] = new Goomba(new GamePosition(61, 0));
        powerups[0] = new Flower(new GamePosition(4, 6));
        powerups[1] = new Mushroom(new GamePosition(20, 6));
        powerups[2] = new Mushroom(new GamePosition(24, 6));
        powerups[3] = new Invincibility(new GamePosition(36, 6));
        obstacles[0] = new Ledge(new GamePosition(3, 5));
        obstacles[1] = new Cliff(new GamePosition(21, 0));
        obstacles[2] = new Ledge(new GamePosition(22, 5));
        obstacles[3] = new Ledge(new GamePosition(25, 10));
        obstacles[4] = new Cliff(new GamePosition(30, 0));
        obstacles[5] = new Ledge(new GamePosition(31, 5));
        obstacles[6] = new Ledge(new GamePosition(35, 5));
        obstacles[7] = new Ledge(new GamePosition(42, 5));
        obstacles[8] = new Ledge(new GamePosition(44, 10));
        obstacles[9] = new Ledge(new GamePosition(47, 10));
        obstacles[10] = new Ledge(new GamePosition(48, 5));
        obstacles[11] = new Cliff(new GamePosition(53, 0));
        obstacles[12] = new Ledge(new GamePosition(56, 5));
        coins[0] = new Coin(new GamePosition(6, 0));
        coins[1] = new Coin(new GamePosition(21, 4));
        coins[2] = new Coin(new GamePosition(32, 0));
        coins[3] = new Coin(new GamePosition(47, 0));
        blocks[1] = new PropellerBlock(new GamePosition(9, 4));
        checkPoints[0] = new GamePosition(20, 0);
        checkPoints[1] = new GamePosition(40, 0);
        setEnemies(enemies);
        setPowerups(powerups);
        setObstacles(obstacles);
        setCoins(coins);
        setBlocks(blocks);
        setPoints(checkPoints);
    }
}
