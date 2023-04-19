package Backend;

import java.util.ArrayList;

public abstract class Map {
    public void initObjects(ArrayList<GameObject> objects, ArrayList<GamePosition> checkPoints) {
        allObjects = objects;
        for (GameObject object : objects) {
            if (object instanceof Powerup)
                powerups.add((Powerup)object);
            else if (object instanceof Obstacle)
                obstacles.add((Obstacle)object);
            else if (object instanceof Enemy)
                enemies.add((Enemy) object);
            else if (object instanceof Coin)
                coins.add((Coin) object);
        }
        this.checkPoints = checkPoints;
    }
    private ArrayList<GameObject> allObjects;
    private ArrayList<Powerup> powerups;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Enemy> enemies;
    private ArrayList<Coin> coins;
    private ArrayList<GamePosition> checkPoints;
    public ArrayList<Powerup> getPowerups(){
        return powerups;
    }
    public void setPowerups(ArrayList<Powerup> powerups){
        this.powerups = powerups;
    }
    public ArrayList<Obstacle> getObstacles(){
        return obstacles;
    }
    public void setObstacles(ArrayList<Obstacle> obstacles){
        this.obstacles = obstacles;
    }
    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }
    public void setEnemies(ArrayList<Enemy> enemies){
        this.enemies = enemies;
    }
    public ArrayList<Coin> getCoins(){
        return coins;
    }
    public void setCoins(ArrayList<Coin> coins){
        this.coins = coins;
    }
    public ArrayList<GamePosition> getPoints(){
        return checkPoints;
    }
    public void setPoints(ArrayList<GamePosition> checkPoints){
        this.checkPoints = checkPoints;
    }
    public ArrayList<GameObject> getAllGameObjects() {
        return allObjects;
    }
    public void setAllGameObjects(ArrayList<GameObject> objects){
        allObjects = objects;
    }
}
