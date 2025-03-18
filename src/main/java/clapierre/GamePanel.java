package main.java.clapierre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
	static final int WIDTH = 800, HEIGHT = 600;
//	(0,0) == Top Left Corner
	
//	Height of the floor, gives some room for later implementation of visual stats for players
	static final int FLOORY = 470;
	
	PlayerOne player1;
	PlayerTwo player2;
	
	static List<Enemy> enemies;
	
	List<Rectangle> platforms;
	Timer timer;
	
	LevelLogic ll = new LevelLogic(WIDTH, HEIGHT);
	Level testLevel = ll.generateLevel();

	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.CYAN);
		
//		Redundant use player outside of level logic, will use playerSpawn in future
		player1 = new PlayerOne(100, 300);
		player2 = new PlayerTwo(200, 300);
		
		platforms = new ArrayList<>();
//		Floor
		platforms.add(new Rectangle(0, FLOORY, WIDTH, 20));
		
		enemies = new ArrayList<>();
		
		if (!platforms.isEmpty()) {
			System.out.println("Platforms Generated, # of Platforms: " + platforms.size());
		}
		
//		LevelLogic ll = new LevelLogic(WIDTH, HEIGHT);
//		Level testLevel = ll.generateLevel();
		
		platforms.addAll(testLevel.getPlatforms());
		
		for (Rectangle spawn : testLevel.getEnemySpawn()) {
			enemies.add(new Enemy(spawn.x, spawn.y));
		}
		
//		Test platform
//		platforms.add(new Rectangle(150, 350, 200, 20));

		// 60 FPS
		timer = new Timer(16, this);
		timer.start();

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT -> player2.moveLeft();
					case KeyEvent.VK_RIGHT -> player2.moveRight();
					case KeyEvent.VK_UP -> player2.jump();
					case KeyEvent.VK_A -> player1.moveLeft();
					case KeyEvent.VK_D -> player1.moveRight();
					case KeyEvent.VK_W -> player1.jump();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
					player1.stop();
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player2.stop();
				}
			}
		});
		setFocusable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player1.update(platforms);
		player2.update(platforms);
//		Add check for both players being within the goal, which only is drawn when all enemies are dead (maybe add timer starts when both in before switching level)
		if (ll.atGoal(player1, player2)) { // Needs atGoal() in Player.java
//			Add change level logic, but cannot access level or level logic
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// Draw platforms
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		for (Rectangle platform : platforms) {
			g.fillRect(platform.x, platform.y, platform.width, platform.height);
		}
		
//		Draws test enemies
		g.setColor(Color.ORANGE);
		if (!GamePanel.enemies.isEmpty()) {
			for (Enemy enemy : GamePanel.enemies) {
				g.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
			}
		}
		
//		This is to draw the test characters, to be replaced with sprite logic
		g.setColor(Color.RED);
		g.fillRect(player1.getX(), player1.getY(), player1.width, player1.height);
		
		g.setColor(Color.BLUE);
		g.fillRect(player2.getX(), player2.getY(), player2.width, player2.height);
	}
	
//	public LinkedList<Enemy> listEnemy() {
//		
//	}
}
