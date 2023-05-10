package Backend;

import Frontend.FrontendManager;

public class Trap extends Obstacle{
    private double angle;
    Trap(GamePosition position, int length){
        super(position, length);
        angle = 0;
    }
    public void setAngle(double angle){
        if (angle > 2*Math.PI)
            this.angle = angle-2*Math.PI;
        else
            this.angle = angle;
    }
    public double getAngle(){
        return angle;
    }
    public double getXMax(){
        return (getX() + getLength() * Math.cos(getAngle()));
    }
    public double getYMax(){
        return (getY() + getLength() * Math.sin(getAngle()));
    }
    public int getUIWidth() {
        return (int) ((getXMax()-getX())* FrontendManager.SCALE);
    }
    public int getUIHeight() {
        return (int)((getYMax()-getY())* FrontendManager.SCALE);
    }
}
