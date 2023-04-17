package Backend;

public abstract class Enemy extends GameObject{
    private boolean alive;
    private boolean direction;
    Enemy(GamePosition position, int velX, int velY){
        super(position, velX, velY);
        alive = true;
        direction = true;
    }
    public boolean getAlive(){
        return alive;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    public void move(){
        if (direction) {
            setPosition(new GamePosition(getPosition().getX() + 0.001, getPosition().getY()));
        }
        else{
            setPosition(new GamePosition(getPosition().getX() + 0.001, getPosition().getY()));
        }
    }
}
