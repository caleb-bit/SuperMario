package Backend;

public class Flower extends Powerup{
    public Flower(GamePosition position){
        super(position, "Flower");
        setDuration(15 * 1000);
    }
    public void move() {

    }
}
