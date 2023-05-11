package Backend;

public class Invincibility extends Powerup{
    public Invincibility(GamePosition position){
        super(position, "Invincibility");
        setDuration(15 * 1000);
    }
    public void move() {

    }
}
