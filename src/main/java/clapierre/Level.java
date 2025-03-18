package main.java.clapierre;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Level {
//	Make platforms a linked list: platforms are generated and drawn in order
	private List<Rectangle> platforms;
	protected Rectangle goal, bossSpawn;
	private Rectangle player1Spawn, player2Spawn;
	public List<Rectangle> enemySpawn;
	int levelNum;

	public Level(List<Rectangle> platforms, Rectangle goal, List<Rectangle> enemySpawn) {
		this.platforms = platforms;
		this.goal = goal;
		this.levelNum = 0;
		this.enemySpawn = enemySpawn;
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
