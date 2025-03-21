package main.java.clapierre;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

// Switch to Entity.java, extends to player and enemy seperately, but both have underlying entity logic anyway

public class Entity {
	String entityName;
	BufferedImage sprite;
	int x, y, width, height;
	int velocityX, velocityY;
	int health, damage;
	Rectangle ignoreGround, currentGround;
//    0: Player, 1: Enemy, 2: Item
	int entityType, level, score;
	boolean onGround, facingRight, attacking;
	boolean pickup;
	boolean holdsWeapon;
	int speed;
//    static final int SPEED = 4;
	static final int JUMP = -12;
	static final int GRAVITY = 1;

	public Entity(int x, int y) {
		this.entityName = "Entity";
		this.sprite = null;
		this.entityType = 2;
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 60;
		this.velocityX = 0;
		this.velocityY = 0;
		this.onGround = false;
		this.health = 100;
		this.damage = 5;
		this.pickup = false;
		this.speed = 0;
		this.level = 1;
		this.score = 0;
		this.facingRight = false;
		this.holdsWeapon = false;
		this.ignoreGround = null;
		this.currentGround = null;
		this.attacking = false;
	}

	public void moveLeft() {
		velocityX = -speed;
	}

	public void moveRight() {
		velocityX = speed;
	}

	public void stop() {
		velocityX = 0;
	}

	public void jump() {
		if (onGround) {
			velocityY = JUMP;
			onGround = false;
		}
	}
	
	public void drop() {
//		WIP
		if (onGround) {
			ignoreGround = currentGround;
//			velocityY= JUMP/4;
			onGround = false;
		}
	}

	public void attack() {
//		Mainly used by enemies, could be moved there
//		GamePanel will handle player attacks, and enemy logic is not yet implemented (enemy logic will have a player that the enemy is targeting, allowing for the player entity to already be stored)
		attacking = true;
	}

	public void update(List<Rectangle> platforms) {
		velocityY += GRAVITY; // Apply gravity
		x += velocityX;
		y += velocityY;

		// Collision detection with platforms
//        Maybe HashMap of LinkedList or HM of HM
//        Hash the x value, find the y value and check if the rectangle exists
//		onGround = false;
		for (Rectangle platform : platforms) {
			if (getBounds().intersects(platform)) {
//				currentGround = platform;
//				Check Dropping
				if (platform == ignoreGround && platform.y != GamePanel.FLOORY) {
					continue;
				}
//				When Falling
				if (velocityY > 0 && y + height <= platform.y + height) {
					y = platform.y - height;
					velocityY = 0;
					onGround = true;
					currentGround = platform;
					break;
				}
				
//				If needed, this code below would re-allow collisions from the bottom (prevents entity from jumping up through platforms)
//				if (velocityY < 0 && y >= platform.y + platform.height - 10) {
//					y = platform.y + platform.height;
//					velocityY = 0;
//					break;
//				}
			}
		}
		if (onGround) {
			ignoreGround = null;
		}

		// Keeps player inside GamePanel bounds
		if (x < 0) {
			x = 0;
		}
		
		if (x + width > GamePanel.WIDTH) {
			x = GamePanel.WIDTH - width;
		}
		
	}

	public Rectangle getBounds() {
		// Bounding Box
		return new Rectangle(x, y, width, height);
	}

	public void draw(Graphics g) {
		// Draw player
		if (sprite != null) {
			g.drawImage(sprite, x, y, width, height, null);
		} else {
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
		}
	}

	protected BufferedImage loadSprite(String fileName) {
//    	Still need to set specific directory for image files
		return null;
	}

	protected void adjustHealth() {
		health += (health * (level * .25));
	}

	protected void adjustScore() {
		score += (score * (level * .25));
	}

	public void setHealth(int newHealth) {
		health = newHealth;
	}

	public void setDamage(int newDamage) {
		damage = newDamage;
	}

	public void setName(String newName) {
		entityName = newName;
	}

	public void setType(int newType) {
		entityType = newType;
	}

	public void setPosition(int newX, int newY) {
		x = newX;
		y = newY;
	}

	public int getHealth() {
		return health;
	}

	public int getDamage() {
		return damage;
	}

	public String getName() {
		return entityName;
	}

	public int getType() {
		return entityType;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getLevel() {
		return level;
	}
	
	public void setDirection(boolean right) {
		facingRight = right;
	}

	public boolean facingRight() {
		return facingRight;
	}
	
	public boolean holdsWeapon() {
		return holdsWeapon;
	}
}
