package main.java.clapierre;

public class Loonie extends ScoreItem {
	public Loonie(int x, int y) {
		super(x, y);
		this.sprite = loadSprite("");
		this.score = 10;
	}
}