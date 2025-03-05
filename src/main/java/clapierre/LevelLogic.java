package main.java.clapierre;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.java.clapierre.*;

public class LevelLogic {
	public List<Rectangle> platforms;
	
	public LevelLogic() {
//		Creates and generates each level, also generates level continuation
		this.platforms = new ArrayList<>();
	}

	public Level generateLevel() {
//		Creates a list of Rectangles that still leave enough space to move around
		
//		RULES:
//		Players spawn on the floor (y = ymax), all levels involve climbing up to the boss in some way
//		Entire level is generated at once, frame zooms in on players to appear level is much larger
//		Platforms must generate with enough space for the player to walk underneath (platform.y - platform(below).y > player.height)
//		Generate platforms from the top corner of existing platforms to prevent colliding
//		Platforms can also generate at same y level, but offset to create larger platforms
//		Call generatePlayerSpawn and generateEnemySpawn, designate the spaces as spawns
//		Don't allow enemies to spawn while player is standing on spawn point, spawn as soon as bounding box is off (SpawnLogic needed)
		
		platforms.clear();
		
		int stdWidth = 100, stdHeight = 20;
		int curX = 100, curY = 400;
		
//		Currently spawns 10 platforms, will need adjustments
		for (int i = 0; i < 10; i++) {
			if (platforms.isEmpty()) {
				platforms.add(new Rectangle(curX, curY, stdWidth, stdHeight));
			}
			else {
//				Rectangle lastRec = platforms.getLast();		
				if (Math.random() > .25) {
					curX += (100 * Math.random());
				}
				if (Math.random() > .5) {
//					60 is set because it is current player height (3/5/25)
					curY -= Math.max(60, (120 * Math.random()));
				}
				platforms.add(new Rectangle(curX, curY, stdWidth, stdHeight));
			}
		}
		
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