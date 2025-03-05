package main.java.clapierre;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;

public class Player extends Entity {
//	Weapons only
	List<Item> inventory;
	int score, xp;
	boolean holdsWeapon;

	BufferedImage idleSprite;
	BufferedImage jumpSprite;
	BufferedImage attackSprite;
	BufferedImage runSprite;

	public Player(int x, int y) {
		super(x, y);
		this.entityType = 0;
		this.speed = 4;
		this.xp = 0;
		this.entityName = "Player Entity";
		this.idleSprite = null;
		this.jumpSprite = null;
		this.attackSprite = null;
		this.runSprite = null;
		this.inventory = new ArrayList<>();
		this.facingRight = true;
		this.holdsWeapon = false;
	}
//    Uses key press to move around and attack

	public void pickup(Item item) {
		if (item instanceof WeaponItem) {
			inventory.add(item);
			holdsWeapon = true;
		}
		if (item instanceof ScoreItem) {
			score += item.getValue();
		}
		if (item instanceof HealthItem) {
			health += item.getHealth();
		}
	}

	public boolean holds(Item item) {
		return inventory.contains(item);
	}

	public boolean holdsWeapon() {
		return holdsWeapon;
	}

	public void progression(int xpEarned) {
//    	Xp is different from score, need to add battle logic that takes enemy level and multiplies it by 10 to get xpEarned
		xp += xpEarned;
		if (xp >= 1000) {
			levelUp();
			xp = xp - 1000;
		}
	}

	public void levelUp() {
		level++;
	}
}
