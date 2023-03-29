package Backend;

public class GamePosition {
    private double posX;
    private double posY;
    GamePosition(double posX, double posY){
        this.posX = posX;
        this.posY = posY;
    }
    public double getX(){
        return posX;
    }
    public double getY(){
        return posY;
    }
    public void setX(double posX){
        this.posX = posX;
    }
    public void setY(double posY){
        this.posY = posY;
    }
}
