package Backend;

public abstract class Enemy extends GameObject{
    private boolean alive;
    Enemy(GamePosition position, int velX, int velY){
        super(position, velX, velY);
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

    abstract public double getHeight();

}
