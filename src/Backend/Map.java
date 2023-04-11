package Backend;

import Backend.Block;
import Backend.Coin;

public abstract class Map {
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
    public void setPowerups(Powerup[] powerups){
        this.powerups = powerups;
    }
    public Obstacle[] getObstacles(){
        return obstacles;
    }
    public void setObstacles(Obstacle[] obstacles){
        this.obstacles = obstacles;
    }
    public Enemy[] getEnemies(){
        return enemies;
    }
    public void setEnemies(Enemy[] enemies){
        this.enemies = enemies;
    }
    public Coin[] getCoins(){
        return coins;
    }
    public void setCoins(Coin[] coins){
        this.coins = coins;
    }
    public Block[] getBlocks(){
        return blocks;
    }
    public void setBlocks(Block[] blocks){
        this.blocks = blocks;
    }
    public GamePosition[] getPoints(){
        return checkPoints;
    }
    public void setPoints(GamePosition[] checkPoints){
        this.checkPoints = checkPoints;
    }
    public GameObject[] getAllGameObjects() {
        return allObjects;
    }
}
