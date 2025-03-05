package main.java.clapierre;

import java.awt.image.BufferedImage;

import main.java.clapierre.*;

public class PlayerOne extends Player {

	public PlayerOne(int x, int y) {
		super(x, y);
		this.entityName = "Player One";
		this.idleSprite = loadSprite("");
		this.jumpSprite = loadSprite("");
		this.attackSprite = loadSprite("");
		this.runSprite = loadSprite("");
	}
}