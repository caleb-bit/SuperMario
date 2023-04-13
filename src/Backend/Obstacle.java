package Backend;

public class Obstacle extends GameObject{
    private int length;
    Obstacle(GamePosition position, int length){
        super(position, 0, 0);
        this.length = length;
    }
    public void move() {
    }
}
