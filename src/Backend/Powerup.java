package Backend;

public abstract class Powerup extends GameObject{
    private boolean taken;
    private int duration;
    private String name;
    Powerup(GamePosition position, String name){
        super(position, 0, 0);
        taken = false;
        this.name = name;
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
