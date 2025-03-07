package main.java.clapierre;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.java.clapierre.*;

public class LevelLogic {
	public List<Rectangle> platforms;
//	Taken from GamePanel
	int width, height;
	
	public LevelLogic(int width, int height) {
//		Creates and generates each level, also generates level continuation
//		Could be linked list, but generated problems with entity ground detection. Array for now
		this.platforms = new ArrayList<>();
		this.width = width;
		this.height = height;
	}

	public Level generateLevel() {
//		Creates a list of Rectangles that still leave enough space to move around
		
//		MAJOR CHANGE: 
//		Flat level, but when the level finishes (all enemies killed) it then allows the camera to move to the next place which is stairs up to another 
//		flat level, change the platform generation to be more even, less stair-like
		
//		Add:
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
		
		int stdWidth = 200, stdHeight = 10;
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
//			11111
//			Floor
			
//			All functions are GRID
			for (int i = 0; i < 5; i++) {
//				while (!edge) {
//					platforms.add(new Rectangle(curX, curY, stdWidth, stdHeight));
////					Pull incremental values from WIDTH/5 in future version
//					curX += width/5;
////					Currently no gaps on side, but needs to be evenly spaced
//					if (width == (curX + stdWidth)) {
//						edge = true;
//						curX = 0;
//					}
//				}
//				curY += 70;	
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
		else if (.5 > type && type > .25) {
//			EX
//			10001
//			01010
//			00100
//			01010
//			10001
//			Floor
			
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
		else {
//			CIRCLE
//			00100
//			01010
//			10101
//			01010
//			00100
//			Floor
			
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
		
//		Old Version - completely random generation
		
//		Currently spawns 10 platforms, will need adjustments
//		for (int i = 0; i < 40; i++) {
//			if (platforms.isEmpty()) {
//				platforms.add(new Rectangle(curX, curY, stdWidth, stdHeight));
//			}
//			else {
////				Rectangle lastRec = platforms.getLast();
////				Need to fix, still a little rough
////				Maybe use fixed layouts with random chance for each one to spawn to ensure good level design
//				if (Math.random() > .25) {
//					if (Math.random() > .5) {
//						curX += (100 * Math.random());
//					}
//					else {
////						No longer generates as a stair
//						curX -= (100 * Math.random());
//					}
//				}
//				if (Math.random() > .9) {
////					60 is set because it is current player height (3/5/25)
////					^ Adjusted to 70 to be slightly above player height (prevents snapping to higher platforms when falling)
////					curY -= Math.max(60, (120 * Math.random()));
//					curY -= 70;
//				}
//				platforms.add(new Rectangle(curX, curY, stdWidth, stdHeight));
//			}
//		}
		
//		Call generatePlayerSpawn and generateEnemySpawn here
		
//		Find the highest platform, attach goal to that platform
		Rectangle goal = new Rectangle();
		return new Level(platforms, goal);
	}

	private List<Rectangle> generatePlayerSpawn() {
		return null;
	}

	private List<Rectangle> generateEnemySpawn() {
		return null;
	}

}