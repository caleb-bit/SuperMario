package Backend;

public class Goomba extends Enemy{
    public Goomba(GamePosition position){
        super(position, 0.1, 0);
    }

    @Override
    public double getHeight() {
        return 1.5;
    }
}
