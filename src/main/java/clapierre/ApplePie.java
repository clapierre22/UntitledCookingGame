package main.java.clapierre;

public class ApplePie extends HealthItem {
	public ApplePie(int x, int y) {
		super(x, y);
		this.sprite = loadSprite("");
		this.health = 75;
	}
}