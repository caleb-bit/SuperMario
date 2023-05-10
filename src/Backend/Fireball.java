package Backend;

public class Fireball extends GameObject{
    Fireball(GamePosition position) {
        super(position, 1, 0);
    }
    public void move() {
        setPosition(new GamePosition(getPosition().getX() + getVelX(), getPosition().getY()));
    }
}
