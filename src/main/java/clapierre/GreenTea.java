package main.java.clapierre;

public class GreenTea extends ScoreItem {
	public GreenTea(int x, int y) {
		super(x, y);
		this.sprite = loadSprite("");
		this.score = 50;
	}
}