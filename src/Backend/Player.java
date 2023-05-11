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
    private static final double Y_ACCEL = 0.4;
    private double width;
    private double height;

    Player(GamePosition position, int velX, int velY) {
        super(position, velX, velY);
        lives = 3;
        power = null;
        coins = 0;
        acceleration = 0;
        fireballs = new ArrayList<>();
        width = 1.15;
        height = 2.7;
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
        setVelX(0);
        setVelY(0);
        setAccelY(0);
        if (getPower() != null && getPower().getName().equals("Mushroom")) {
            setPower(null);
        }
        lives--;
        GamePosition returnPoint = new GamePosition(0, 0);
        for (GamePosition pos : points) {
            if (pos.getX() < getX()) {
                returnPoint = pos;
            }
        }
        setPosition(returnPoint);
    }

    public void move(HashMap<Integer, Boolean> keysPressed, Land landBelow, Land landAbove) {
        updateSpeeds(keysPressed, landBelow, landAbove);
        if (!(keysPressed.get(KeyEvent.VK_RIGHT) || keysPressed.get(KeyEvent.VK_LEFT)))
            setVelX(0);
        if (keysPressed.get(KeyEvent.VK_SPACE) && (getPower() != null && getPower().getName().equals("Flower"))) {
            fireballs.add(new Fireball(getPosition()));
        }
        setVelY(getVelY() + getAccelY());
        setPosition(new GamePosition(getX() + getVelX(), getY() + getVelY()));
    }

    private void updateSpeeds(HashMap<Integer, Boolean> keysPressed, Land landBelow, Land landAbove) {
        if (keysPressed.get(KeyEvent.VK_RIGHT)) {
            setVelX(1);
        }
        if (keysPressed.get(KeyEvent.VK_LEFT)) {
            setVelX(-1);
        }
        if (keysPressed.get(KeyEvent.VK_UP)) {
            if ((landBelow != null && getY() == landBelow.getTopY())
                    || (getPower() != null && getPower().getName().equals("Yoshi"))) {
                setVelY(2);
                setAccelY(-Y_ACCEL);
            }
        }

        if (landBelow != null) {
            if (getY() + getVelY() < landBelow.getTopY()) {
                // if player will sink into ground, bring it up.
                setAccelY(0);
                setVelY(0);
                setPosition(new GamePosition(getX(), landBelow.getTopY()));
            } else if (getY() != landBelow.getTopY()) {
                setAccelY(-Y_ACCEL);
            }
        } else {
            setAccelY(-Y_ACCEL);
        }
        if (landAbove != null && getY() + getHeight() + getVelY() >= landAbove.getBottomY()) {
            setPosition(new GamePosition(getX(), landAbove.getBottomY() - getHeight()+Y_ACCEL));
            setVelY(0);
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

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}