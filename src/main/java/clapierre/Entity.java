package src.main.java.clapierre;

import java.awt.*;
import java.util.List;

// Switch to Entity.java, extends to player and enemy seperately, but both have underlying entity logic anyway

public class Entity {
	String entityName;
    int x, y, width, height;
    int velocityX, velocityY;
    int health, damage;
//    0: Player, 1: Enemy, 2: Item
    int entityType; 
    boolean onGround;
    boolean pickup;
    static final int SPEED = 4;
    static final int JUMP_POWER = -12;
    static final int GRAVITY = 1;

    public Entity(int x, int y) {
    	this.entityName = "Entity";
    	this.entityType = 2;
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 60;
        this.velocityX = 0;
        this.velocityY = 0;
        this.onGround = false;
        this.health = 100;
        this.damage = 10;
        this.pickup = false;
    }

    public void moveLeft() {
        velocityX = -SPEED;
    }

    public void moveRight() {
        velocityX = SPEED;
    }

    public void stop() {
        velocityX = 0;
    }

    public void jump() {
        if (onGround) {
            velocityY = JUMP_POWER;
            onGround = false;
        }
    }

    public void attack(){
        if (!onGround){
            // Air Attack
        }
        else{
            // Standard Attack
        }
    }

    public void update(List<Rectangle> platforms) {
        velocityY += GRAVITY; // Apply gravity
        x += velocityX;
        y += velocityY;

        // Collision detection with platforms
        for (Rectangle platform : platforms) {
            if (getBounds().intersects(platform)) {
                if (velocityY > 0) { // Falling down
                    y = platform.y - height;
                    velocityY = 0;
                    onGround = true;
                }
            }
        }

        // Keep player inside window bounds
        if (x < 0) x = 0;
        if (x + width > GamePanel.WIDTH) x = GamePanel.WIDTH - width;
    }

    public Rectangle getBounds() {
        // Bounding Box
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        // Draw player
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
    
}
