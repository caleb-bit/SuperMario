package Backend;

public abstract class GameObject {
    private GamePosition position;
    private int velX;
    private int velY;
    GameObject(GamePosition position, int velX, int velY){
        this.position = position;
        this.velX = velX;
        this.velY = velY;
    }
    GameObject(int xPos, int yPos, int velX, int velY) {
        this.position = new GamePosition(xPos, yPos);
        this.velX = velX;
        this.velY = velY;
    }
    public GamePosition getPosition(){
        return position;
    }
    public void setPosition(GamePosition position){
        this.position = position;
    }
    public double getX(){return position.getX();}
    public double getY(){return position.getY();}
    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }
    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    public abstract void move();
}
