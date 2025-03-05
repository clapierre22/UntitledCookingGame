package main.java.clapierre;

public class PlayerTwo extends Player {
	public PlayerTwo(int x, int y) {
		super(x, y);
		this.entityName = "Player Two";
		this.idleSprite = loadSprite("");
		this.jumpSprite = loadSprite("");
		this.attackSprite = loadSprite("");
		this.runSprite = loadSprite("");
	}
	// Different controlls, can hold different items, etc.
}
