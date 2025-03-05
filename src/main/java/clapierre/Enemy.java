package main.java.clapierre;

public class Enemy extends Entity {
	public Enemy(int x, int y) {
		super(x, y);
		this.entityType = 1;
		this.entityName = "Enemy Entity";
	}

	public void trackPlayer() {
//    	Follow the player by telling the enemy to move to their current x y position
	}

	public void attackPlayer() {
//    	When close enough (player x,y - enemy x,y), attack in direction of player 
	}

}
