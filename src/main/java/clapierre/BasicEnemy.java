package src.main.java.clapierre;

import java.awt.*;

public class BasicEnemy extends Enemy{
    public BasicEnemy(int x, int y){
        super(x, y);
        this.speed = 3;
    }
    
    @Override
    public void draw(Graphics g) {
//    	Enemy specific graphic
    }
}
