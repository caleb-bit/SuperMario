package Backend;

public abstract class Powerup extends GameObject{
    boolean taken;
    int duration;
    String name;
    Powerup(GamePosition position){
        super(position, 0, 0);
        taken = false;
    }
    public String getName(){
        return name;
    }
    public boolean getTaken(){
        return taken;
    }
    public void setTaken(boolean taken){
        this.taken = taken;
    }
    public int getDuration(){
        return duration;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
}
