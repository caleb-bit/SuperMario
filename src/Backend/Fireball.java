package Backend;

public class Fireball extends GameObject{
    private boolean active;
    Fireball(GamePosition position) {
        super(position, 1, 0);
    }
    public boolean getActive(){
        return active;
    }
    public void setActive(boolean active){
        this.active = active;
    }
    public void move() {
        setVelX(1);
    }
}
