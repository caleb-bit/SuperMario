package Backend;

public class Land extends GameObject{
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    Land(int startX, int endX, int startY, int endY) {
        super(new GamePosition(startX, startY),0,0);
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }
    public void move() {
    }

    public int getStartX() {
        return startX;
    }

    public int getEndX() {
        return endX;
    }

    public int getMaxHeight() {
        return Math.abs(endY-startY);
    }

    public int getUIWidth() {
        return (endX-startX)*5;
    }

    public int getUIHeight() {
        return Math.abs(endY-startY)*5;
    }

}
