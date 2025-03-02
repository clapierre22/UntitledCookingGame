package src.main.java.clapierre;

import src.main.java.clapierre.*;

public class SpawnLogic {
	Level currentLevel;
	
	public SpawnLogic(Level currentLevel) {
//		Determine what type of enemies spawn depending on the generated level
//		Read what level the players are on, where they are in level (boss stage spawns boss)
		this.currentLevel = currentLevel;
//		Need to add x and y values for the spawn rectangles 
	}
	
	public PlayerOne player1Spawn() {
		return null;
	}
	
	public PlayerTwo player2Spawn() {
		return null;
	}
	
	public BasicEnemy enemySpawn() {
		return null;
	}
	
	public Boss bossSpawn() {
		return null;
	}
}