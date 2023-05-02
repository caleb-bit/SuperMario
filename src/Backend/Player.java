package Backend;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

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

    @Override
    public void move() {

    }

    public int getLives(){
        return lives;
    }
    public void die(ArrayList<GamePosition> points){
        if (power != null && getPower().getName().equals("Mushroom")){
            setPower(null);
        }
        else {
            lives--;
            GamePosition returnPoint = new GamePosition(0, 0);
            for (GamePosition pos : points) {
                if (pos.getX() < getX()) {
                    returnPoint = pos;
                }
            }
            setPosition(returnPoint);
        }
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
    public void setCoins(int coins){
        this.coins = coins;
    }

    public void move(HashMap<Integer, Boolean> keysPressed) {
        // update speeds
        if (keysPressed.get(KeyEvent.VK_RIGHT)) {
            setVelX(3);
        } else if (keysPressed.get(KeyEvent.VK_LEFT)) {
            setVelX(-3);
        } else if (keysPressed.get(KeyEvent.VK_UP)) {
            if (getVelY() == 0 || (power != null && getPower().getName().equals("Yoshi"))) {
                setVelY(3);
                setAccelY(-0.5);
            }
        } else if (keysPressed.get(KeyEvent.VK_SPACE) && getPower().getName().equals("Flower")) {
            Fireball fire = new Fireball(getPosition());
        }

        if (!(keysPressed.get(KeyEvent.VK_RIGHT) || keysPressed.get(KeyEvent.VK_LEFT)))
            setVelX(0);

        setVelY(getVelY()+getAccelY());
        setPosition(new GamePosition(getX() + getVelX(), getY() + getVelY()));
    }
}
