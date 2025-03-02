package src.main.java.clapierre;

import java.awt.image.BufferedImage;
import java.util.List;

public class Player extends Entity{
//	Weapons only
	List<Item> inventory;
	int score;
	
	BufferedImage idleSprite;
	BufferedImage jumpSprite;
	BufferedImage attackSprite;
	BufferedImage runSprite;
	
    public Player(int x, int y){
        super(x, y);
        this.entityType = 0;
        this.speed = 4;
        this.entityName = "Player Entity";
        this.idleSprite = null;
        this.jumpSprite = null;
        this.attackSprite = null;
        this.runSprite = null;
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
    
    protected BufferedImage loadSprite(String fileName) {
    	return null;
    }
}
