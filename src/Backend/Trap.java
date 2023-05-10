package Backend;

import Frontend.FrontendManager;

public class Trap extends Obstacle{
    double angle;
    Trap(GamePosition position, int length){
        super(position, length);
        angle = 0;
    }
    public void setAngle(double angle){
        this.angle = angle;
    }
    public double getAngle(){
        return angle;
    }
    public int getXMax(){
        return (int)(getX() + getLength() * Math.cos(getAngle()));
    }
    public int getYMax(){
        return (int)(getY() + getLength() * Math.sin(getAngle()));
    }
    public int getUIXMax() {
        return getXMax()* FrontendManager.SCALE;
    }
    public int getUIYMax() {
        return getYMax()* FrontendManager.SCALE;
    }
}
