package main.java.clapierre;

import javax.swing.*;

// Running this file runs the Integration Test version of the game, two characters controlled by wasd and arrow keys should spawn along with the floor and random platforms

public class UntitledCookingGame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Untitled Cooking Game");
		GamePanel gamePanel = new GamePanel();
		frame.add(gamePanel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
