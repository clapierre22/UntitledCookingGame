package main.java.clapierre;

import javax.swing.*;

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
