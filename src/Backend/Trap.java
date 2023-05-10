package Backend;

import Frontend.FrontendManager;

public class Trap extends Obstacle {
    private double angle;

    Trap(GamePosition position, int length) {
        super(position, length);
        angle = 0;
    }

    public void setAngle(double angle) {
        if (angle > 2 * Math.PI)
            this.angle = angle - 2 * Math.PI;
        else
            this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    public int getUIWidth() {
        return (int) ((getLength() * Math.cos(getAngle())) * FrontendManager.SCALE);
    }

    public int getUIHeight() {
        return (int) ((getLength() * Math.sin(getAngle())) * FrontendManager.SCALE);
    }

    public double leftX() {
        return Math.min(getX(), getX() + getLength() * Math.cos(getAngle()));
    }

    public double rightX() {
        return Math.max(getX(), getX() + getLength() * Math.cos(getAngle()));
    }

    public double topY() {
        return Math.max(getY(), getY() + getLength() * Math.sin(getAngle()));
    }

    public double bottomY() {
        return Math.min(getY(), getY() + getLength() * Math.sin(getAngle()));
    }
}
