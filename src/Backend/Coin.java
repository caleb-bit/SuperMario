package Backend;

public class Coin extends GameObject{
    private boolean taken;
    Coin(GamePosition position){
        super(position, 0, 0);
    }
    private boolean getTaken(){
        return taken;
    }
    private void setTaken(boolean taken) {
        this.taken = taken;
    }
    public void move() {

    }
}
