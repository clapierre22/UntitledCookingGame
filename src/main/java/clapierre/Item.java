package src.main.java.clapierre;

public class Item extends Entity{
	int rarity;
	int level;
	int value;
	
    public Item(int x, int y){
        super(x, y);
        this.entityType = 2;
        this.pickup = true;
        this.rarity = 0;
        this.level = 0;
        this.value = 0;
        this.entityName = "Item Entity";
    }
    
    public void setRarity(int newRarity) {
//    	0: Common, 1: Rare, 2: Epic, 3: Legendary
    	rarity = newRarity;
    }
    
    public void setLevel(int newLevel) {
    	level = newLevel;
    }
    
    public void setValue(int newValue) {
//    	Rarity + Level = Value (Score)
    	value = newValue;
    }
    
    public int getRarity() {
    	return rarity;
    }
    
    public int getLevel() {
    	return level;
    }
    
    public int getValue() {
    	return value;
    }
}
