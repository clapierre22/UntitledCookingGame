package main.java.clapierre;

public class Item extends Entity {
	int rarity;
//	User int score as Value

	public Item(int x, int y) {
		super(x, y);
		this.entityType = 2;
		this.pickup = true;
		this.rarity = 0;
		this.entityName = "Item Entity";
		this.sprite = loadSprite("");
	}

	public void setRarity(int newRarity) {
//    	0: Common, 1: Rare, 2: Epic, 3: Legendary
		rarity = newRarity;
	}

	public void setLevel(int newLevel) {
		level = newLevel;
		adjustScore();
	}

	public void setValue(int newValue) {
//    	Rarity + Level = Value (Score)
//    	Used to manually set score to specific value
		score = newValue;
	}

	public int getRarity() {
		return rarity;
	}

	public int getLevel() {
		return level;
	}

	public int getValue() {
		return score;
	}
}
