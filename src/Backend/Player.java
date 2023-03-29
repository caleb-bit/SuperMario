package Backend;

public class Player extends GameObject{
    private int lives;
    private Powerup power;
    private double accelX;
    private double accelY;
    private double maxVelX;
    private double maxVelY;
    private int coins;
    Player(GamePosition position, int velX, int velY){
        super(position, velX, velY);
        lives = 3;
        power = null;
        coins = 0;
    }
    public void move(Direction direction){

    }
    public int getLives(){
        return lives;
    }
    public void die(){
        lives--;
        if (lives == 0){

        }
    }
    public Powerup getPower(){
        return power;
    }
    public void setPower(){

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
