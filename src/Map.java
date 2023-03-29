public class Map {
    private GameObject[] allObjects;
    private Powerup[] powerups;
    private Obstacle[] obstacles;
    private Enemy[] enemies;
    private Coin[] coins;
    private Block[] blocks;
    private GamePosition[] checkPoints;
    public Powerup[] getPowerups(){
        return powerups;
    }
    public Obstacle[] getObstacles(){
        return obstacles;
    }
    public Enemy[] getEnemies(){
        return enemies;
    }
    public Coin[] getCoins(){
        return coins;
    }
    public Block[] getBlocks(){
        return blocks;
    }
    public GamePosition[] getPoints(){
        return checkPoints;
    }

}
