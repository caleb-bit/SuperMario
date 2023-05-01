package Backend;

public abstract class GameObject {
    private GamePosition position;
    private double velX;
    private double velY;
    private double accelY;
    GameObject(GamePosition position, double velX, double velY){
        this.position = position;
        this.velX = velX;
        this.velY = velY;
        accelY =0;
    }
    GameObject(int xPos, int yPos, int velX, int velY) {
        this.position = new GamePosition(xPos, yPos);
        this.velX = velX;
        this.velY = velY;
        accelY =0;
    }
    public double getX() {
        return position.getX();
    }
    public double getY() {
        return position.getY();
    }
    public GamePosition getPosition(){
        return position;
    }
    public void setPosition(GamePosition position){
        this.position = position;
    }
    public double getVelX(){
        return velX;
    }
    public double getVelY(){
        return velY;
    }
    public double getAccelY(){return accelY;}
    public void setVelX(double velX){
        this.velX = velX;
    }
    public void setVelY(double velY){
        this.velY = velY;
    }
    public void setAccelY(double accelY){this.accelY = accelY;}
    public abstract void move();
}
