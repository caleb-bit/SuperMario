public abstract class Powerup extends GameObject{
    boolean taken;
    int duration;
    Powerup(GamePosition position){
        super(position, 0, 0);
    }
    private boolean getTaken(){
        return taken;
    }
    private void setTaken(boolean taken){
        this.taken = taken;
    }
    private int getDuration(){
        return duration;
    }
    private void setDuration(int duration){
        this.duration = duration;
    }
}
