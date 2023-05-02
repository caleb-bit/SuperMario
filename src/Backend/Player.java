package Backend;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class Player extends GameObject {
    private int lives;
    private Powerup power;
    private int coins;
    private double acceleration;

    public Player(int xPos, int yPos, int velX, int velY) {
        super(xPos, yPos, velX, velY);
        lives = 3;
        power = null;
        coins = 0;
        acceleration = 0;
    }

    @Override
    public void move() {

    }

    public int getLives() {
        return lives;
    }

    public void die(ArrayList<GamePosition> points) {
        if (power != null && getPower().getName().equals("Mushroom")) {
            setPower(null);
        } else {
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

    public void move(HashMap<Integer, Boolean> keysPressed, Land land) {
        updateSpeeds(keysPressed, land);
        if (keysPressed.get(KeyEvent.VK_SPACE) && getPower().getName().equals("Flower")) {
            Fireball fire = new Fireball(getPosition());
        }
        if (!(keysPressed.get(KeyEvent.VK_RIGHT) || keysPressed.get(KeyEvent.VK_LEFT)))
            setVelX(0);

        setVelY(getVelY() + getAccelY());
        setPosition(new GamePosition(getX() + getVelX(), getY() + getVelY()));
    }

    private void updateSpeeds(HashMap<Integer, Boolean> keysPressed, Land land) {
        if (keysPressed.get(KeyEvent.VK_RIGHT)) {
            setVelX(3);
        }
        if (keysPressed.get(KeyEvent.VK_LEFT)) {
            setVelX(-3);
        }
        if (keysPressed.get(KeyEvent.VK_UP)) {
            if (getY() == land.getStartY() || (power != null && getPower().getName().equals("Yoshi"))) {
                setVelY(3);
                setAccelY(-0.5);
            }
        }
        // if player will sink into ground, bring it up.
        if (getY() + getVelY() < land.getStartY()) {
            setAccelY(0);
            setVelY(land.getStartY() - getY());
        }

    }

    public Powerup getPower() {
        return power;
    }

    public void setPower(Powerup power) {
        this.power = power;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public double getAccelY() {
        return acceleration;
    }

    public void setAccelY(double acceleration) {
        this.acceleration = acceleration;
    }


}
