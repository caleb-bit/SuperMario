package Backend;

public class Coin extends GameObject{
    private boolean taken;
    public Coin(GamePosition position){
        super(position, 0, 0);
    }
    public boolean getTaken(){
        return taken;
    }
    public void setTaken(boolean taken) {
        this.taken = taken;
    }
    public void move() {

    }
}
