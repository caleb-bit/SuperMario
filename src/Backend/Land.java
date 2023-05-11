package Backend;

import Frontend.FrontendManager;

public class Land extends GameObject{
    private double startX;
    private double endX;
    private double startY;
    private double endY;
    public Land(double startX, double endX, double startY, double endY) {
        super(new GamePosition(startX, startY),0,0);
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }
    public void move() {
    }

    public double getStartX() {
        return startX;
    }

    public double getEndX() {
        return endX;
    }

    public double getTopY() {return startY;}
    public double getBottomY() {return endY;}

    public double getUIWidth() {
        return (endX-startX)* FrontendManager.SCALE;
    }

    public double getUIHeight() {
        return Math.abs(endY-startY)* FrontendManager.SCALE;
    }

}
