package src.main.java.clapierre;

import java.awt.*;
import java.util.List;

public class Player {
    int x, y, width, height;
    int velocityX, velocityY;
    int health, damage;
    boolean onGround;
    static final int SPEED = 4;
    static final int JUMP_POWER = -12;
    static final int GRAVITY = 1;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 60;
        this.velocityX = 0;
        this.velocityY = 0;
        this.onGround = false;
        this.health = 100;
        this.damage = 10;
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
}
