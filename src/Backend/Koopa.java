package Backend;

public class Koopa extends Enemy{
    public Koopa(GamePosition position){
        super(position, 0.1, 0);
    }

    @Override
    public double getHeight() {
        return 1.85;
    }
}
