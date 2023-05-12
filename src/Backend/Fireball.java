package Backend;

public class Fireball extends GameObject {
    Fireball(GamePosition position, boolean toRight) {
        super(position, 0.5, 0);
        if (!toRight)
            setVelX(-0.5);
    }

    public void move() {
        setPosition(new GamePosition(getPosition().getX() + getVelX(), getPosition().getY()));
    }
}
