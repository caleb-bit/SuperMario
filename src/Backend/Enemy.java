package Backend;

public abstract class Enemy extends GameObject{
    private boolean alive;
    private final GamePosition initialPos;
    Enemy(GamePosition position, double velX, double velY){
        super(position, velX, velY);
        initialPos = position;
        alive = true;
    }
    public boolean getAlive(){
        return alive;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    public void move(){
        setPosition(new GamePosition(getPosition().getX() + getVelX(), getPosition().getY()));
    }
    public GamePosition getInitial(){
        return initialPos;
    }
    abstract public double getHeight();

}
