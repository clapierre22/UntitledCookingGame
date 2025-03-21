package main.java.clapierre;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.java.clapierre.*;

public class LevelLogic {
	public List<Rectangle> platforms;
	List<Rectangle> enemySpawn;
	List<Rectangle> playerSpawn;
//	Taken from GamePanel
	int width, height;
	int stdWidth = 200, stdHeight = 10;
	Rectangle goal;
	
	public LevelLogic(int width, int height) {
//		Creates and generates each level, also generates level continuation
//		Could be linked list, but generated problems with entity ground detection. Array for now
		this.platforms = new ArrayList<>();
		this.enemySpawn = new ArrayList<>();
		this.width = width;
		this.height = height;
//		Goal width + height need to be changed to player width
		this.goal = new Rectangle(GamePanel.WIDTH - 40, GamePanel.FLOORY - 80, 40, 80);
	}

	public Level generateLevel() {
//		Creates a list of Rectangles that still leave enough space to move around
		
//		MAJOR CHANGE: 
//		Flat level, but when the level finishes (all enemies killed) it then allows the camera to move to the next place which is stairs up to another 
//		flat level, change the platform generation to be more even, less stair-like
		
//		Add:
//		Add transition level and level change
//		Add chests that spawn right before boss (health) and at specific loot islands (anything)
//		Add shop to buy health with score (or currency)
		
//		RULES:
//		Players spawn on the floor (y = ymax), all levels involve climbing up to the boss in some way
//		Entire level is generated at once, frame zooms in on players to appear level is much larger
//		Platforms must generate with enough space for the player to walk underneath (platform.y - platform(below).y > player.height)
//		Generate platforms from the top corner of existing platforms to prevent colliding
//		Platforms can also generate at same y level, but offset to create larger platforms
//		Call generatePlayerSpawn and generateEnemySpawn, designate the spaces as spawns
//		Don't allow enemies to spawn while player is standing on spawn point, spawn as soon as bounding box is off (SpawnLogic needed)
		
		platforms.clear();
		
//		int stdWidth = 200, stdHeight = 10;
		int curX = 0, curY = 95;
		
//		New Version - Set Generation
//		Note from GamePanel: (0,0) == Top Left Corner
		
		double type = Math.random();
//		boolean edge = false;
//		1 = Platform, 0 = None (Platforms next to each other still have space between to jump through) << Maybe change this to NOT, make space in TOWER
//		Note: Maybe make one slightly more common than the other? (if so, most likely grid)
		if (type > .75) {
//			GRID
//			10101
//			01010
//			10101
//			01010
//			10101
//			Floor
			
//			This generates the platforms starting at top corner and left to right down
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
			        if ((i + j) % 2 == 0) {
			            platforms.add(new Rectangle(curX, curY, stdWidth, stdHeight));
			        }
			        curX += GamePanel.WIDTH / 5;
			    }
			    curX = 0;
			    curY += 75;
			}
		}
		else if (.75 > type && type > .5) {
//			TOWER
//			00100
//			01010
//			10101
//			11011
//			10101
//			Floor
			
			for (int i = 0; i < 5; i++) {
				switch(i) {
				case 0 -> platforms.add(new Rectangle((GamePanel.WIDTH / 2) - (stdWidth / 2), curY, stdWidth, stdHeight));
				case 1 -> {
					platforms.add(new Rectangle((GamePanel.WIDTH * 1/3) - (stdWidth / 2), curY, stdWidth, stdHeight));
					platforms.add(new Rectangle((GamePanel.WIDTH * 2/3) - (stdWidth / 2), curY, stdWidth, stdHeight));
				}
				case 2, 4 -> {
//					Far Left
					platforms.add(new Rectangle(0, curY, stdWidth, stdHeight));
//					Middle
					platforms.add(new Rectangle((GamePanel.WIDTH / 2) - (stdWidth / 2), curY, stdWidth, stdHeight));
//					Far Right
					platforms.add(new Rectangle(GamePanel.WIDTH - stdWidth, curY, stdWidth, stdHeight));
				}
				case 3 -> {
					platforms.add(new Rectangle(0, curY, stdWidth, stdHeight));
					platforms.add(new Rectangle((GamePanel.WIDTH * 1/3) - (stdWidth / 2), curY, stdWidth, stdHeight));
					platforms.add(new Rectangle((GamePanel.WIDTH * 2/3) - (stdWidth / 2), curY, stdWidth, stdHeight));
					platforms.add(new Rectangle(GamePanel.WIDTH - stdWidth, curY, stdWidth, stdHeight));
				}
				}
			    curY += 75;
			}
		}
		else if (.5 > type && type > .25) {
//			EX
//			10001
//			01010
//			00100
//			01010
//			10001
//			Floor
			
			for (int i = 0; i < 5; i++) {
				switch(i) {
				case 0, 4 -> {
					platforms.add(new Rectangle(0, curY, stdWidth, stdHeight));
					platforms.add(new Rectangle(GamePanel.WIDTH - stdWidth, curY, stdWidth, stdHeight));
					
				}
				case 1, 3 -> {
					platforms.add(new Rectangle((GamePanel.WIDTH * 1/3) - (stdWidth / 2), curY, stdWidth, stdHeight));
					platforms.add(new Rectangle((GamePanel.WIDTH * 2/3) - (stdWidth / 2), curY, stdWidth, stdHeight));
				}
				case 2 -> {
					platforms.add(new Rectangle((GamePanel.WIDTH / 2) - (stdWidth / 2), curY, stdWidth, stdHeight));
				}
				}
			    curX = 0;
			    curY += 75;
			}
		}
		else {
//			CIRCLE
//			00100
//			01010
//			10101
//			01010
//			00100
//			Floor
			
			for (int i = 0; i < 5; i++) {
				switch(i) {
//				Only need one loop, add statements within the case switch
//				0,4: Top and base layer, spawns one platform in the middle
				case 0, 4 -> platforms.add(new Rectangle((GamePanel.WIDTH / 2) - (stdWidth / 2), curY, stdWidth, stdHeight));
//				1,3: Spawns two platforms evenly spaced
				case 1, 3 -> {
					platforms.add(new Rectangle((GamePanel.WIDTH * 1/3) - (stdWidth / 2), curY, stdWidth, stdHeight));
					platforms.add(new Rectangle((GamePanel.WIDTH * 2/3) - (stdWidth / 2), curY, stdWidth, stdHeight));
				}
//				Middle, Spawns same as Grid middle
				case 2 -> {
					platforms.add(new Rectangle(0, curY, stdWidth, stdHeight));
					platforms.add(new Rectangle((GamePanel.WIDTH / 2) - (stdWidth / 2), curY, stdWidth, stdHeight));
					platforms.add(new Rectangle(GamePanel.WIDTH - stdWidth, curY, stdWidth, stdHeight));
				}
				}
//			    curX += GamePanel.WIDTH / 5;
//			    curX = 0;
			    curY += 75;
			}
		}		
		
//		Rectangle goal = new Rectangle(GamePanel.WIDTH - 10, GamePanel.FLOORY, 40, 80);
		return new Level(platforms, goal, generateEnemySpawn());
	}

	private List<Rectangle> generatePlayerSpawn() {
//		Both players spawn on floor in bottom left corner of screen
		playerSpawn.add(new Rectangle(10, GamePanel.FLOORY, stdWidth, stdHeight));
		playerSpawn.add(new Rectangle(20, GamePanel.FLOORY, stdWidth, stdHeight));
		
		return playerSpawn;
	}

	private List<Rectangle> generateEnemySpawn() {
//		For each platform ~50% chance to spawn an enemy 
		for (Rectangle platform : platforms) {
			if (Math.random() > .5) {
//				First two constructors of rectangle are still testing, will have concrete variables in future
				enemySpawn.add(new Rectangle(platform.x + (stdWidth/2), platform.y - 60, stdWidth, stdHeight));
			}
		}
		return enemySpawn;
	}
	
	public boolean atGoal(Player player1, Player player2) {
//		Modify to ensure it is within the bounding box range, not just exact value
		return Math.abs(player1.x - goal.x) < player1.width
				&& Math.abs(player1.y - goal.y) < player1.height
				&& Math.abs(player2.x - goal.x) < player2.width
				&& Math.abs(player2.y - goal.y) < player2.height;
	}
	
//	private Rectangle generateExit() {
//		return null;
//	}

}