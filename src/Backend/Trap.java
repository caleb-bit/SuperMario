package Backend;

import Frontend.FrontendManager;

public class Trap extends Obstacle{
    int angle;
    Trap(GamePosition position, int length){
        super(position, length);
        angle = 0;
    }
    public void setAngle(int angle){
        this.angle = angle;
    }
    public int getAngle(){
        return angle;
    }
    public int getXMax(){
        return (int)(getX() + Math.cos(getLength()));
    }
    public int getYMax(){
        return (int)(getY() + Math.sin(getLength()));
    }
    public int getUIXMax() {
        return getXMax()* FrontendManager.SCALE;
    }
    public int getUIYMax() {
        return getYMax()* FrontendManager.SCALE;
    }
}
