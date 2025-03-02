package src.main.java.clapierre;

import java.util.ArrayList;

public class PlayerOne extends Entity{
//	Weapons only
	ArrayList<Item> inventory;
	int score;
	
    public PlayerOne(int x, int y){
        super(x, y);
        this.entityType = 0;
        this.entityName = "Player One Entity";
    }
//    Uses key press to move around and attack
    
    public void pickup(Item item) {
    	if (item instanceof WeaponItem) {
    		inventory.add(item);
    	}
    	if (item instanceof ScoreItem) {
    		score += item.getValue();
    	}
    	if (item instanceof HealthItem) {
    		health += item.getHealth();
    	}
    }
    
    public boolean holds(Item item) {
    	return inventory.contains(item);
    }
}
