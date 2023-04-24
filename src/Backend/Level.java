package Backend;

public class Level {
    private int level;
    private boolean complete;
    private int score;
    private int time;
    private Map levelMap;
    private Player player;
    Level(int level, Map map, Player player){
        this.level = level;
        levelMap = map;
        this.player = player;
    }
    public int getLevel(){
        return level;
    }
    public boolean getComplete(){
        return complete;
    }
    public void setComplete(boolean complete){
        this.complete = complete;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getTime(){
        return time;
    }
    public void setTime(int time){
        this.time = time;
    }
    public Map getMap() {
        return levelMap;
    }

}
