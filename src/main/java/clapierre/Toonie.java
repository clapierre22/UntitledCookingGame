package main.java.clapierre;

public class Toonie extends ScoreItem {
	public Toonie(int x, int y) {
		super(x, y);
		this.sprite = loadSprite("");
		this.score = 20;
	}
}