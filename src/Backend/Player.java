package Backend;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class Player extends GameObject {
    private int lives;
    private Powerup power;
    private int coins;
    private double acceleration;
    private ArrayList<Fireball> fireballs;

    Player(GamePosition position, int velX, int velY) {
        super(position, velX, velY);
        lives = 3;
        power = null;
        coins = 0;
        acceleration = 0;
        fireballs = new ArrayList<>();

    }

    public Player(int xPos, int yPos, int velX, int velY) {
        super(xPos, yPos, velX, velY);
        lives = 3;
        power = null;
        coins = 0;
        acceleration = 0;
        fireballs = new ArrayList<>();
    }

    @Override
    public void move() {

    }

    public int getLives() {
        return lives;
    }

    public void die(ArrayList<GamePosition> points) {
        if (getPower() != null && getPower().getName().equals("Mushroom")) {
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
        if (!(keysPressed.get(KeyEvent.VK_RIGHT) || keysPressed.get(KeyEvent.VK_LEFT)))
            setVelX(0);
        if (keysPressed.get(KeyEvent.VK_SPACE) && (getPower() != null && getPower().getName().equals("Flower"))) {
            fireballs.add(new Fireball(getPosition()));
        }
        setVelY(getVelY() + getAccelY());
        setPosition(new GamePosition(getX() + getVelX(), getY() + getVelY()));
    }

    private void updateSpeeds(HashMap<Integer, Boolean> keysPressed, Land land) {
        if (keysPressed.get(KeyEvent.VK_RIGHT)) {
            setVelX(1);
        }
        if (keysPressed.get(KeyEvent.VK_LEFT)) {
            setVelX(-1);
        }
        if (keysPressed.get(KeyEvent.VK_UP)) {
            if (land != null && getY() == land.getStartY() || (getPower() != null && getPower().getName().equals("Yoshi"))) {
                setVelY(2);
                setAccelY(-0.5);
            }
        }
        // if player will sink into ground, bring it up.
        if (land != null && getY() + getVelY() < land.getStartY()) {
            setAccelY(0);
            setVelY(land.getStartY() - getY());
        }
        if (land == null) {
            setAccelY(-0.5);
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

    public ArrayList<Fireball> getBalls() {
        return fireballs;
    }

    public void move(HashMap<Integer, Boolean> keysPressed) {
        // update speeds
        if (keysPressed.get(KeyEvent.VK_RIGHT)) {
            setVelX(1);
        } else if (keysPressed.get(KeyEvent.VK_LEFT)) {
            setVelX(-1);
        } else if (keysPressed.get(KeyEvent.VK_UP)) {
            if (getVelY() == 0 || (power != null && (getPower() != null && getPower().getName().equals("Yoshi")))) {
                setVelY(2);
                setAccelY(-0.5);
            }
        } else if (keysPressed.get(KeyEvent.VK_SPACE) && (getPower() != null && getPower().getName().equals("Flower"))) {
            fireballs.add(new Fireball(getPosition()));
        }
        if (!(keysPressed.get(KeyEvent.VK_RIGHT) || keysPressed.get(KeyEvent.VK_LEFT))) {
            setVelX(0);
        }
        setVelY(getVelY() + getAccelY());
        setPosition(new GamePosition(getX() + getVelX(), getY() + getVelY()));
    }
}