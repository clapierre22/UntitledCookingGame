package main.java.clapierre;

import java.awt.*;
import java.util.List;

public class Level {
	private List<Rectangle> platforms;
	private Rectangle goal, bossSpawn;
	private Rectangle player1Spawn, player2Spawn;
	private List<Rectangle> enemySpawn;
	int levelNum;

	public Level(List<Rectangle> platforms, Rectangle goal) {
		this.platforms = platforms;
		this.goal = goal;
		int levelNum = 0;
	}

	public List<Rectangle> getPlatforms() {
		return platforms;
	}

	public Rectangle getGoal() {
		return goal;
	}

	public Rectangle getBossSpawn() {
		return bossSpawn;
	}

	public Rectangle getP1Spawn() {
		return player1Spawn;
	}

	public Rectangle getP2Spawn() {
		return player2Spawn;
	}

	public List<Rectangle> getEnemySpawn() {
		return enemySpawn;
	}

	public void setLevelNum(int newNum) {
		levelNum = newNum;
	}

	public int getLevelNum() {
		return levelNum;
	}

	// Allows for "random" level generation, hold specific bosses or enemies, etc.
}
