package src.main.java.clapierre;

import java.awt.*;
import java.util.List;

public class Level {
    private List<Rectangle> platforms;
    private Rectangle goal;

    public Level(List<Rectangle> platforms, Rectangle goal){
        this.platforms = platforms;
        this.goal = goal;
    }

    public List<Rectangle> getPlatforms(){
        return platforms;
    }

    public Rectangle getGoal(){
        return goal;
    }

    // Allows for "random" level generation, hold specific bosses or enemies, etc.
}
