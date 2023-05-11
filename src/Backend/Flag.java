package Backend;

public class Flag extends GameObject {
    private boolean isLast;
    Flag(GamePosition position, boolean isLast) {
        super(position, 0,0);
        this.isLast = isLast;
    }

    @Override
    public void move() {

    }
}
