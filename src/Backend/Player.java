package Backend;

import java.util.ArrayList;

public class Player extends GameObject{
    private int lives;
    private Powerup power;
    private int coins;
    Player(GamePosition position, int velX, int velY){
        super(position, velX, velY);
        lives = 3;
        power = null;
        coins = 0;
    }
    public Player(int xPos, int yPos, int velX, int velY) {
        super(xPos, yPos, velX, velY);
        lives = 3;
        power = null;
        coins = 0;
    }
    public int getLives(){
        return lives;
    }
    public void die(ArrayList<GamePosition> points){
        lives--;
        GamePosition returnPoint = new GamePosition(0, 0);
        for (GamePosition pos: points){
            if (pos.getX() < getX()){
                returnPoint = pos;
            }
        }
        setPosition(returnPoint);
    }
    public Powerup getPower(){
        return power;
    }
    public void setPower(Powerup power){
        this.power = power;
    }
    public int getCoins(){
        return coins;
    }
    private void setCoins(int coins){
        this.coins = coins;
    }
    public void move(){

    }
}
